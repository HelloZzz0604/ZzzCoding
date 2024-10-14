package com.zzzcoding.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zzzcoding.assist.RedisConstants;
import com.zzzcoding.mapper.AdminRoleRelationMapper;
import com.zzzcoding.model.AdminRoleRelation;
import com.zzzcoding.model.Resource;
import com.zzzcoding.model.Users;
import com.zzzcoding.service.IRedisService;
import com.zzzcoding.service.IUsersCacheService;
import com.zzzcoding.service.IUsersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


/**
 * @author Wenjie Zhang
 * @date 9/10/2022 11:37 pm
 */
@Service
@Slf4j
public class UsersCacheServiceImpl implements IUsersCacheService {
    @Lazy
    @Autowired
    private IUsersService usersService;

    @Autowired
    private IRedisService redisService;

    @Autowired
    private AdminRoleRelationMapper adminRoleRelationMapper;

    @Override
    public void delAdminUserByUserId(Long userId) {
        Users admin = usersService.getById(userId);
        if (admin != null) {
            redisService.del(RedisConstants.getAdminUserKey(admin.getUserLogin()));
        }
    }

    @Override
    public void delResourceListByUserId(Long userId) {
        redisService.del(RedisConstants.getAdminResourceKey(userId));
    }

    @Override
    public void delResourceListByRoleId(Long roleId) {
        log.info("Redis 根据角色ID{}查询user和role的关系", roleId);
        QueryWrapper<AdminRoleRelation> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("role_id", roleId);
        List<AdminRoleRelation> relations = adminRoleRelationMapper.selectList(queryWrapper);
        log.info("get user by role id {}", relations);

        if (CollUtil.isNotEmpty(relations)) {
            List<String> keys = relations.stream().map(
                    relation -> RedisConstants.getAdminResourceKey(relation.getUserId())
            ).collect(Collectors.toList());
            log.info("Redis delete keys {}", keys);
            redisService.del(keys);
        }
    }

    @Override
    public void delResourceListByRoleIds(List<Long> roleIds) {
        QueryWrapper<AdminRoleRelation> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("role_id", roleIds);
        List<AdminRoleRelation> relations = adminRoleRelationMapper.selectList(queryWrapper);
        if (CollUtil.isNotEmpty(relations)) {
            List<String> keys = relations.stream().map(
                    relation -> RedisConstants.getAdminResourceKey(relation.getUserId())
            ).collect(Collectors.toList());
            redisService.del(keys);
        }
    }

    @Override
    public void delResourceListByResourceId(Long resourceId) {
        List<Long> adminList = adminRoleRelationMapper.getAdminIdList(resourceId);
        if (CollUtil.isNotEmpty(adminList)) {
            List<String> keys = adminList.stream().map(
                    RedisConstants::getAdminResourceKey
            ).collect(Collectors.toList());
            redisService.del(keys);
        }
    }

    @Override
    public Users getAdminUserByUsername(String username) {
        return (Users) redisService.get(RedisConstants.getAdminUserKey(username));
    }

    @Override
    public void setAdminUser(Users users) {
        redisService.set(RedisConstants.getAdminUserKey(users.getUserLogin()), users, RedisConstants.REDIS_EXPIRE);
    }

    @Override
    public void setAdminToken(String username, String token) {
        redisService.set(RedisConstants.getAdminTokenKey(username) + token, token, RedisConstants.REDIS_EXPIRE);
    }

    @Override
    public String getAdminTokenByUsername(String username) {
        return (String) redisService.get(RedisConstants.getAdminTokenKey(username));
    }

    @Override
    public void delAdminTokenByUsername(String username, String token) {
        redisService.del(RedisConstants.getAdminTokenKey(username) + token);
    }

    @Override
    public List<Resource> getResourceListByUserId(Long userId){
        return (List<Resource>) redisService.get(RedisConstants.getAdminResourceKey(userId));
    }

    @Override
    public void setResourceList(Long adminId, List<Resource> resourceList) {
        redisService.set(RedisConstants.getAdminResourceKey(adminId), resourceList, RedisConstants.REDIS_EXPIRE);
    }

}

