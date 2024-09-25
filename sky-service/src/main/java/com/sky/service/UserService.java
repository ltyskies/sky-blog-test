package com.sky.service;


import com.sky.dto.UserInfoDTO;
import com.sky.dto.UserLoginDTO;
import com.sky.po.UserInfo;
import com.sky.po.UserLogin;

public interface UserService {

    /**
     * 用户登录
     * @param userLoginDTO
     * @return
     */
    UserLogin login(UserLoginDTO userLoginDTO);
        /***
     * 查询用户信息
     * @return
     */
    UserInfo getInfo();
    /**
     * 更改个人信息
     * @param userInfoDTO
     * @return
     */
    void update(UserInfoDTO userInfoDTO);
}
