package com.borman.geneobook.entity;

import com.borman.geneobook.utils.FamilyTies1;

import javax.persistence.*;

@Entity
public class FamilyTies {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @ManyToOne
//    private GeneoUser concreteGeneoUser;

    private FamilyTies1 concreteFamilyties;

//    @ManyToOne
//    private GeneoUser geneoUser;

}
