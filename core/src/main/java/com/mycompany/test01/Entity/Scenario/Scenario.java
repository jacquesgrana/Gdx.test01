package com.mycompany.test01.Entity.Scenario;

import com.badlogic.gdx.utils.Array;
import com.mycompany.test01.Entity.Map.Hexagon;
import com.mycompany.test01.Entity.Map.Map;
import com.mycompany.test01.Enum.CountryEnum;
import com.mycompany.test01.Enum.OpponentSideEnum;

import java.util.Optional;
import java.util.stream.StreamSupport;

public class Scenario {

    private String name;
    private OpponentSideEnum[] sides;
    private int sidesCount;
    private Opponent[] opponents;
    private Array<MapObjective> objectives;

    // TODO ajouter date de départ et la durée
    private DayDate startDate;
    private int duration = 1;

    private Map map;

    private OpponentSideEnum[] sidesAll = OpponentSideEnum.values();

    public Scenario() {
        this.map = new Map();
        this.objectives = new Array<>();
        this.startDate = new DayDate();
    }

    public Scenario(
        String name,
        OpponentSideEnum[] sides,
        int sidesCount,
        Opponent[] opponents,
        Array<MapObjective> objectives
        //Array<Array<Hexagon>> hexesArray
        //int limitI,
        //int limitJ
    ) {
        this.name = name;
        this.sides = sides;
        this.sidesCount = sidesCount;
        this.opponents = opponents;
        this.objectives = objectives;
        //this.hexesArray = hexesArray;
        //this.limitI = limitI;
        //this.limitJ = limitJ;
    }

    public void setSidesFromCount() {
        this.setSides(new OpponentSideEnum[6]);
        for (int i=0; i<6; i++) {
            this.getSides()[i] = OpponentSideEnum.NO_SIDE;
            if(i < this.getSidesCount()) {
                this.getSides()[i] = this.sidesAll[i];
            }
            //System.out.println("side n°" + i + " : " +  this.getSides()[i].toString());
        }
    }

    public void initOpponentsFromSidesCount() {
        this.setOpponents(new Opponent[this.getSidesCount()]);
        for (int i=0; i<this.getSidesCount(); i++) {
            this.getOpponents()[i] = new Opponent();
            OpponentSideEnum side = OpponentSideEnum.values()[i];
            this.getOpponents()[i].setSide(side);
        }
    }

    public boolean isOpponentsOk() {
        boolean isOpponentsOk = true;
        for(int i=0; i<this.getSidesCount(); i++) {
            boolean isOpponentOk = this.getOpponents()[i].getCountry() != CountryEnum.NO_COUNTRY;
            if(i<this.getSidesCount() - 1) {
                for(int j=i+1; j<this.getSidesCount(); j++) {
                    isOpponentOk &= this.getOpponents()[i].getCountry() != this.getOpponents()[j].getCountry();
                }
            }
            isOpponentsOk &= isOpponentOk;
        }
        return isOpponentsOk;
    }

    public boolean isHexInObjectives(Hexagon hexagon) {
        if (objectives == null || objectives.isEmpty()) {
            return false;
        }
        return StreamSupport.stream(this.objectives.spliterator(), false)
            .anyMatch(objective -> objective.isHexInHexagons(hexagon));
    }

    public MapObjective getMapObjectiveFromHex(Hexagon hexagon) {
        if (objectives == null || objectives.isEmpty() || hexagon == null) {
            return null;
        }

        Optional<MapObjective> foundObjective = StreamSupport.stream(objectives.spliterator(), false)
            .filter(objective -> objective.getHexagons().contains(hexagon, false))
            .findFirst();

        return foundObjective.orElse(null);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public OpponentSideEnum[] getSides() {
        return sides;
    }

    public void setSides(OpponentSideEnum[] sides) {
        this.sides = sides;
    }

    public int getSidesCount() {
        return sidesCount;
    }

    public void setSidesCount(int sidesCount) {
        this.sidesCount = sidesCount;
    }

    public Opponent[] getOpponents() {
        return opponents;
    }

    public void setOpponents(Opponent[] opponents) {
        this.opponents = opponents;
    }

    public Array<MapObjective> getObjectives() {
        return objectives;
    }

    public void setObjectives(Array<MapObjective> objectives) {
        this.objectives = objectives;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public OpponentSideEnum[] getSidesAll() {
        return sidesAll;
    }

    public DayDate getStartDate() {
        return startDate;
    }

    public void setStartDate(DayDate startDate) {
        this.startDate = startDate;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
