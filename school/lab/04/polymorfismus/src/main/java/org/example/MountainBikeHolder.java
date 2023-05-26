package org.example;

public class MountainBikeHolder extends BicycleHolder {
    public MountainBikeHolder( MountainBike mb ) {
        super( mb );
    }

    @Override
    public String toString() {
        return "Mountain bike holder holding " + bicycle;
    }
}
