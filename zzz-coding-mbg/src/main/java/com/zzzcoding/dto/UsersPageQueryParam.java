package com.zzzcoding.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;

/**
 * @author Wenjie Zhang
 * @date 29/9/2022 9:58 pm
 */
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "Users", description = "Users")
public class UsersPageQueryParam {
    long pageSize;
    long page;
    @ApiModelProperty("Username")
    String userLogin;
    @ApiModelProperty("Nickname")
    String userNickname;
    @ApiModelProperty("Role ID")
    Long roleId;
}
