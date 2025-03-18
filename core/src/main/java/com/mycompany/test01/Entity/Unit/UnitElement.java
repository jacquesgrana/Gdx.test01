package com.mycompany.test01.Entity.Unit;

import com.mycompany.test01.Interface.ElementInterface;

import java.util.Objects;

public abstract class UnitElement implements ElementInterface {
    protected static int unitCounter = 0;
    protected int id;
    protected String name;

    public UnitElement() {
        this.id = unitCounter;
        this.name = "";
        unitCounter++;
    }

    public UnitElement(String name) {
        this.id = unitCounter;
        this.name = name;
        unitCounter++;
    }

    public boolean equals(ElementInterface element) {
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
