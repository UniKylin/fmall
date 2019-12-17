package com.fmall.pojo.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "用户对象BO", description = "客户端用户传入的数据封装在这里")
public class UserBO {
    @ApiModelProperty(value = "用户名", name = "username", example = "James Gosling", required = true)
    private String username;

    @ApiModelProperty(value = "密码", name = "password", example = "111111", required = true)
    private String password;

    @ApiModelProperty(value = "重复密码", name = "confirmPassword", example = "111111", required = false)
    private String confirmPassword;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}