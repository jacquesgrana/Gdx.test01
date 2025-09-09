package com.mycompany.test01.Entity.Unit.Abstract;

import com.mycompany.test01.Entity.Unit.Props.CombatProps;
import com.mycompany.test01.Enum.CountryEnum;
import com.mycompany.test01.Enum.UnitTypeEnum;

public abstract class Unit extends UnitElement {
    //private int id;
    //private String name;

    public Unit() {
        super();
    }

    public Unit(String name,
                String acronym,
                CountryEnum country,
                UnitTypeEnum type,
                boolean isPara,
                boolean isElite,
                boolean isMotorised,
                boolean isCompany,
                boolean usesWhiteStroke,
                int regRank,
                CombatProps combatProps) {
        super(name, acronym, country, type, isPara, isElite, isMotorised, isCompany, usesWhiteStroke, regRank, combatProps);
    }

    /*
    public boolean equals(Element element) {
        if (element == null) return false; // || getClass() != element.getClass()
        return element.getId() == this.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name);
    }

     */

    /*
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
    */
}
