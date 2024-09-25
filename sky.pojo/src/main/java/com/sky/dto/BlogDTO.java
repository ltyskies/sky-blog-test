package com.sky.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@ApiModel(description = "博客传递的数据模型")
public class BlogDTO {
    private Long id;

    private Long ofTypes;

    private String blogName;

    private String text;

    private LocalDateTime releaseTime;

    private String image;

}
