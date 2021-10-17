package com.borman.geneabook.entity;

import javax.persistence.*;

@Entity
public class Relationship {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private com.borman.geneabook.entity.FamilyTies nameFamilyTies;

    public Relationship() {
    }

    private Long userWho;

    public Relationship(Long userWho, com.borman.geneabook.entity.FamilyTies nameFamilyTies, Long userWhom) {
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

    public com.borman.geneabook.entity.FamilyTies getNameFamilyTies() {
        return nameFamilyTies;
    }

    public void setNameFamilyTies(com.borman.geneabook.entity.FamilyTies nameFamilyTiesSet) {
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
