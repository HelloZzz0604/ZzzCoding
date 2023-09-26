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
 * banner
 * </p>
 *
 * @author Wenjie Zhang
 * @since 2023-08-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Banner对象", description="banner")
public class Banner implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "banner_id")
    @TableId(value = "banner_id", type = IdType.AUTO)
    private Long bannerId;

    private String title;

    private String description;

    private Integer status;

    private Integer sort;

    @ApiModelProperty(value = "image url")
    private String imgUrl;

    @ApiModelProperty(value = "create time")
    private Date createdAt;

    @ApiModelProperty(value = "update time")
    private Date updatedAt;


}
