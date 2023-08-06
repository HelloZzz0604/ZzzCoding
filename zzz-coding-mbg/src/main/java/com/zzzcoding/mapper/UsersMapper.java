package com.zzzcoding.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.zzzcoding.dto.UsersPageQueryParam;
import com.zzzcoding.model.Users;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author Wenjie Zhang
 * @since 2022-10-03
 */
public interface UsersMapper extends BaseMapper<Users> {
    IPage<Users> findByPage(IPage<Users> page, @Param(Constants.WRAPPER) Wrapper<UsersPageQueryParam> wrapper);
    List<Users> selectByUsername(String username);

    int updateLastLoginByUserLogin(String username, Date lastLogin);
}
