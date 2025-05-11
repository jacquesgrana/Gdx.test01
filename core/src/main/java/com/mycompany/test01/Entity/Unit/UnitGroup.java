package com.mycompany.test01.Entity.Unit;

import com.badlogic.gdx.utils.OrderedSet;
import com.mycompany.test01.Enum.CountryEnum;
import com.mycompany.test01.Enum.UnitTypeEnum;
import com.mycompany.test01.Interface.ElementInterface;

public abstract class UnitGroup extends UnitElement { // implements Element
    private int level;
    private OrderedSet<ElementInterface> units;

    public UnitGroup() {
        super();
        this.units = new OrderedSet<>();
        this.level = 1;
    }

    public UnitGroup(String name,
                     String acronym,
                     CountryEnum country,
                     UnitTypeEnum type,
                     boolean isPara,
                     boolean isElite,
                     boolean isMotorised,
                     boolean isCompany,
                     boolean usesWhiteStroke,
                     int regRank,
                     int level) {
        super(name, acronym, country, type, isPara, isElite, isMotorised, isCompany, usesWhiteStroke, regRank);
        this.level = level;
        this.units = new OrderedSet<>();
    }

    public void addUnit(ElementInterface element) {
        if(element != null) {
            element.setParent(this);
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

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
