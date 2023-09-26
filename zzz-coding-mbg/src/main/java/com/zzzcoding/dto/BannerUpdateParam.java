package com.zzzcoding.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * Description: params for updating banner
 *
 * @Author: Wenjie ZHANG
 * @Date: 14/9/2023 12:08 am
 */
@Data
public class BannerUpdateParam {
   @NotNull
    private Long bannerId;

   @NotNull
   private Integer status;
}
