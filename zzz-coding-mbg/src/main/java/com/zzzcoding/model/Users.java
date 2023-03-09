package com.zzzcoding.model;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author Wenjie Zhang
 * @since 2022-10-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Users对象", description="用户表")
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "users_id")
    @TableId(value = "users_id", type = IdType.AUTO)
    private Long usersId;

    @ApiModelProperty(value = "登录名")
    private String userLogin;

    @ApiModelProperty(value = "密码")
    private String userPass;

    @ApiModelProperty(value = "昵称")
    private String userNickname;

    @ApiModelProperty(value = "Email")
    private String userEmail;

    @ApiModelProperty(value = "网址")
    private String userUrl;

    @ApiModelProperty(value = "注册时间")
    private Date userRegistered;

    @ApiModelProperty(value = "激活码")
    private String userActivationKey;

    @ApiModelProperty(value = "用户状态")
    private Integer userStatus;

    @ApiModelProperty(value = "图像")
    private String displayName;

    @ApiModelProperty(value = "用户类型 0 :后台 1：前端")
    private Integer userType;

    @ApiModelProperty(value = "open_id")
    private String openId;

    @ApiModelProperty(value = "属性")
    private String attribute;


}
