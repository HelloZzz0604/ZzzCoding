package com.zzzcoding.controller;


import com.zzzcoding.dto.ResourceParam;
import com.zzzcoding.webapi.ResultObject;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @ApiOperation("Add resources")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public ResultObject<String> create(@RequestBody ResourceParam resourceParam) {
        return ResultObject.success("success");
    }
}

