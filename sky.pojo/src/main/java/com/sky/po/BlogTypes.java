package com.sky.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BlogTypes {
    private Long id;

    private String typeName;

    private int number;

    private String description;
}
