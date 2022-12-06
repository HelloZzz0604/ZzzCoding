package com.zzzcoding.service;

import com.zzzcoding.model.Menu;
import com.zzzcoding.model.Role;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 后台用户角色表 服务类
 * </p>
 *
 * @author Wenjie Zhang
 * @since 2022-11-29
 */
public interface IRoleService extends IService<Role> {
    /**
     * Get menu list by user id
     * @param userId
     * @return
     */
    List<Menu> getMenuList(Long userId);
}
