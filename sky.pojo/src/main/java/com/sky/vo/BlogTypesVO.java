package com.sky.vo;

import com.sky.po.Blog;
import com.sky.po.BlogOfTypes;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "查询博客分类返回数据")
public class BlogTypesVO {
    private Long id;

    private String typeName;

    private int number;

    private String description;

    private List<BlogOfTypes> blogs = new ArrayList<>();


}
