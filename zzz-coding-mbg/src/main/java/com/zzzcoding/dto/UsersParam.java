package com.zzzcoding.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author Wenjie Zhang
 * @date 3/10/2022 7:41 pm
 */
@Data
@ApiModel(value = "User", description = "user")
public class UsersParam implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "login name")
    @NotBlank(message = "login name cannot be null")
    private String userLogin;

    @ApiModelProperty(value = "password")
    @NotBlank(message = "password cannot be null")
    private String userPass;

    @ApiModelProperty(value = "nickname")
    @NotBlank(message = "nickname cannot be null")
    private String userNickname;

    @ApiModelProperty(value = "email")
    private String userEmail;

    @ApiModelProperty(value = "property")
    private String attribute;

    @ApiModelProperty(value = "website")
    private String userUrl;

    @ApiModelProperty(value = "display")
    private String displayName;
}

