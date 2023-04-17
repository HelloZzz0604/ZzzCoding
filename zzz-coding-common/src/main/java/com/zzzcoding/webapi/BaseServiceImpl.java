package com.zzzcoding.webapi;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.Map;

/**
 * Description: Base Service
 *
 * @Author: Wenjie ZHANG
 * @Date: 16/4/2023 10:10 pm
 */
public class BaseServiceImpl<M extends BaseMapper<T>, T> extends ServiceImpl<M, T> implements BaseService<T> {
    @Override
    public IPage<T> pageQuery(CommonPage commonPage, QueryWrapper<T> queryWrapper) {
        Page<T> page = new Page<>(commonPage.getCurrentPage(), commonPage.getPerPage());
        return this.page(page, queryWrapper);
    }

    @Override
    public IPage<T> pageQuery(CommonPage commonPage, Map<String, Object> queryMap) {
        QueryWrapper<T> queryWrapper = Wrappers.query();
        queryWrapper.allEq(queryMap);
        return this.pageQuery(commonPage, queryWrapper);
    }
}
