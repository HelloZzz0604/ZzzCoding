package com.zzzcoding.mapper;

import com.zzzcoding.model.Member;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Description: Member Mapper
 *
 * @Author: Wenjie ZHANG
 * @Date: 3/12/2023 9:36 pm
 */
@Mapper
public interface MemberMapper {
    List<Member> selectByEmail(String email);

    int insert(Member member);

    List<Member> selectByEmailOrUsername(String loginValue);
}
