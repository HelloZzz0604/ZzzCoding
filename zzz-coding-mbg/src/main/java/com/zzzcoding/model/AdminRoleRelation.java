package com.zzzcoding.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 后台用户和角色关系表
 * </p>
 *
 * @author Wenjie Zhang
 * @since 2022-11-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="AdminRoleRelation对象", description="后台用户和角色关系表")
public class AdminRoleRelation implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "admin_role_relation_id", type = IdType.AUTO)
    private Long adminRoleRelationId;

    @ApiModelProperty(value = "用户id")
    private Long userId;

    @ApiModelProperty(value = "角色id")
    private Long roleId;


}
