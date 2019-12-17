package com.fmall.service;


import com.fmall.pojo.Users;
import com.fmall.pojo.bo.UserBO;

public interface UserService {

    /**
     * 判断用户是否存在
     * @param username
     * @return
     */
    public boolean queryUsernameIsExist(String username);

    public Users createUser(UserBO userBO);

    /**
     * 用户登录
     * @param userBO 用户名密码
     * @return
     *  users 用户对象
     */
    public Users queryUserForLogin(String username, String password);
}
