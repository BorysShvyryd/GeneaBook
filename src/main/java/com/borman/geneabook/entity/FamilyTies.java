package com.borman.geneabook.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class FamilyTies {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nameFamilyTies;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameFamilyTies() {
        return nameFamilyTies;
    }

    public void setNameFamilyTies(String nameFamilyTies) {
        this.nameFamilyTies = nameFamilyTies;
    }
}
