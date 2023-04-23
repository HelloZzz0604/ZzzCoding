package com.zzzcoding.model;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 后台资源表
 * </p>
 *
 * @author Wenjie Zhang
 * @since 2022-10-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Resource对象", description="后台资源表")
public class Resource implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "resource_id", type = IdType.AUTO)
    private Long resourceId;

    @ApiModelProperty(value = "资源分类ID")
    private Long categoryId;

    @ApiModelProperty(value = "创建时间")
    @TableField(value = "create_time")
    private Date createTime;

    @ApiModelProperty(value = "资源名称")
    private String name;

    @ApiModelProperty(value = "资源URL")
    private String url;

    @ApiModelProperty(value = "描述")
    private String description;


}
