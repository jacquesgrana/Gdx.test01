package com.mycompany.test01.Entity.Unit;

import com.badlogic.gdx.utils.OrderedSet;
import com.mycompany.test01.Interface.Element;

import java.util.Objects;

public class UnitGroup implements Element {
    private int id;
    private String name;
    private OrderedSet<Element> units;

    public UnitGroup() {
        this.units = new OrderedSet<>();
    }

    public UnitGroup(int id, String name, OrderedSet<Element> units) {
        this.id = id;
        this.name = name;
        this.units = units;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public void addUnit(Element element) {
        if(element != null) {
            this.units.add(element);
        }
    }

    public void removeUnit(Element element) {
        if(element != null && this.units.contains(element)) {
            this.units.remove(element);
        }
    }

    @Override
    public boolean equals(Element element) {
        if (element == null) return false;
        return element.getId() == this.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name);
    }

    public OrderedSet<Element> getUnits() {
        return units;
    }

    public void setUnits(OrderedSet<Element> units) {
        this.units = units;
    }
}
