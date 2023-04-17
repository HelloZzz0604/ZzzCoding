package com.zzzcoding.controller;


import com.zzzcoding.dto.BaseQueryParam;
import com.zzzcoding.webapi.ResultObject;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>
 * 资源分类表 前端控制器
 * </p>
 *
 * @author Wenjie Zhang
 * @since 2023-04-16
 */
@Controller
@RequestMapping("/resource-category")
public class ResourceCategoryController {
    @ApiOperation("Get resource category name")
    @RequestMapping(value = "/category/list", method = RequestMethod.GET)
    @ResponseBody
    public ResultObject list(BaseQueryParam baseQueryParam) {

        return ResultObject.success("success");
    }
}

