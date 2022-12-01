package com.zzzcoding.service.impl;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zzzcoding.mapper.RoleResourceRelationMapper;
import com.zzzcoding.model.RoleResourceRelation;
import org.springframework.stereotype.Service;

@Service
public class RoleResourceRelationServiceImpl extends ServiceImpl<RoleResourceRelationMapper, RoleResourceRelation> implements IService<RoleResourceRelation> {
}
