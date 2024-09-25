package com.sky.vo;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "查询用户返回数据")
public class UserInfoVO {

    private Long id;

    private String username;


    private int age;

    private String brith;

    private String email;

    private String image;

    private int blogNumber;

    private String personalizedSignature;
}
