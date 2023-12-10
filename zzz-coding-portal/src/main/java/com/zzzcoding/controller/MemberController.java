package com.zzzcoding.controller;

import com.zzzcoding.model.Member;
import com.zzzcoding.service.IMemberService;
import com.zzzcoding.webapi.ResultObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


/**
 * Description: Member Related API
 *
 * @Author: Wenjie ZHANG
 * @Date: 3/12/2023 9:11 pm
 */
@Controller
@RequestMapping("/account")
public class MemberController {

    @Autowired
    private IMemberService memberService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public ResultObject register(@Validated @RequestBody Member member) {
        memberService.register(member.getEmail(), member.getUsername(), member.getPassword());
        return ResultObject.success("success");
    }
}
