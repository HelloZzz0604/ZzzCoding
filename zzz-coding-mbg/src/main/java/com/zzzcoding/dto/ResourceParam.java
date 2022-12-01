package com.zzzcoding.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Wenjie Zhang
 * @date 9/10/2022 11:13 pm
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "Resource对象", description = "后台资源表")
public class ResourceParam implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long resourceId;

    @ApiModelProperty(value = "resource id")
    @NotNull(message = "resource id cannot be null")
    private Long categoryId;

    @ApiModelProperty(value = "create time")
    private Date createTime;

    @ApiModelProperty(value = "name")
    @NotBlank(message = "name cannot be empty")
    private String name;

    @ApiModelProperty(value = "url")
    @NotBlank(message = "url cannot be empty")
    private String url;

    @ApiModelProperty(value = "description")
    private String description;
}

