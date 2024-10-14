package com.zzzcoding.mapper;

import com.zzzcoding.model.AdminRoleRelation;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zzzcoding.model.Resource;
import com.zzzcoding.model.Role;
import org.apache.ibatis.annotations.Param;


import java.util.List;

/**
 * <p>
 * 后台用户和角色关系表 Mapper 接口
 * </p>
 *
 * @author Wenjie Zhang
 * @since 2022-11-29
 */
public interface AdminRoleRelationMapper extends BaseMapper<AdminRoleRelation> {
    int insertList(@Param("list")List<AdminRoleRelation> adminRoleRelationList);

    List<Resource> getResourceList(@Param("userId") Long userId);

    List<Long> getAdminIdList(@Param("resourceId") Long resourceId);

    List<Role> getRoleList(@Param("userId") Long userId);
}
