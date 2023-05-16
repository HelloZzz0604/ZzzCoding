package com.zzzcoding.dto;

import lombok.Data;
import org.springframework.lang.Nullable;

import java.util.Date;

@Data
public class ResourceQueryParam {
    private Date createTime;
    private Long categoryId;

    private String name;

    private String url;
}
