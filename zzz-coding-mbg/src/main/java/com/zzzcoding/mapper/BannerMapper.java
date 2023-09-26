package com.zzzcoding.mapper;

import com.zzzcoding.model.Banner;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * banner Mapper 接口
 * </p>
 *
 * @author Wenjie Zhang
 * @since 2023-08-29
 */
public interface BannerMapper extends BaseMapper<Banner> {
    int updateBannerStatus(Long bannerId, Integer status);
}
