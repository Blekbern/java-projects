package org.example;

public class BicycleHolder {
    protected Bicycle bicycle;

    public BicycleHolder( Bicycle b ) {
        this.bicycle = b;
    }

    @Override
    public String toString() {
        return "Bicycle holder holding " + bicycle;
    }
}
