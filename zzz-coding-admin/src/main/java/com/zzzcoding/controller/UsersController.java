package com.zzzcoding.controller;

import cn.hutool.core.collection.CollUtil;
import com.zzzcoding.dto.ResetPasswordParam;
import com.zzzcoding.dto.UsersLoginParam;
import com.zzzcoding.dto.UsersParam;
import com.zzzcoding.dto.UsersParamUpdate;
import com.zzzcoding.model.AdminUserDetails;
import com.zzzcoding.model.Role;
import com.zzzcoding.model.Users;
import com.zzzcoding.service.IRoleService;
import com.zzzcoding.service.IUsersService;
import com.zzzcoding.webapi.ResultObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Wenjie Zhang
 * @date 19/9/2022 10:34 pm
 */
@Controller
@Api(tags = "users")
@RequestMapping("/admin")
public class UsersController {

    @Autowired
    private IUsersService usersService;

    @Value("${jwt.tokenHeader}")
    private String tokenHeader;

    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @Autowired
    private IRoleService roleService;

    @ApiOperation("get users by id")
    @RequestMapping(value = "/getById", method = RequestMethod.GET)
    @ResponseBody
    public ResultObject<Users> getById(Long usersId) {
        Users users = usersService.getById(usersId);

        users.setUserPass(null);
        return ResultObject.success(users);
    }

    @ApiOperation("update selected user information")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public ResultObject<String> update(@Validated @RequestBody UsersParamUpdate usersParam) {
        if (usersParam.getUsersId() == null) {
            return ResultObject.failed("ID cannot be null");
        }

        Users users = new Users();
        BeanUtils.copyProperties(usersParam, users);
        return ResultObject.success(usersService.updateById(users) ? "success" : "fail");
    }


    @ApiOperation(value = "Register")
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public ResultObject<String> register(@Validated @RequestBody UsersParam users) {
        Users userDto = new Users();
        userDto.setUserRegistered(new Date());
        BeanUtils.copyProperties(users, userDto);
        return ResultObject.success(usersService.register(userDto) ? "success" : "fail");
    }

    @ApiOperation(value = "Login and generate token")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public ResultObject login(@Validated @RequestBody UsersLoginParam users) {
        String token = usersService.login(users.getUserLogin(), users.getUserPass());

        if (token == null) {
            return ResultObject.validateFailed("Username or password is not correct or this account is blocked.");
        }

        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", tokenHead);
        return ResultObject.success(tokenMap);
    }

    @ApiOperation(value = "refresh token")
    @RequestMapping(value = "/refreshToken", method = RequestMethod.GET)
    @ResponseBody
    public ResultObject refreshToken(HttpServletRequest request) {
        String token = request.getHeader(tokenHeader);
        String refreshToken = usersService.refreshToken(token);

        if (refreshToken == null) {
            return ResultObject.failed("Token is expired. Please re-login.");
        }

        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", refreshToken);
        tokenMap.put("tokenHead", tokenHead);
        return ResultObject.success(tokenMap);
    }

    @ApiOperation(value = "get admin info")
    @RequestMapping(value = "/info", method = RequestMethod.GET)
    @ResponseBody
    public ResultObject getAdminInfo(Principal principal) {
        if (principal == null) {
            return ResultObject.unauthorized(null);
        }
        AdminUserDetails adminUserDetails = (AdminUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Users users = adminUserDetails.getUsers();
        users.setUserPass(null);

        Map<String, Object> data = new HashMap<>();

        data.put("userDetail", adminUserDetails.getUsers());
        data.put("username", users.getUserLogin());
        data.put("menus", roleService.getMenuListByRole(users.getUsersId()));

        List<Role> roleList = usersService.getRoleList(users.getUsersId());
        if (CollUtil.isNotEmpty(roleList)) {
            List<String> roles = roleList.stream().map(Role::getName).collect(Collectors.toList());
            data.put("roles", roles);
        }
        return ResultObject.success(data);
    }

    @ApiOperation(value = "delete user by id")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public ResultObject<String> delete(long usersId) {
        return ResultObject.success(usersService.removeUser(usersId) ? "success" : "fail");
    }

    @ApiOperation(value = "Reset Password")
    @RequestMapping(value = "/reset", method = RequestMethod.POST)
    @ResponseBody
    public ResultObject<String> resetPassword(@Validated @RequestBody ResetPasswordParam resetPasswordParam) {
        int status = usersService.resetPassword(resetPasswordParam);
        if (status == 1) {
            return ResultObject.success("success");
        } else if (status == -1) {
            return ResultObject.failed("Invalid Parameter");
        } else if (status == -3) {
            return ResultObject.failed("Your old password is not correct.");
        } else {
            return ResultObject.failed();
        }
    }

    @ApiOperation(value = "log out")
    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    @ResponseBody
    public ResultObject logout() {
        return ResultObject.success(null);
    }
}
