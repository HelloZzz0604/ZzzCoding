package com.zzzcoding.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zzzcoding.model.ResourceCategory;
import com.zzzcoding.mapper.ResourceCategoryMapper;
import com.zzzcoding.service.IResourceCategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zzzcoding.webapi.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 资源分类表 服务实现类
 * </p>
 *
 * @author Wenjie Zhang
 * @since 2023-04-16
 */
@Service
public class ResourceCategoryServiceImpl extends BaseServiceImpl<ResourceCategoryMapper, ResourceCategory> implements IResourceCategoryService {
    @Autowired
    private ResourceCategoryMapper resourceCategoryMapper;
    @Override
    public List<ResourceCategory> listAll() {
        QueryWrapper<ResourceCategory> query = new QueryWrapper<>();
        List<ResourceCategory> list = resourceCategoryMapper.selectList(query);
        return list;
    }
}
