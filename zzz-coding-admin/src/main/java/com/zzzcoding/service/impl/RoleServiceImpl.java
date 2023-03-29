package com.zzzcoding.service.impl;

import com.zzzcoding.model.Menu;
import com.zzzcoding.model.Role;
import com.zzzcoding.mapper.RoleMapper;
import com.zzzcoding.service.IRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public List<Menu> getMenuListByRole(Long userId) {
        List<Menu> menu = roleMapper.getMenuList(userId);
        List<Menu> childList = new ArrayList<>();
        List<Menu> result = new ArrayList<>();

        menu.stream().filter(sysMenu -> childList.stream().noneMatch(c -> c.getMenuId().equals(sysMenu.getMenuId()))).forEach(
                sysMenu -> {
                    for (Menu child: menu) {
                        if (sysMenu.getMenuId().equals(child.getParentId())) {
                            sysMenu.addChild(child);
                            child.setCreateTime(null);
                            childList.add(child);
                        }
                    }
                    sysMenu.setCreateTime(null);
                    result.add(sysMenu);
                }
        );
        return result;
    }
}
