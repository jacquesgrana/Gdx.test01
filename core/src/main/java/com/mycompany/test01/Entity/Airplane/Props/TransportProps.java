package com.mycompany.test01.Entity.Airplane.Props;

public class TransportProps {
    private int capacity;

    public TransportProps() {
        this.capacity = 10;
    }

    public TransportProps(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
