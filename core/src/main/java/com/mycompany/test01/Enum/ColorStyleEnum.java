package com.mycompany.test01.Enum;

import java.util.Objects;

public enum ColorStyleEnum {
    SUCCESS ("SUCCESS"),
    DANGER ("DANGER"),
    INFO ("INFO"),
    WARNING ("WARNING");

    private final String name;

    ColorStyleEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public boolean equals(CountryEnum toCompare) {
        return Objects.equals(this.name, toCompare.getName());
    }

    @Override
    public String toString() {
        return this.name;
    }
    }
