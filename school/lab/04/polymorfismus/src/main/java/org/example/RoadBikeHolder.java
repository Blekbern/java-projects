package org.example;

public class RoadBikeHolder extends BicycleHolder {

    public RoadBikeHolder( RoadBike rb ) {
        super( rb );
    }

    @Override
    public String toString() {
        return "Road bike holder holding " + bicycle;
    }
}
