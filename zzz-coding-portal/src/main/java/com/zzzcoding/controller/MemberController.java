package com.zzzcoding.controller;

import com.zzzcoding.mapper.MemberMapper;
import com.zzzcoding.model.Member;
import com.zzzcoding.service.IMemberService;
import com.zzzcoding.webapi.ResultObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


/**
 * Description: Member Related API
 *
 * @Author: Wenjie ZHANG
 * @Date: 3/12/2023 9:11 pm
 */

@Controller
@RequestMapping("/member")
public class MemberController {
    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @Autowired
    private MemberMapper memberMapper;

    @Autowired
    private IMemberService memberService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public ResultObject register(@Validated @RequestBody Member member) {
        int count = memberMapper.selectByEmail(member.getEmail()).size();
        if (count > 0) {
            return ResultObject.failed(80001, "This email is already taken. Please try another one.");
        }
        memberService.register(member.getEmail(), member.getUsername(), member.getPassword());
        return ResultObject.success("success");
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    @ResponseBody
    public ResultObject login(@RequestBody Map<String, String> loginDetails) {
        String loginValue = loginDetails.get("loginValue");
        String password = loginDetails.get("password");

        if (loginValue == null || password == null) {
            return ResultObject.failed(80003, "The given data is invalid.");
        }

        String token = memberService.login(loginValue, password);
        if (token == null) {
            return ResultObject.failed(80002, "Login name or password is incorrect.");
        }
        Map<String, Object> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", tokenHead);
        return ResultObject.success(tokenMap);
    }
}
