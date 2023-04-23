package com.zzzcoding.webapi;

import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.Data;
import org.springframework.lang.Nullable;

import java.util.List;

/**
 * Description: Common Page Settings
 *
 * @Author: Wenjie ZHANG
 * @Date: 16/4/2023 8:34 pm
 */
@Data
public class CommonPage<T> {
    private List<T> records;

    private Long currentPage;

    private Long perPage;

    private Long pages;

    private Long total;

    public static <T> CommonPage<T> toPageResponse(IPage<T> page) {
        CommonPage<T> response = new CommonPage<>();
        response.setRecords(page.getRecords());
        response.setCurrentPage(page.getCurrent());
        response.setPerPage(page.getSize());
        response.setPages(page.getPages());
        response.setTotal(page.getTotal());
        return response;
    }
}
