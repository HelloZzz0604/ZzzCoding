package com.zzzcoding.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Wenjie Zhang
 * @date 20/11/2022 5:33 pm
 */
@Data
@ApiModel(value = "Users", description = "Users table")
public class UsersParamUpdate implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long userId;

    @ApiModelProperty(value = "nickname")
    private String userNickname;

    @ApiModelProperty(value = "email")
    private String userEmail;

    @ApiModelProperty(value = "website")
    private String userUrl;

    @ApiModelProperty(value = "user display name")
    private String displayName;

    @ApiModelProperty(value = "user status")
    private Integer userStatus;
}

