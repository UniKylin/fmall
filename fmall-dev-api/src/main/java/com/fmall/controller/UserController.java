package com.fmall.controller;

import com.fmall.pojo.Users;
import com.fmall.pojo.bo.UserBO;
import com.fmall.service.UserService;
import com.fmall.utils.JSONResult;
import com.fmall.utils.MD5Utils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(value = "用户注册登录", tags = "用户注册登录")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "用户名是否存在", notes = "用户名是否存在", httpMethod = "GET")
    @GetMapping("/passport/usernameIsExist")
    public JSONResult usernameIsExit(@RequestParam String username) {
        // 1. 判断用户名不能为空
        if (StringUtils.isBlank(username)) {
            return JSONResult.errorMsg("用户名不能为空");
        }

        // 2. 查找注册的用户是否存在
        boolean isUserExist = userService.queryUsernameIsExist(username);
        if (isUserExist) {
            return JSONResult.errorMsg("用户名已经存在");
        }

        // 3. 请求成功用户名没有重复
        return JSONResult.ok();
    }

    @ApiOperation(value = "用户注册", notes = "用户注册", httpMethod = "POST")
    @PostMapping("/passport/regist")
    public JSONResult register(@RequestBody UserBO userBO) {
        System.out.println(userBO.getUsername());
        String username = userBO.getUsername();
        String password = userBO.getPassword();
        String confirmPassword = userBO.getConfirmPassword();

        // 1. 判断用户名和密码不能为空
        if (StringUtils.isBlank(username) || StringUtils.isBlank(password) || StringUtils.isBlank(confirmPassword)) {
            return JSONResult.errorMsg("用户名、密码或者重复密码不能为空");
        }

        // 2. 查询用户是否存在
        boolean isUserExist = userService.queryUsernameIsExist(username);
        if (isUserExist) {
            return JSONResult.errorMsg("用户名已经存在");
        }

        // 3. 密码长度不能小于六位
        if (password.length() < 6) {
            return JSONResult.errorMsg("密码长度不能小于六位");
        }

        // 4. 两次输入密码必须一致
        if (!password.equals(confirmPassword)) {
            return JSONResult.errorMsg("两次密码输入不一致");
        }

        // 5. 注册成功
        userService.createUser(userBO);

        return JSONResult.ok();
    }


    @ApiOperation(value = "用户登录", notes = "用户登录", httpMethod = "POST")
    @PostMapping("/passport/login")
    public JSONResult login(@RequestBody UserBO userBO) throws Exception {
        String username = userBO.getUsername();
        String password = userBO.getPassword();

        // 1. 判断用户名和密码不能为空
        if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
            return JSONResult.errorMsg("用户名或者密码不能为空");
        }

        // 2. 实现用户登录
        Users userResult = userService.queryUserForLogin(username, MD5Utils.getMD5Str(password));
        if (userResult == null) {
            return JSONResult.errorMsg("用户名密码错误");
        }

        return JSONResult.ok(userResult);
    }
}
