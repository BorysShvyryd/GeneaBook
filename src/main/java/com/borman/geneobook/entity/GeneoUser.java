package com.borman.geneobook.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "full_user_data")
public class GeneoUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotBlank
    private Long id;

    @NotBlank
    @Size(max = 50)
    private String firstName;

    @NotBlank
    @Size(max = 50)
    private String lastName;

    @NotBlank
    @Enumerated(EnumType.STRING)
//    @Column(name = "sex" , columnDefinition=xxx ,nullable = false )
//    @Size(max = 25)
//    private Gender gender;
    private Sex sex;

    @NotBlank
    @Past
    private LocalDate dateOfBirth;

    @Past
    private LocalDate dateOfDeath;

    @NotBlank
    @Size(max = 50)
    private String placeOfBirth;

//    @Size(max = 100)
//    private String address1;
//
//    @Size(max = 100)
//    private String address2;
//
//    @Size(max = 100)
//    private String street;
//
//    @Size(max = 100)
//    private String city;
//
//    @Size(max = 100)
//    private String state;
//
//    @Size(max = 100)
//    private String country;
//
//    @Size(max = 32)
//    private String zipCode;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    private LoginUser loginUser;

    private LocalDateTime registered;
    private LocalDateTime updated;

    @ManyToMany
    private List<FamilyTies> familyTies;

    public Long getId() {
        return id;
    }

    public GeneoUser setId(Long id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public GeneoUser setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public GeneoUser setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public GeneoUser setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return this;
    }

    public LocalDate getDateOfDeath() {
        return dateOfDeath;
    }

    public GeneoUser setDateOfDeath(LocalDate dateOfDeath) {
        this.dateOfDeath = dateOfDeath;
        return this;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public GeneoUser setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
        return this;
    }

    public Sex getSex() {
        return sex;
    }

    public GeneoUser setSex(Sex sex) {
        this.sex = sex;
        return this;
    }

    public LoginUser getLoginUser() {
        return loginUser;
    }

    public GeneoUser setLoginUser(LoginUser loginUser) {
        this.loginUser = loginUser;
        return this;
    }

    public LocalDateTime getRegistered() {
        return registered;
    }

    public GeneoUser setRegistered(LocalDateTime registered) {
        this.registered = registered;
        return this;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }

    public GeneoUser setUpdated(LocalDateTime updated) {
        this.updated = updated;
        return this;
    }

    public List<FamilyTies> getFamilyTies() {
        return familyTies;
    }

    public GeneoUser setFamilyTies(List<FamilyTies> familyTies) {
        this.familyTies = familyTies;
        return this;
    }

    @Override
    public String toString() {
        return "GeneoUser{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", sex=" + sex +
                ", dateOfBirth=" + dateOfBirth +
                ", dateOfDeath=" + dateOfDeath +
                ", placeOfBirth='" + placeOfBirth + '\'' +
                ", loginUser=" + loginUser +
                ", registered=" + registered +
                ", updated=" + updated +
                ", familyTies=" + familyTies +
                '}';
    }
}
