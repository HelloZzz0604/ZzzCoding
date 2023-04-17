package com.zzzcoding.webapi;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * Description: Base Service
 *
 * @Author: Wenjie ZHANG
 * @Date: 16/4/2023 10:11 pm
 */
public interface BaseService<T> extends IService<T> {
    IPage<T> pageQuery(CommonPage commonPage, QueryWrapper<T> queryWrapper);

    IPage<T> pageQuery(CommonPage commonPage, Map<String, Object> queryMap);
}
