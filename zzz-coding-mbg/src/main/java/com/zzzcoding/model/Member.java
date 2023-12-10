package com.zzzcoding.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

/**
 * Description: Model for Member
 *
 * @Author: Wenjie ZHANG
 * @Date: 3/12/2023 9:30 pm
 */
@Data
public class Member implements Serializable {
    private Long id;

    @NotBlank(message = "Email cannot be null.")
    private String email;

    @NotBlank(message = "Username cannot be null.")
    private String username;

    @NotBlank(message = "Password cannot be null.")
    private String password;

    private Integer status;

    private Date createTime;

    private String avatar;

    private String description;

}
