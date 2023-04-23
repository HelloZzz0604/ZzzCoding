package com.zzzcoding.dto;

import lombok.Data;
import org.springframework.lang.Nullable;

@Data
public class ResourceQueryParam {
    private Long categoryId;

    private String name;

    private String url;
}
