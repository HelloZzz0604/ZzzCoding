package com.zzzcoding.service;

import com.zzzcoding.model.Banner;
import com.zzzcoding.webapi.BaseService;
import org.springframework.stereotype.Service;

/**
 * Description: Banner Service
 *
 * @Author: Wenjie ZHANG
 * @Date: 29/8/2023 11:20 pm
 */
public interface IBannerService extends BaseService<Banner> {
    boolean createBanner(Banner banner);

}
