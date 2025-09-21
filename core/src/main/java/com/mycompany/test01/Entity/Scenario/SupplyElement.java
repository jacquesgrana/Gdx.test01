package com.mycompany.test01.Entity.Scenario;

public class SupplyElement {

    int fuelStock = 0;
    int ammoStock = 0;
    int foodStock = 0;

    public SupplyElement() {
    }

    public SupplyElement(int fuelStock, int ammoStock, int foodStock) {
        this.fuelStock = fuelStock;
        this.ammoStock = ammoStock;
        this.foodStock = foodStock;
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
}
