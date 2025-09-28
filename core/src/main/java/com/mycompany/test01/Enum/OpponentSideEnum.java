package com.mycompany.test01.Enum;

public enum OpponentSideEnum {
    SIDE_ONE(1, "Side One"),
    SIDE_TWO(2, "Side Two"),
    SIDE_THREE(3, "Side Three"),
    SIDE_FOUR(4, "Side Four"),
    SIDE_FIVE(5, "Side Five"),
    SIDE_SIX(6, "Side Six"),
    NO_SIDE(0, "No Side");

    private final int id;
    private final String name;

    OpponentSideEnum(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
