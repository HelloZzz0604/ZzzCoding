package com.zzzcoding.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class ResetPasswordParam {

    @NotEmpty
    @ApiModelProperty(value = "Username", required = true)
    private String username;

    @NotEmpty
    @ApiModelProperty(value = "Old Password", required = true)
    private String oldPassword;

    @NotEmpty
    @ApiModelProperty(value = "New Password", required = true)
    private String newPassword;
}
