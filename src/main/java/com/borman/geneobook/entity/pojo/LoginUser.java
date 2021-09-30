package com.borman.geneobook.entity.pojo;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class LoginUser {

    @NotBlank
    @Size(max = 32)
    private String nicName;

    @Email
    @NotBlank
    @Size(max = 128)
    private String email;

    private String password;

    public String getNicName() {
        return nicName;
    }

    public LoginUser setNicName(String nicName) {
        this.nicName = nicName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public LoginUser setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public LoginUser setPassword(String password) {
        this.password = password;
        return this;
    }
}
