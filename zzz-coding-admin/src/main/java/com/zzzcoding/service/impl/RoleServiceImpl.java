package com.zzzcoding.service.impl;

import com.zzzcoding.model.Role;
import com.zzzcoding.mapper.RoleMapper;
import com.zzzcoding.service.IRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 后台用户角色表 服务实现类
 * </p>
 *
 * @author Wenjie Zhang
 * @since 2022-11-29
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

}
