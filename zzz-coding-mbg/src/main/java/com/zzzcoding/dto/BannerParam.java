package com.zzzcoding.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * Description: Params for Add Banner
 *
 * @Author: Wenjie ZHANG
 * @Date: 30/8/2023 12:23 am
 */
@Data
@ApiModel(value = "banner", description = "params for adding a new banner")
public class BannerParam implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "title")
    @NotBlank(message = "Banner title cannot be null.")
    private String title;

    @ApiModelProperty(value = "description")
    private String description;

    @ApiModelProperty(value = "image url")
    @NotBlank(message = "Image url cannot be null.")
    private String imgUrl;
}
