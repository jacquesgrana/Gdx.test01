package com.mycompany.test01.Entity.Unit;

import com.mycompany.test01.Interface.Element;

import java.util.Objects;

public class Unit implements Element {
    private int id;
    private String name;

    public Unit() {
    }

    public Unit(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public boolean equals(Element element) {
        if (element == null) return false; // || getClass() != element.getClass()
        return element.getId() == this.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name);
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
