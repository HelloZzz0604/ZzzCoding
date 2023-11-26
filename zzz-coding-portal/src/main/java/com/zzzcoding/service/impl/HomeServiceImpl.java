package com.zzzcoding.service.impl;

import com.zzzcoding.mapper.BannerMapper;
import com.zzzcoding.model.Banner;
import com.zzzcoding.service.IHomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
/**
 * Description:
 *
 * @Author: Wenjie ZHANG
 * @Date: 28/9/2023 12:37 am
 */

@Service
public class HomeServiceImpl implements IHomeService {
    @Resource
    private BannerMapper bannerMapper;

    @Override
    public List<Banner> bannerList() {
        return bannerMapper.getBannerList();
    }
}
