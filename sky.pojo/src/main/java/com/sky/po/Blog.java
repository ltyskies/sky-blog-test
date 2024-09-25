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
public class Blog {
    private Long id;

    private Long ofTypes;

    private String blogName;

    private String text;

    private LocalDateTime releaseTime;

    private String image;
}
