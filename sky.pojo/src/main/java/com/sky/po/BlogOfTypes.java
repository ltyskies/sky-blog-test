package com.sky.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BlogOfTypes {
    private Long id;

    private Long ofTypes;

    private String blogName;

    private LocalDateTime releaseTime;

    private String image;
}
