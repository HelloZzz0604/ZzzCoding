package com.zzzcoding.service.impl;

import com.zzzcoding.exception.Asserts;
import com.zzzcoding.mapper.MemberMapper;
import com.zzzcoding.model.Member;
import com.zzzcoding.service.IMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;

/**
 * Description: Member Service
 *
 * @Author: Wenjie ZHANG
 * @Date: 3/12/2023 9:28 pm
 */
@Service
public class MemberServiceImpl implements IMemberService {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private MemberMapper memberMapper;

    @Override
    public void register(String email, String username, String password) {
        int count = memberMapper.selectByEmail(email).size();
        if (count > 0) {
            Asserts.fail("This email is already taken. Please try another one");
        }
        Member member = new Member();
        member.setUsername(username);
        member.setPassword(passwordEncoder.encode(password));
        member.setCreateTime(new Date());
        member.setEmail(email);
        member.setStatus(1);

        memberMapper.insert(member);
    }
}
