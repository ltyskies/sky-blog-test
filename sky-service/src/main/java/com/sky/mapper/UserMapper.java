package com.sky.mapper;

import com.sky.po.UserInfo;
import com.sky.po.UserLogin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {


    /**
     * 用户登录
     * @param userLoginDTO
     * @return
     */
    @Select("select * from sky_own_blog.users where username = #{username}")
    UserLogin getByUsername(String username);
    /***
     * 查询用户信息
     * @return
     */

    @Select("select * from sky_own_blog.user_info where id = #{id}")
    UserInfo getInfo(Long id);

    /**
     * 更改个人信息
     * @param userInfo
     * @return
     */
    void update(UserInfo userInfo);


}
