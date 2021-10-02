package com.borman.geneobook.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
public class User{

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

    private LocalDateTime dateRegisterLogin;

    private LocalDateTime dateUpdateLogin;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL,
            mappedBy = "user")
    private UserProfile userProfile;

    public Long getId() {
        return id;
    }

    public User setId(Long id) {
        this.id = id;
        return this;
    }

    public String getNicName() {
        return nicName;
    }

    public void setNicName(String nicName) {
        this.nicName = nicName;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return null;
//    }

    public String getPassword() {
        return password;
    }

//    @Override
//    public String getUsername() {
//        return email;
//    }

//    @Override
//    public boolean isAccountNonExpired() {
//        return false;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return false;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return false;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return false;
//    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public User setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }

    public LocalDateTime getDateRegisterLogin() {
        return dateRegisterLogin;
    }

    @PrePersist
    public void setDateRegisterLogin() {
        this.dateRegisterLogin = LocalDateTime.now();
    }

    public LocalDateTime getDateUpdateLogin() {
        return dateUpdateLogin;
    }

    @PreUpdate
    public void setDateUpdateLogin() {
        this.dateUpdateLogin = LocalDateTime.now();
    }

    public UserProfile getUserProfile() {
        return userProfile;
    }

    public User setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
        return this;
    }

    public Set<Role> getRoleSet() {
        return roleSet;
    }


    public void setRoleSet(Set<Role> roleSet) {
        this.roleSet = roleSet;
    }

    public User setDateRegisterLogin(LocalDateTime dateRegisterLogin) {
        this.dateRegisterLogin = dateRegisterLogin;
        return this;
    }

    public User setDateUpdateLogin(LocalDateTime dateUpdateLogin) {
        this.dateUpdateLogin = dateUpdateLogin;
        return this;
    }
//    public Set<Role> getRole() {
//        return roleSet;
//    }
//
//    public void setRole(Set<Role> role) {
//        this.roleSet = role;
//    }

    @Override
    public String toString() {
        return "User{" +
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

//    @Override
//    public void eraseCredentials() {
////        super.eraseCredentials();
////        if (this.userAuthentication != null && CredentialsContainer.class.isAssignableFrom(this.userAuthentication.getClass())) {
////            CredentialsContainer.class.cast(this.userAuthentication).eraseCredentials();
////        }
//    }
}
