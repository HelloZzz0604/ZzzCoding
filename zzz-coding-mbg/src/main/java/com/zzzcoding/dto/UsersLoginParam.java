package com.zzzcoding.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author Wenjie Zhang
 * @date 9/10/2022 9:48 pm
 */
@Data
@ApiModel(value = "User Login", description = "User Table")
public class UsersLoginParam implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "Login Name")
    @NotBlank(message = "Login name cannot be null.")
    private String userLogin;

    @ApiModelProperty(value = "Password")
    @NotBlank(message = "Password cannot be null.")
    private String userPass;
}

