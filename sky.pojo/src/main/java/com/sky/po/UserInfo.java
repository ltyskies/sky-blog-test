package com.sky.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserInfo {
    private static final long serialVersionUID = 1L;

    private Long id;

    private String username;

    private int age;

    private String brith;

    private String email;

    private String image;

    private int blogNumber;

    private String personalizedSignature;
}
