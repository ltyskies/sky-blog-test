package com.sky.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserLogin implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    private String username;

    private String password;
}
