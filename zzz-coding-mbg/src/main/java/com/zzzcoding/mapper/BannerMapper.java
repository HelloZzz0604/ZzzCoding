package com.zzzcoding.mapper;

import com.zzzcoding.model.Banner;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * banner Mapper 接口
 * </p>
 *
 * @author Wenjie Zhang
 * @since 2023-08-29
 */
@Mapper
@Component
public interface BannerMapper extends BaseMapper<Banner> {
    int updateBannerStatus(Long bannerId, Date updatedAt, Integer status);

    List<Banner> getBannerList();
}
