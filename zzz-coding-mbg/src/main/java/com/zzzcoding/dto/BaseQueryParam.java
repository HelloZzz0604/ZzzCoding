package com.zzzcoding.dto;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.zzzcoding.webapi.CommonPage;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

@Data
public class BaseQueryParam {
    private String startAt;
    private String endAt;
    private Long page = 1L;
    private Long perPage = 10L;
    private String sortBy;
    private String sortOrder = "DESC";

    public <T> QueryWrapper<T> toBaseQueryWrapper(String startTime, String endTime) {
        QueryWrapper<T> queryWrapper = Wrappers.query();
        queryWrapper.ge(StringUtils.isNotEmpty(this.getStartAt()), startTime, this.getStartAt());
        queryWrapper.ge(StringUtils.isNotEmpty(this.getStartAt()), endTime, this.getStartAt()); // 增加结束时间的分区条件
        queryWrapper.le(StringUtils.isNotEmpty(this.getEndAt()), endTime, this.getEndAt());

        if (StringUtils.isNotEmpty(this.sortBy)) {
            queryWrapper.orderBy(StringUtils.isNotEmpty(this.sortBy), this.getSortOrder().equalsIgnoreCase("ASC"),
                    toUnderlineCase(this.sortBy));
        }

        return queryWrapper;
    }

    public <T> QueryWrapper<T> toBaseQueryWrapper() {
        return this.toBaseQueryWrapper("", "");
    }

    public String[] toUnderlineCase(String input) {
        String[] parts = input.split(",");
        return Arrays.stream(parts)
                .map(StrUtil::toUnderlineCase)
                .toArray(String[]::new);
    }
}
