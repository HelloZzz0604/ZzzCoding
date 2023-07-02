package com.zzzcoding.service;

import com.zzzcoding.model.ResourceCategory;
import com.zzzcoding.webapi.BaseService;

import java.util.List;

/**
 * <p>
 * 资源分类表 服务类
 * </p>
 *
 * @author Wenjie Zhang
 * @since 2023-04-16
 */
public interface IResourceCategoryService extends BaseService<ResourceCategory> {
    List<ResourceCategory> listAll();
}
