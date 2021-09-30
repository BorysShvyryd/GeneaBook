package com.borman.geneobook.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
public class LoggedUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 32)
    private String nicName;

    @Email
    @NotBlank
    @Size(max = 128)
    @Column(unique = true)
//    @Pattern(regexp = "")
    private String email;

    @NotBlank
    @Size(max = 128)
//    @Pattern(regexp = "")
    private String password;

    @Transient
    private String confirmPassword;

    @NotNull
    private LocalDate dateRegisterLogin;

    private LocalDate dateUpdateLogin;

    @OneToOne(fetch = FetchType.LAZY,
//            cascade =  CascadeType.ALL,
            mappedBy = "loggedUser")
    private UserProfile userProfile;


    public Long getId() {
        return id;
    }

    public LoggedUser setId(Long id) {
        this.id = id;
        return this;
    }

    public String getNicName() {
        return nicName;
    }

    public LoggedUser setNicName(String nicName) {
        this.nicName = nicName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public LoggedUser setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public LoggedUser setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public LoggedUser setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }

    public LocalDate getDateRegisterLogin() {
        return dateRegisterLogin;
    }

    public LoggedUser setDateRegisterLogin(LocalDate dateRegisterLogin) {
        this.dateRegisterLogin = dateRegisterLogin;
        return this;
    }

    public LocalDate getDateUpdateLogin() {
        return dateUpdateLogin;
    }

    public LoggedUser setDateUpdateLogin(LocalDate dateUpdateLogin) {
        this.dateUpdateLogin = dateUpdateLogin;
        return this;
    }
    public UserProfile getUserProfile() {
        return userProfile;
    }

    public LoggedUser setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
        return this;
    }

}
