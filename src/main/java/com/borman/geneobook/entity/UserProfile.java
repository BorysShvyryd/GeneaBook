package com.borman.geneobook.entity;

import com.borman.geneobook.utils.Sex;
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

//    @Temporal(TemporalType.DATE)
//    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Past(message = "{javax.validation.constraints.Past.message_dateOfDeath}")
    private LocalDate dateOfDeath;

    @NotBlank
    @Size(max = 64)
    private String placeOfBirth;

//    private Address address;

    @OneToOne
    private LoggedUser loggedUser;

    private LocalDateTime registered;
    private LocalDateTime updated;

    @ManyToMany
    private List<FamilyTies> familyTies;

    public Long getId() {
        return id;
    }

    public UserProfile setId(Long id) {
        this.id = id;
        return this;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public UserProfile setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return this;
    }

    public LocalDate getDateOfDeath() {
        return dateOfDeath;
    }

    public UserProfile setDateOfDeath(LocalDate dateOfDeath) {
        this.dateOfDeath = dateOfDeath;
        return this;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public UserProfile setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
        return this;
    }

    public Sex getSex() {
        return sex;
    }

    public UserProfile setSex(Sex sex) {
        this.sex = sex;
        return this;
    }

    public LocalDateTime getRegistered() {
        return registered;
    }

    public UserProfile setRegistered(LocalDateTime registered) {
        this.registered = registered;
        return this;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }

    public UserProfile setUpdated(LocalDateTime updated) {
        this.updated = updated;
        return this;
    }

    public Name getName() {
        return name;
    }

    public UserProfile setName(Name name) {
        this.name = name;
        return this;
    }

    public List<FamilyTies> getFamilyTies() {
        return familyTies;
    }

    public UserProfile setFamilyTies(List<FamilyTies> familyTies) {
        this.familyTies = familyTies;
        return this;
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
//                ", loggedUser=" + loggedUser +
                ", familyTies=" + familyTies +
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
