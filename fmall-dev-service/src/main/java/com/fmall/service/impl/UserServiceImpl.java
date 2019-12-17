package com.fmall.service.impl;

import com.fmall.enums.Sex;
import com.fmall.mapper.UsersMapper;
import com.fmall.pojo.Users;
import com.fmall.pojo.bo.UserBO;
import com.fmall.service.UserService;
import com.fmall.utils.DateUtil;
import com.fmall.utils.MD5Utils;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;

/**
 *  control + i 迅速导入接口实现方法
 *  control + o 快速实现子类所有方法的快捷键
 */
@Service
public class UserServiceImpl implements UserService {

    public static final String AVATAR = "https://img.mukewang.com/54ff22bc00016c6301000100-140-140.jpg";

    @Autowired
    public Sid sid;

    @Autowired
    public UsersMapper usersMapper;

    /**
     * 查询用户名是否存在
     * @param username 查询的用户名
     * @return true: 存在  false: 不存在
     */
    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public boolean queryUsernameIsExist(String username) {
        Example userExample = new Example(Users.class);
        Example.Criteria userCriteria = userExample.createCriteria();

        // 查询条件
        userCriteria.andEqualTo("username", username);

        Users result = usersMapper.selectOneByExample(userExample);
        return result == null ? false : true;
    }

    @Override
    public Users createUser(UserBO userBO) {
        Users user = new Users();
        // 设置全局唯一ID
        user.setId(sid.nextShort());

        user.setUsername(userBO.getUsername());
        try {
            user.setPassword(MD5Utils.getMD5Str(userBO.getPassword()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 设置用户昵称同用户名
        user.setNickname(userBO.getUsername());
        // 使用默认头像
        user.setFace(AVATAR);

        // 设置默认生日
        user.setBirthday(DateUtil.stringToDate("2000-01-01"));

        // 设置性别为保密
        user.setSex(Sex.secret.type);

        user.setCreatedTime(new Date());
        user.setUpdatedTime(new Date());

        // 将数据同步到库中
        usersMapper.insert(user);

        return user;
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public Users queryUserForLogin(String username, String password) {
        Example userExample = new Example(Users.class);
        Example.Criteria userCriteria = userExample.createCriteria();

        userCriteria.andEqualTo("username", username);
        userCriteria.andEqualTo("password", password);

        Users result = usersMapper.selectOneByExample(userExample);
        return result;
    }
}
