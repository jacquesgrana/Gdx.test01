package com.mycompany.test01.Interface;

import com.mycompany.test01.Entity.Unit.Props.CombatProps;

public interface CombatPropsFactoryInterface {

    //int MAX_MANPOWER = 1000;
    // Infantry
    public CombatProps getInfantryLowCombatProps();
    public CombatProps getInfantryMediumCombatProps();
    public CombatProps getInfantryHighCombatProps();
    public CombatProps getInfantryEliteCombatProps();

}
