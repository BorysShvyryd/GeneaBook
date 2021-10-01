package com.borman.geneobook.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Set;

@Entity
public class LoggedUser implements UserDetails {

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

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roleSet;

    @NotBlank
    @Size(min = 8, max = 128)
//    @Pattern(regexp = "")
    private String password;

    @Transient
    private String confirmPassword;

    @NotNull
    private LocalDateTime dateRegisterLogin;

    private LocalDateTime dateUpdateLogin;

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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
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

    public LocalDateTime getDateRegisterLogin() {
        return dateRegisterLogin;
    }

    public LoggedUser setDateRegisterLogin(LocalDateTime dateRegisterLogin) {
        this.dateRegisterLogin = dateRegisterLogin;
        return this;
    }

    public LocalDateTime getDateUpdateLogin() {
        return dateUpdateLogin;
    }

    public LoggedUser setDateUpdateLogin(LocalDateTime dateUpdateLogin) {
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

    public Set<Role> getRole() {
        return roleSet;
    }

    public LoggedUser setRole(Set<Role> role) {
        this.roleSet = role;
        return this;
    }

    @Override
    public String toString() {
        return "LoggedUser{" +
                "id=" + id +
                ", nicName='" + nicName + '\'' +
                ", email='" + email + '\'' +
                ", roleSet=" + roleSet +
                ", password='" + password + '\'' +
                ", confirmPassword='" + confirmPassword + '\'' +
                ", dateRegisterLogin=" + dateRegisterLogin +
                ", dateUpdateLogin=" + dateUpdateLogin +
                ", userProfile=" + userProfile +
                '}';
    }
}
