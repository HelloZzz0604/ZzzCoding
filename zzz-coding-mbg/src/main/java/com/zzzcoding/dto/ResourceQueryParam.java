package com.zzzcoding.dto;

import lombok.Data;

@Data
public class ResourceQueryParam {
    private Long categoryId;
    private String name;
    private String url;
    private Integer perPage;
    private Integer page;
}
