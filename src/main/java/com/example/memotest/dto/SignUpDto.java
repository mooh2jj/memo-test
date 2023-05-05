package com.example.memotest.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(description = "board AmiDeviceAddVo information")
@Data
@NoArgsConstructor
public class SignUpDto {

    @ApiModelProperty(value = "사용자 이름", dataType = "string", required = true)
    private String name;

    @ApiModelProperty(value = "사용자 이메일")
    private String email;
    private String password;
    private String role;

    @Builder
    public SignUpDto(String name, String email, String password, String role) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }
}
