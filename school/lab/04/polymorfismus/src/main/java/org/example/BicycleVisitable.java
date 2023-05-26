package org.example;

public interface BicycleVisitable {
    public void accept(Bicycle b);
    public void accept(MountainBike b);
    public void accept(RoadBike b);
}
