package com.zzzcoding.service.impl;

import com.zzzcoding.model.Menu;
import com.zzzcoding.model.Role;
import com.zzzcoding.mapper.RoleMapper;
import com.zzzcoding.service.IRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 后台用户角色表 服务实现类
 * </p>
 *
 * @author Wenjie Zhang
 * @since 2022-11-29
 */
@Service
@Slf4j
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {
    @Autowired
    private RoleMapper roleMapper;
    @Override
    public List<Menu> getMenuList(Long userId) {return roleMapper.getMenuList(userId);}
}
