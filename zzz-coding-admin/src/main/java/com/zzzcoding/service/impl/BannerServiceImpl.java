package com.zzzcoding.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zzzcoding.model.Banner;
import com.zzzcoding.mapper.BannerMapper;
import com.zzzcoding.service.IBannerService;
import com.zzzcoding.webapi.BaseServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * <p>
 * banner 服务实现类
 * </p>
 *
 * @author Wenjie Zhang
 * @since 2023-08-29
 */
@Service
@Slf4j
public class BannerServiceImpl extends BaseServiceImpl<BannerMapper, Banner> implements IBannerService {
    private static final Logger LOGGER = LoggerFactory.getLogger(BannerServiceImpl.class);

    @Autowired
    private IBannerService bannerService;

    @Override
    public boolean createBanner(Banner banner) {
        QueryWrapper<Banner> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("title", banner.getTitle());
        int count = this.baseMapper.selectCount(queryWrapper);
        if (count > 0) {
            return false;
        }

        return bannerService.save(banner);
    }
}
