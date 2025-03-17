package com.mycompany.test01.Entity.Unit;

import com.mycompany.test01.Interface.Element;

import java.util.Objects;

public abstract class UnitElement implements Element {
    protected int id;
    protected String name;

    public UnitElement() {
    }

    public UnitElement(int id, String name) {
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
