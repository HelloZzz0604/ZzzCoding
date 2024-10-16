package com.zzzcoding.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zzzcoding.dto.ResetPasswordParam;
import com.zzzcoding.model.Resource;
import com.zzzcoding.model.Role;
import com.zzzcoding.model.Users;
import com.zzzcoding.webapi.BaseService;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;


/**
 * @author Wenjie Zhang
 * @date 19/9/2022 10:48 pm
 */

public interface IUsersService extends BaseService<Users> {
    /**
     * 根据用户名获取管理后台用户
     * @param username
     * @return
     */
    Users getAdminByUsername(String username);

    /**
     * 用户注册功能
     * @param users
     * @return
     */
    boolean register(Users users);

    /**
     * 登陆功能
     * @param username
     * @param password
     * @return
     */
    String login(String username, String password);

    /**
     * 刷新token
     * @param oldToken
     * @return
     */
    String refreshToken(String oldToken);

    /**
     * 获取用户信息
     * @param username
     * @return
     */
    UserDetails loadUserByUsername(String username);

    /**
     * 获取信息
     * @param adminId
     * @return
     */
    List<Resource> getResourceList(Long adminId);

    /**
     * get role list
     * @param adminId
     * @return
     */
    List<Role> getRoleList(Long adminId);

    boolean removeUser(Long userId);

    int resetPassword(ResetPasswordParam resetPasswordParam);
}
