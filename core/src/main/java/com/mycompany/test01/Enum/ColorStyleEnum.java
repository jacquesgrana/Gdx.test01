package com.mycompany.test01.Enum;

import java.util.Objects;

// TODO renommer en ToastColorStyleEnum
public enum ColorStyleEnum {
    SUCCESS ("SUCCESS", "toast-background-success"),
    DANGER ("DANGER", "toast-background-danger"),
    INFO ("INFO", "toast-background-info"),
    WARNING ("WARNING", "toast-background-warning");

    private final String name;
    private final String backgroundDrawableName;

    ColorStyleEnum(String name, String backgroundDrawableName) {
        this.name = name;
        this.backgroundDrawableName = backgroundDrawableName;
    }

    public String getName() {
        return this.name;
    }

    public String getBackgroundDrawableName() {
        return backgroundDrawableName;
    }

    public boolean equals(CountryEnum toCompare) {
        return Objects.equals(this.name, toCompare.getName());
    }

    @Override
    public String toString() {
        return this.name;
    }
    }
