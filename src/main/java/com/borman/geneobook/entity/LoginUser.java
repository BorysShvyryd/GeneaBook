package com.borman.geneobook.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "login_users")
public class LoginUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 32)
    private String nicName;

    @Email
    @NotBlank
    @Size(max = 100)
    @Column(unique = true)
//    @Pattern(regexp = "")
    private String email;

    @NotBlank
    @Size(max = 128)
//    @Pattern(regexp = "")
    private String password;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL,
            mappedBy = "loginUser")
    private GeneoUser fullDataUser;

    public Long getId() {
        return id;
    }

    public LoginUser setId(Long id) {
        this.id = id;
        return this;
    }

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
