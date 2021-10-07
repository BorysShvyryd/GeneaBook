package com.borman.geneobook.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Relationship {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    private Set<FamilyTies> nameFamilyTiesSet;

    private Long userWho;

    private Long UserWhom;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<FamilyTies> getNameFamilyTiesSet() {
        return nameFamilyTiesSet;
    }

    public void setNameFamilyTiesSet(Set<FamilyTies> nameFamilyTiesSet) {
        this.nameFamilyTiesSet = nameFamilyTiesSet;
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
}
