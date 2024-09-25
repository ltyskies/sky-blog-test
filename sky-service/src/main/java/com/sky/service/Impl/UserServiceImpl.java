package com.sky.service.Impl;

import com.sky.constant.MessageConstant;
import com.sky.context.BaseContext;
import com.sky.dto.UserInfoDTO;
import com.sky.dto.UserLoginDTO;
import com.sky.exception.AccountNotFoundException;
import com.sky.exception.PasswordErrorException;
import com.sky.mapper.UserMapper;
import com.sky.po.UserInfo;
import com.sky.po.UserLogin;
import com.sky.service.UserService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.function.UnaryOperator;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserMapper userMapper;

    /**
     * 用户登录
     * @param userLoginDTO
     * @return
     */
    @Override
    public UserLogin login(UserLoginDTO userLoginDTO) {
        String username = userLoginDTO.getUsername();
        String password = userLoginDTO.getPassword();

        UserLogin userLogin = userMapper.getByUsername(username);

        if (userLogin == null) {
            //账号不存在
            throw new AccountNotFoundException(MessageConstant.ACCOUNT_NOT_FOUND);
        }

        password = DigestUtils.md5DigestAsHex(password.getBytes());
        if (!password.equals(userLogin.getPassword())) {
            //密码错误
            throw new PasswordErrorException(MessageConstant.PASSWORD_ERROR);
        }


        return userLogin;
    }
    /***
     * 查询用户信息
     * @return
     */
    @Override
    public UserInfo getInfo() {
        Long id = BaseContext.getCurrentId();
        UserInfo userInfo = userMapper.getInfo(id);
        return userInfo;
    }
    /**
     * 更改个人信息
     * @param userInfoDTO
     * @return
     */
    @Override
    public void update(UserInfoDTO userInfoDTO) {
        UserInfo userInfo = new UserInfo();
        BeanUtils.copyProperties(userInfoDTO, userInfo);
        userMapper.update(userInfo);
    }
}
