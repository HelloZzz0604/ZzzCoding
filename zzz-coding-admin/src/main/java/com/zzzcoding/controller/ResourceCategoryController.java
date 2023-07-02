package com.zzzcoding.controller;


import com.zzzcoding.dto.BaseQueryParam;
import com.zzzcoding.model.ResourceCategory;
import com.zzzcoding.service.IResourceCategoryService;
import com.zzzcoding.webapi.ResultObject;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * <p>
 * 资源分类表 前端控制器
 * </p>
 *
 * @author Wenjie Zhang
 * @since 2023-04-16
 */
@Controller
@RequestMapping("/resourceCategory")
public class ResourceCategoryController {
    @Autowired
    private IResourceCategoryService resourceCategoryService;

    @ApiOperation("Get resource category name")
    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    @ResponseBody
    public ResultObject listALl() {
        List<ResourceCategory> resourceCategoryList = resourceCategoryService.listAll();
        return ResultObject.success(resourceCategoryList);
    }
}

