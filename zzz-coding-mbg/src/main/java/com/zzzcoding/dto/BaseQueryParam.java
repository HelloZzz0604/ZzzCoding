package com.zzzcoding.dto;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

@Data
public class BaseQueryParam {
    private String startAt;
    private String endAt;
    private Integer page = 1;
    private Integer perPage = 10;
    private String orderKey;
    private String order = "DESC";

    public <T> QueryWrapper<T> toBaseQueryWrapper(String startTime, String endTime) {
        QueryWrapper<T> queryWrapper = Wrappers.query();
        queryWrapper.ge(StringUtils.isNotEmpty(this.getStartAt()), startTime, this.getStartAt());
        queryWrapper.ge(StringUtils.isNotEmpty(this.getStartAt()), endTime, this.getStartAt()); // 增加结束时间的分区条件
        queryWrapper.le(StringUtils.isNotEmpty(this.getEndAt()), endTime, this.getEndAt());

        if (StringUtils.isNotEmpty(this.orderKey)) {
            queryWrapper.orderBy(StringUtils.isNotEmpty(this.orderKey), this.getOrder().equalsIgnoreCase(this.order),
                    this.orderKey.split(","));
        }

        return queryWrapper;
    }

    public <T> QueryWrapper<T> toBaseQueryWrapper() {
        return this.toBaseQueryWrapper("", "");
    }
}
