package com.mycompany.test01.Entity.Unit;

import com.badlogic.gdx.utils.OrderedSet;
import com.mycompany.test01.Enum.CountryEnum;
import com.mycompany.test01.Enum.UnitTypeEnum;
import com.mycompany.test01.Interface.ElementInterface;

public abstract class UnitGroup extends UnitElement { // implements Element
    private OrderedSet<ElementInterface> units;

    public UnitGroup() {
        this.units = new OrderedSet<>();
    }

    public UnitGroup(String name, String acronym, CountryEnum country, UnitTypeEnum type, boolean isElite, boolean isMotorised) {
        super(name, acronym, country, type, isElite, isMotorised);
        this.units = new OrderedSet<>();
    }

    public void addUnit(ElementInterface element) {
        if(element != null) {
            this.units.add(element);
        }
    }

    public void removeUnit(ElementInterface element) {
        if(element != null && this.units.contains(element)) {
            this.units.remove(element);
        }
    }

    public OrderedSet<ElementInterface> getUnits() {
        return units;
    }

    public void setUnits(OrderedSet<ElementInterface> units) {
        this.units = units;
    }
}
