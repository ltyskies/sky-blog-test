package com.sky.dto;

import lombok.Data;

@Data
public class BlogTypesPageQueryDTO {

    //博客分类名
    private String typeName;

    //页码
    private int page;

    //每页显示记录数
    private int pageSize;
}
