package com.zzzcoding.controller;

import com.zzzcoding.model.Banner;
import com.zzzcoding.service.IHomeService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.zzzcoding.webapi.ResultObject;

import java.util.List;

/**
 * Description: Controller for home page
 *
 * @Author: Wenjie ZHANG
 * @Date: 28/9/2023 12:22 am
 */

@Controller
@Api(tags = "HomeController")
@RequestMapping("/home")
public class HomeController {
    @Autowired
    private IHomeService homeService;

    @RequestMapping(value = "/banner", method = RequestMethod.GET)
    @ResponseBody
    public ResultObject banner() {
        List<Banner> bannerList = homeService.bannerList();
        return ResultObject.success(bannerList);
    }
}
