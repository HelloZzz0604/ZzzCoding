package com.zzzcoding.service.impl;

import com.zzzcoding.mapper.ResourceMapper;
import com.zzzcoding.model.Resource;
import com.zzzcoding.service.IResourceService;
import com.zzzcoding.service.IUsersCacheService;
import com.zzzcoding.webapi.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Wenjie Zhang
 * @date 9/10/2022 11:10 pm
 */
@Service
public class ResourceServiceImpl extends BaseServiceImpl<ResourceMapper, Resource> implements IResourceService {
    @Lazy
    @Autowired
    private IUsersCacheService usersCacheService;

    @Override
    public boolean remove(Long resourceId) {
        usersCacheService.delResourceListByResourceId(resourceId);
        return this.removeById(resourceId);
    }
}

