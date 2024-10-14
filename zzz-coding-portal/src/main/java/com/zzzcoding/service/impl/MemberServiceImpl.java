package com.zzzcoding.service.impl;

import com.zzzcoding.component.FormatChecker;
import com.zzzcoding.domain.MemberDetails;
import com.zzzcoding.exception.ApiException;
import com.zzzcoding.exception.Asserts;
import com.zzzcoding.mapper.MemberMapper;
import com.zzzcoding.model.Member;
import com.zzzcoding.service.IMemberService;
import com.zzzcoding.util.JwtTokenUtil;
import com.zzzcoding.webapi.ResultCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

/**
 * Description: Member Service
 *
 * @Author: Wenjie ZHANG
 * @Date: 3/12/2023 9:28 pm
 */
@Service
public class MemberServiceImpl implements IMemberService {
    private static final Logger LOGGER = LoggerFactory.getLogger(MemberServiceImpl.class);
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private MemberMapper memberMapper;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Override
    public void register(String email, String username, String password) {
        if (!FormatChecker.isValidEmail(email)) {
            Asserts.fail(ResultCode.INVALID_EMAIL_FORMAT);
        }

        Member member = new Member();
        member.setUsername(username);
        member.setPassword(passwordEncoder.encode(password));
        member.setCreateTime(new Date());
        member.setEmail(email);
        member.setStatus(1);

        memberMapper.insert(member);
    }

    public Member getMemberByEmailOrUsername(String loginValue) {
        Member member;
        List<Member> memberList = memberMapper.selectByEmailOrUsername(loginValue);

        if (!CollectionUtils.isEmpty(memberList)) {
            member = memberList.get(0);
            return member;
        }
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String loginValue) {
        Member member = getMemberByEmailOrUsername(loginValue);

        if (member != null) {
            return new MemberDetails(member);
        }
        throw new ApiException(ResultCode.USER_NOT_FOUND);
    }

    @Override
    public String login(String loginValue, String password) {
        String token = null;

        try {
            UserDetails userDetails = loadUserByUsername(loginValue);
            if (!passwordEncoder.matches(password, userDetails.getPassword())) {
                throw new BadCredentialsException("Password Error");
            }
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            token = jwtTokenUtil.generateToken(userDetails);
        } catch (AuthenticationException e) {
            LOGGER.warn("Login Error: {}", e.getMessage());
        }
        return token;
    }
}
