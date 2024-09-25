package com.sky.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(description = "修改用户信息传递的数据模型")
public class UserInfoDTO implements Serializable {

    private Long id;

    private String username;

    private int age;

    private String brith;

    private String email;

    private String image;

    private int blogNumber;

    private String personalizedSignature;
}
