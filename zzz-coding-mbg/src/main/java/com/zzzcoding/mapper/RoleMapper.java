package com.zzzcoding.mapper;

import com.zzzcoding.model.Menu;
import com.zzzcoding.model.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 后台用户角色表 Mapper 接口
 * </p>
 *
 * @author Wenjie Zhang
 * @since 2022-11-29
 */
public interface RoleMapper extends BaseMapper<Role> {
    List<Menu> getMenuList(@Param("userId") Long userId);
}
