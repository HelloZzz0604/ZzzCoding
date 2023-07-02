package com.zzzcoding.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zzzcoding.dto.ResourceParam;
import com.zzzcoding.model.Resource;
import com.zzzcoding.webapi.BaseService;
import org.apache.ibatis.executor.BaseExecutor;

import java.util.List;

/**
 * <p>
 * 后台资源表 服务类
 * </p>
 *
 * @author Wenjie Zhang
 * @date 9/10/2022 11:19 pm
 */
public interface IResourceService extends BaseService<Resource> {
    int delete(Long resourceId);

    int create(Resource resourceParam);

    int update(Long resourceId, Resource resource);

}
