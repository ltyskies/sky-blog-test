package com.sky.vo;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "查询博客返回数据")
public class BlogVO {
    private Long id;

    private Long ofTypes;

    private String blogName;

    private String text;

    private LocalDateTime releaseTime;

    private String image;
}
