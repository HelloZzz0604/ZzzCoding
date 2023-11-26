package com.zzzcoding.service;

import com.zzzcoding.model.Banner;

import java.util.List;

/**
 * Description: Service for home controller
 *
 * @Author: Wenjie ZHANG
 * @Date: 28/9/2023 12:37 am
 */

public interface IHomeService {
    /**
     * Home Banners
     * @return
     */
    List<Banner> bannerList();
}
