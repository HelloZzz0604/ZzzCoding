package com.zzzcoding.controller;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zzzcoding.dto.BannerParam;
import com.zzzcoding.dto.BannerUpdateParam;
import com.zzzcoding.dto.BaseQueryParam;
import com.zzzcoding.mapper.BannerMapper;
import com.zzzcoding.model.Banner;
import com.zzzcoding.service.IBannerService;
import com.zzzcoding.webapi.CommonPage;
import com.zzzcoding.webapi.ResultObject;
import io.swagger.annotations.Api;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Description: Controller for all banner related
 *
 * @Author: Wenjie ZHANG
 * @Date: 29/8/2023 12:44 am
 */
@Controller
@Api(tags = "Banner")
@RequestMapping("/banner")
public class BannerController {
    @Autowired
    private IBannerService bannerService;

    @Autowired
    private BannerMapper bannerMapper;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public ResultObject list(BaseQueryParam baseQueryParam, @RequestParam(value = "title", required = false) String title) {
        QueryWrapper<Banner> bannerQueryWrapper = baseQueryParam.toBaseQueryWrapper();
        if (StrUtil.isNotEmpty(title)) {
            bannerQueryWrapper.like("title", title);
        }
        Page<Banner> pagination = new Page<>(baseQueryParam.getPage(), baseQueryParam.getPerPage());
        return ResultObject.success(CommonPage.toPageResponse(bannerService.page(pagination, bannerQueryWrapper)));
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public ResultObject createBanner(@Validated @RequestBody BannerParam banner) {
        Banner bannerDto = new Banner();
        bannerDto.setCreatedAt(new Date());
        BeanUtils.copyProperties(banner, bannerDto);
        if (!bannerService.createBanner(bannerDto)) {
            return ResultObject.failed(10012, "Banner already exists.");
        }

        return ResultObject.success(bannerDto);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public ResultObject updateBannerStatus(@RequestBody BannerUpdateParam bannerUpdateParam) {
        Date currentDate = new Date();
        if (bannerMapper.updateBannerStatus(bannerUpdateParam.getBannerId(), currentDate, bannerUpdateParam.getStatus()) > 0) {
            Map<String, Date> resultMap = new HashMap<>();
            resultMap.put("updatedAt", currentDate);
            return ResultObject.success(resultMap);
        } else {
            return ResultObject.failed(10013, "Banner update failed.");
        }
    }
}
