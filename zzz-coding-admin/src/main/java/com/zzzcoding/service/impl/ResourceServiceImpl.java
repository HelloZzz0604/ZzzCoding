package com.zzzcoding.service.impl;

import cn.hutool.core.util.StrUtil;
import com.zzzcoding.dto.ResourceParam;
import com.zzzcoding.mapper.ResourceMapper;
import com.zzzcoding.model.Resource;
import com.zzzcoding.service.IResourceService;
import com.zzzcoding.service.IUsersCacheService;
import com.zzzcoding.webapi.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.Date;
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

    @Autowired
    private ResourceMapper resourceMapper;

    @Override
    public int delete(Long resourceId) {
        int count = resourceMapper.deleteByPrimaryKey(resourceId);
        usersCacheService.delResourceListByResourceId(resourceId);
        return count;
    }

    @Override
    public int create(Resource resourceParam) {
        if (StrUtil.isEmpty(resourceParam.getName()) || StrUtil.isEmpty(resourceParam.getUrl())) {
            return -1;
        }
        resourceParam.setCreateTime(new Date());
        return resourceMapper.insert(resourceParam);
    }

    @Override
    public int update(Long resourceId, Resource resource) {
        resource.setResourceId(resourceId);
        int count = resourceMapper.updateByPrimaryKeySelective(resource);
        usersCacheService.delResourceListByResourceId(resourceId);
        return count;
    }
}

