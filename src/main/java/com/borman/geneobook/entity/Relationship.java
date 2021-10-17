package com.borman.geneobook.entity;

import javax.persistence.*;

@Entity
public class Relationship {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private FamilyTies nameFamilyTies;

    public Relationship() {
    }

    private Long userWho;

    public Relationship(Long userWho, FamilyTies nameFamilyTies, Long userWhom) {
        this.nameFamilyTies = nameFamilyTies;
        this.userWho = userWho;
        UserWhom = userWhom;
    }

    private Long UserWhom;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public FamilyTies getNameFamilyTies() {
        return nameFamilyTies;
    }

    public void setNameFamilyTies(FamilyTies nameFamilyTiesSet) {
        this.nameFamilyTies = nameFamilyTiesSet;
    }

    public Long getUserWho() {
        return userWho;
    }

    public void setUserWho(Long userWho) {
        this.userWho = userWho;
    }

    public Long getUserWhom() {
        return UserWhom;
    }

    public void setUserWhom(Long userWhom) {
        UserWhom = userWhom;
    }

    @Override
    public String toString() {
        return "Relationship{" +
                "id=" + id +
                ", nameFamilyTies=" + nameFamilyTies +
                ", userWho=" + userWho +
                ", UserWhom=" + UserWhom +
                '}';
    }
}
