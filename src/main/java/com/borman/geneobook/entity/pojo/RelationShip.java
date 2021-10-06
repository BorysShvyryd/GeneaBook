package com.borman.geneobook.entity.pojo;

public enum RelationShip {
    PARENTS('P'),
    SISTERS_BROTHERS('S'),
    CHILD('C');
    private final Character RelationShipCode;

    RelationShip(Character relationShipCode) {
        this.RelationShipCode = relationShipCode;
    }

    public Character getRelationShipCode() {
        return this.RelationShipCode;
    }
}
