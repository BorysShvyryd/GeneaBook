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

    public String getNicName() {
        return nicName;
    }

    public void setNicName(String nicName) {
        this.nicName = nicName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
