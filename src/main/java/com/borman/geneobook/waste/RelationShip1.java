package com.borman.geneobook.waste;

public enum RelationShip1 {
    PARENTS('P'),
    SISTERS_BROTHERS('S'),
    CHILD('C');
    private final Character RelationShipCode;

    RelationShip1(Character relationShipCode) {
        this.RelationShipCode = relationShipCode;
    }

    public Character getRelationShipCode() {
        return this.RelationShipCode;
    }
}
