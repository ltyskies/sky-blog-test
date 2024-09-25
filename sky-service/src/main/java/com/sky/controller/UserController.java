package com.sky.controller;

import com.sky.constant.JwtClaimsConstant;
import com.sky.dto.UserInfoDTO;
import com.sky.dto.UserLoginDTO;
import com.sky.po.UserInfo;
import com.sky.po.UserLogin;
import com.sky.properties.JwtProperties;
import com.sky.result.Result;
import com.sky.service.UserService;
import com.sky.utils.JwtUtil;
import com.sky.vo.UserInfoVO;
import com.sky.vo.UserLoginVO;
import io.jsonwebtoken.Claims;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
@Slf4j
@Api(tags = "用户端相关接口")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtProperties jwtProperties;

    /**
     * 用户登录
     * @param userLoginDTO
     * @return
     */
    @PostMapping("/login")
    public Result<UserLoginVO> login(@RequestBody UserLoginDTO userLoginDTO) {
        log.info("用户登录");
        UserLogin userLogin = userService.login(userLoginDTO);

        Map<String,Object> claims = new HashMap<>();
        claims.put(JwtClaimsConstant.USER_ID,userLogin.getId());
        String token = JwtUtil.createJWT(
                jwtProperties.getUserSecretKey(),
                jwtProperties.getUserTtl(),
                claims
        );

        UserLoginVO userLoginVO = UserLoginVO.builder()
                .id(userLogin.getId())
                .userName(userLogin.getUsername())
                .token(token)
                .build();

        return Result.success(userLoginVO);
    }

    /***
     * 查询用户信息
     * @return
     */
    @GetMapping("/info")
    public Result<UserInfoVO> getInfo(){
        log.info("查询用户信息");
        UserInfo userInfo = userService.getInfo();

        UserInfoVO userInfoVO = new UserInfoVO();
        BeanUtils.copyProperties(userInfo,userInfoVO);
        return Result.success(userInfoVO);
    }

    /**
     * 更改个人信息
     * @param userInfoDTO
     * @return
     */
    @PutMapping("/info")
    public Result uodate(@RequestBody UserInfoDTO userInfoDTO){
        log.info("修改个人信息");
        userService.update(userInfoDTO);
        return Result.success();
    }


}
