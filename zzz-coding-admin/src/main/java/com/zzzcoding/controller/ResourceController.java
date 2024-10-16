package com.zzzcoding.controller;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zzzcoding.component.DynamicSecurityMetadataSource;
import com.zzzcoding.dto.BaseQueryParam;
import com.zzzcoding.dto.ResourceQueryParam;
import com.zzzcoding.model.Resource;
import com.zzzcoding.service.IResourceService;
import com.zzzcoding.webapi.CommonPage;
import com.zzzcoding.webapi.ResultObject;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;


/**
 * 后台资源表 前端控制器
 *
 * @author Wenjie Zhang
 * @since 2022-10-09
 */
@Controller
@RequestMapping("/resource")
public class ResourceController {
    @Autowired
    private IResourceService resourceService;

    @Autowired
    private DynamicSecurityMetadataSource dynamicSecurityMetadataSource;

    @ApiOperation("Add resources")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public ResultObject<String> create(@RequestBody Resource resourceParam) {
        int count = resourceService.create(resourceParam);
        dynamicSecurityMetadataSource.clearDatasource();
        if (count > 0) {
            return ResultObject.success("success");
        } else {
            return ResultObject.failed(10009, "The resource is unable to be created.");
        }
    }

    @ApiOperation("Delete Resource")
    @RequestMapping(value="/delete/{resourceId}", method = RequestMethod.POST)
    @ResponseBody
    public ResultObject delete(@PathVariable Long resourceId) {
        int count = resourceService.delete(resourceId);
        dynamicSecurityMetadataSource.clearDatasource();
        if (count > 0) {
            return ResultObject.success(count);
        } else {
            return ResultObject.failed(10010, "The resource is unable to be deleted.");
        }
    }

    @ApiOperation("Edit Resource")
    @RequestMapping(value = "/update/{resourceId}", method = RequestMethod.POST)
    @ResponseBody
    public ResultObject update(@PathVariable Long resourceId, @RequestBody Resource resource) {
        int count = resourceService.update(resourceId, resource);
        dynamicSecurityMetadataSource.clearDatasource();
        if (count > 0 ) {
            return ResultObject.success("success");
        } else {
            return ResultObject.failed(10011, "The resource is unable to be updated.");
        }
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
            resourceQueryWrapper.eq("category_id", resourceQueryParam.getCategoryId());
        }
        Page<Resource> pagination = new Page<>(baseQueryParam.getPage(), baseQueryParam.getPerPage());
        return ResultObject.success(CommonPage.toPageResponse(resourceService.page(pagination, resourceQueryWrapper)));
    }
}

