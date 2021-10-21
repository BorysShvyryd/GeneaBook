package com.borman.geneabook.entity;

import com.borman.geneabook.entity.Sex;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Name name;

    @NotNull
//    @Enumerated(EnumType.STRING)
//    @Column(length = 10)
//    private Gender gender;
    private Sex sex;

    @NotNull(message = "{javax.validation.constraints.NotNull.message_dateOfBirth}")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Past(message = "{javax.validation.constraints.Past.message_dateOfBirth}")
    private LocalDate dateOfBirth;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Past(message = "{javax.validation.constraints.Past.message_dateOfDeath}")
    private LocalDate dateOfDeath;

    @NotBlank
    @Size(max = 64)
    private String placeOfBirth;

//    private Address address;

    @OneToMany(fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    private List<com.borman.geneabook.entity.UserPhoto> userPhotoList;

    @OneToOne(fetch = FetchType.EAGER)
    private User user;

    private LocalDateTime registered;
    private LocalDateTime updated;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<Relationship> relationships;

    // Get&Set

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public LocalDate getDateOfDeath() {
        return dateOfDeath;
    }

    public void setDateOfDeath(LocalDate dateOfDeath) {
        this.dateOfDeath = dateOfDeath;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public LocalDateTime getRegistered() {
        return registered;
    }

    @PrePersist
    public void setRegistered() {
        this.registered = LocalDateTime.now();
    }

    public LocalDateTime getUpdated() {
        return updated;
    }

    @PreUpdate
    public void setUpdated() {
        this.updated = LocalDateTime.now();
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public List<Relationship> getRelationships() {
        return relationships;
    }

    public void setRelationships(List<Relationship> relationships) {
        this.relationships = relationships;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setRegistered(LocalDateTime registered) {
        this.registered = registered;
    }

    public void setUpdated(LocalDateTime updated) {
        this.updated = updated;
    }

    public List<com.borman.geneabook.entity.UserPhoto> getUserFotoList() {
        return userPhotoList;
    }

    public void setUserFotoList(List<com.borman.geneabook.entity.UserPhoto> userFotoList) {
        this.userPhotoList = userFotoList;
    }

    public List<com.borman.geneabook.entity.UserPhoto> getUserPhotoList() {
        return userPhotoList;
    }

    public void setUserPhotoList(List<com.borman.geneabook.entity.UserPhoto> userPhotoList) {
        this.userPhotoList = userPhotoList;
    }

    @Override
    public String toString() {
        return "UserProfile{" +
                "id=" + id +
                ", name=" + name +
                ", sex=" + sex +
                ", dateOfBirth=" + dateOfBirth +
                ", dateOfDeath=" + dateOfDeath +
                ", placeOfBirth='" + placeOfBirth + '\'' +
//                ", user=" + user +
                ", registered=" + registered +
                ", updated=" + updated +
//                ", familyTies=" + familyTies +
                '}';
    }

    @Embeddable
    public static class Name {

        @NotBlank(message = "{javax.validation.constraints.NotBlank.message_firstName}")
        @Size(max = 64, message = "{javax.validation.constraints.Size.message_firstName}")
        @Column(length = 64)
        private String firstName;

        @NotBlank
        @Size(max = 64)
        @Column(length = 64)
        private String lastName;

        @Size(max = 64)
        @Column(length = 64)
        private String middleName;

        public String getFirstName() {
            return firstName;
        }

        public Name setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public String getMiddleName() {
            return middleName;
        }

        public Name setMiddleName(String middleName) {
            this.middleName = middleName;
            return this;
        }

        public String getLastName() {
            return lastName;
        }

        public Name setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }
    }
}
