package com.zzzcoding.controller;


import com.zzzcoding.service.IMenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

/**
 * <p>
 * 后台菜单表 前端控制器
 * </p>
 *
 * @author Wenjie Zhang
 * @since 2022-12-04
 */
@Controller
@Api(tags = "MenuController")
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    private IMenuService menuService;

}

