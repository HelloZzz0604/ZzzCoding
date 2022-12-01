package com.zzzcoding.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Wenjie Zhang
 * @date 28/11/2022 11:01 pm
 * 和数据库对应
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "Role", description = "role table")
public class RoleParam implements Serializable {
    private static final long serialVersionId = 1L;

    private Long roleId;

    @ApiModelProperty(value = "name")
    @NotBlank(message = "name cannot be null")
    private String name;

    @ApiModelProperty(value = "description")
    private String description;

    @ApiModelProperty(value = "create time")
    private Date createTime;

    @ApiModelProperty(value = "status")
    @NotBlank(message = "status cannot be null")
    private Integer status;
}
