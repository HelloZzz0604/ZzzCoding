package com.zzzcoding.controller;


import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zzzcoding.dto.ResourceParam;
import com.zzzcoding.dto.BaseQueryParam;
import com.zzzcoding.dto.ResourceQueryParam;
import com.zzzcoding.model.Resource;
import com.zzzcoding.service.IResourceService;
import com.zzzcoding.webapi.ResultObject;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * <p>
 * 后台资源表 前端控制器
 * </p>
 *
 * @author Wenjie Zhang
 * @since 2022-10-09
 */
@Controller
@RequestMapping("/resource")
public class ResourceController {
    @Autowired
    private IResourceService resourceService;

    @ApiOperation("Add resources")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public ResultObject<String> create(@RequestBody ResourceParam resourceParam) {
        return ResultObject.success("success");
    }

    @ApiOperation("Resource list")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public ResultObject list(BaseQueryParam baseQueryParam, ResourceQueryParam resourceQueryParam) {
        QueryWrapper<Resource> resourceQueryWrapper = baseQueryParam.toBaseQueryWrapper();
        if (StrUtil.isNotEmpty(resourceQueryParam.getName())) {
            resourceQueryWrapper.like("name", "%" + resourceQueryParam.getName() + "%");
        }
        if (StrUtil.isNotEmpty(resourceQueryParam.getUrl())) {
            resourceQueryWrapper.like("url", "%" + resourceQueryParam.getUrl() + "%");
        }
        if (resourceQueryParam.getCategoryId() != null) {
            resourceQueryWrapper.eq("categoryId", resourceQueryParam.getCategoryId());
        }
        Page<Resource> pagination = new Page<>(baseQueryParam.getPage(), baseQueryParam.getPerPage());
        return ResultObject.success(resourceService.page(pagination, resourceQueryWrapper));
    }
}

