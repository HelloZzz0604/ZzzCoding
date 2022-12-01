package com.zzzcoding.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zzzcoding.model.Resource;

/**
 * <p>
 * 后台资源表 服务类
 * </p>
 *
 * @author Wenjie Zhang
 * @date 9/10/2022 11:19 pm
 */
public interface IResourceService extends IService<Resource> {
    boolean remove(Long resourceId);
}
