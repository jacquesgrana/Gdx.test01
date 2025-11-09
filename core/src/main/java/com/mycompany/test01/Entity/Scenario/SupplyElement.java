package com.mycompany.test01.Entity.Scenario;

import com.mycompany.test01.Entity.Map.Hexagon;

import java.util.Objects;

public class SupplyElement {
    private int dayNumber = 1;
    private int fuelStock = 0;
    private int ammoStock = 0;
    private int foodStock = 0;
    private int medecineStock = 0;
    private SourceHexagon supplySource = null;

    public SupplyElement() {
    }

    public SupplyElement(int dayNumber, int fuelStock, int ammoStock, int foodStock, int medecineStock, SourceHexagon supplySource) {
        this.dayNumber = dayNumber;
        this.fuelStock = fuelStock;
        this.ammoStock = ammoStock;
        this.foodStock = foodStock;
        this.medecineStock = medecineStock;
        this.supplySource = supplySource;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        SupplyElement that = (SupplyElement) o;
        return dayNumber == that.dayNumber && fuelStock == that.fuelStock && ammoStock == that.ammoStock && foodStock == that.foodStock && medecineStock == that.medecineStock && supplySource.getHexagon().equals(that.supplySource.getHexagon());
    }

    @Override
    public int hashCode() {
        return Objects.hash(dayNumber, fuelStock, ammoStock, foodStock, medecineStock, supplySource);
    }

    public int getDayNumber() {
        return dayNumber;
    }

    public void setDayNumber(int dayNumber) {
        this.dayNumber = dayNumber;
    }

    public int getFuelStock() {
        return fuelStock;
    }

    public void setFuelStock(int fuelStock) {
        this.fuelStock = fuelStock;
    }

    public int getAmmoStock() {
        return ammoStock;
    }

    public void setAmmoStock(int ammoStock) {
        this.ammoStock = ammoStock;
    }

    public int getFoodStock() {
        return foodStock;
    }

    public void setFoodStock(int foodStock) {
        this.foodStock = foodStock;
    }

    public int getMedecineStock() {
        return medecineStock;
    }

    public void setMedecineStock(int medecineStock) {
        this.medecineStock = medecineStock;
    }

    public SourceHexagon getSupplySource() {
        return supplySource;
    }

    public void setSupplySource(SourceHexagon supplySource) {
        this.supplySource = supplySource;
    }
}
