package com.sky.dto;

import lombok.Data;

@Data
public class BlogPageQueryDTO {

    //博客名
    private String blogName;

    //页码
    private int page;

    //每页显示记录数
    private int pageSize;
}
