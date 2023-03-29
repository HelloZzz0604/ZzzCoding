package com.zzzcoding.model;

import com.baomidou.mybatisplus.annotation.IdType;

import java.util.ArrayList;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 后台菜单表
 * </p>
 *
 * @author Wenjie Zhang
 * @since 2022-12-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Menu对象", description="后台菜单表")
public class Menu implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "menu_id", type = IdType.AUTO)
    private Long menuId;

    @ApiModelProperty(value = "parent id")
    private Long parentId;

    @ApiModelProperty(value = "create time")
    private Date createTime;

    @ApiModelProperty(value = "title")
    private String title;

    @ApiModelProperty(value = "level")
    private Integer level;

    @ApiModelProperty(value = "sort")
    private Integer sort;

    @ApiModelProperty(value = "name")
    private String name;

    @ApiModelProperty(value = "icon")
    private String icon;

    @ApiModelProperty(value = "hidden")
    private Integer hidden;

    @ApiModelProperty(value = "path")
    private String path;

    @TableField(exist = false)
    private List<Menu> children;

    public void addChild(Menu menu) {
        if (children == null) {
            children = new ArrayList<>();
        }
        children.add(menu);
    }
}
