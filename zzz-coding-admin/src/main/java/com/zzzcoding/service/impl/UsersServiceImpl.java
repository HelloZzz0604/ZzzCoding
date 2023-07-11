package com.zzzcoding.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zzzcoding.dto.ResetPasswordParam;
import com.zzzcoding.exception.Asserts;
import com.zzzcoding.mapper.AdminRoleRelationMapper;
import com.zzzcoding.mapper.UsersMapper;
import com.zzzcoding.model.*;
import com.zzzcoding.service.IUsersCacheService;
import com.zzzcoding.service.IUsersService;
import com.zzzcoding.util.JwtTokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.zzzcoding.state.UserType;
import com.zzzcoding.state.UserStatus;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author Wenjie Zhang
 * @date 28/9/2022 12:14 am
 */
@Service
@Slf4j
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements IUsersService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UsersServiceImpl.class);

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private IUsersCacheService usersCacheService;

    @Autowired
    private AdminRoleRelationMapper adminRoleRelationMapper;

    @Override
    public Users getAdminByUsername(String username) {
        QueryWrapper<Users> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_login", username);
        List<Users> usersList = baseMapper.selectList(queryWrapper);

        if (usersList != null && usersList.size() > 0) {
            return usersList.get(0);
        }

        throw new UsernameNotFoundException("The username is wrong.");
    }

    @Override
    public boolean register(Users users) {
        QueryWrapper<Users> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_login", users.getUserLogin());
        int count = this.baseMapper.selectCount(queryWrapper);
        if (count > 0) {
            //用户已经注册过
            return false;
        }
        users.setUserRegistered(new Date());
        users.setUserType(UserType.BACKEND.getUserType());
        users.setUserStatus(UserStatus.ENABLE.getUserStatus());
        String encodePassword = passwordEncoder.encode(users.getUserPass());
        users.setUserPass(encodePassword);

        return save(users);
    }

    @Override
    public String login(String username, String password) {
        String token = null;

        try {
            UserDetails userDetails = loadUserByUsername(username);

            if (!passwordEncoder.matches(password, userDetails.getPassword())) {
                Asserts.fail("Password is not correct.");
            }

            if (!userDetails.isEnabled()) {
                Asserts.fail("The account is disabled.");
            }

            token = jwtTokenUtil.generateToken(userDetails);
        } catch ( AuthenticationException e) {
            LOGGER.warn("Login fails: {}", e.getMessage());
        }

        return token;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        Users admin = getAdminByUsername(username);
        if (admin != null) {
            List<Resource> resourceList = getResourceList(admin.getUsersId());
            return new AdminUserDetails(admin, resourceList);
        }
        throw new UsernameNotFoundException("Username or password is incorrect.");
    }

    @Override
    public List<Resource> getResourceList(Long adminId) {
        log.info("Get resource by admin {}", adminId);
        List<Resource> resourceList = usersCacheService.getResourceListByUserId(adminId);

        log.info("Redis user role is {}", resourceList);
        if (CollUtil.isNotEmpty(resourceList)) {
            return resourceList;
        }

        resourceList = adminRoleRelationMapper.getResourceList(adminId);
        log.info("size {}, context {}", resourceList.size(), resourceList);
        if (CollUtil.isNotEmpty(resourceList)) {
            usersCacheService.setResourceList(adminId, resourceList);
        }
        return resourceList;
    }

    @Override
    public String refreshToken(String oldToken) {
        return jwtTokenUtil.refreshHeadToken(oldToken);
    }

    @Override
    public List<Role> getRoleList(Long adminId) { return adminRoleRelationMapper.getRoleList(adminId); }

    @Override
    public boolean removeUser(Long userId) {
        QueryWrapper<AdminRoleRelation> query = new QueryWrapper<>();
        query.eq("users_id", userId);
        adminRoleRelationMapper.delete(query);
        return this.removeById(userId);
    }

    @Override
    public int resetPassword(ResetPasswordParam resetPasswordParam) {
        if (StrUtil.isEmpty(resetPasswordParam.getUsername()) || StrUtil.isEmpty(resetPasswordParam.getNewPassword()) || StrUtil.isEmpty(resetPasswordParam.getOldPassword())) {
            return -1;
        }
        Users users = getAdminByUsername(resetPasswordParam.getUsername());
        if(!passwordEncoder.matches(resetPasswordParam.getOldPassword(),users.getUserPass())){
            return -3;
        }
        String newPassword = passwordEncoder.encode(resetPasswordParam.getNewPassword());
        users.setUserPass(newPassword);
        baseMapper.updateById(users);
        usersCacheService.delAdminUserByUserId(users.getUsersId());
        return 1;
    }
}
