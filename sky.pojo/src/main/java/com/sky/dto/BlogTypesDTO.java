package com.sky.dto;


import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel(description = "博客分类传递的数据模型")
public class BlogTypesDTO {
    private Long id;

    private String typeName;

    private int number;

    private String description;
}
