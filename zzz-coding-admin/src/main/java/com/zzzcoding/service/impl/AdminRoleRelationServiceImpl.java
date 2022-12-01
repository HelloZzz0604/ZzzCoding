package com.zzzcoding.service.impl;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zzzcoding.mapper.AdminRoleRelationMapper;
import com.zzzcoding.model.AdminRoleRelation;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 后台用户和角色关系表 服务实现类
 * </p>
 *
 * @author Wenjie Zhang
 * @since 2022-11-29
 */
@Service
public class AdminRoleRelationServiceImpl extends ServiceImpl<AdminRoleRelationMapper, AdminRoleRelation> implements IService<AdminRoleRelation> {

}
