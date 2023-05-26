package org.example;

public class BasicService implements BicycleVisitable {

    @Override
    public void accept( Bicycle b ) {
        System.out.println( "BS - Fixing bicycle" );
    }

    @Override
    public void accept( MountainBike b ) {
        System.out.println( "BS - Fixing mountain bike" );
    }

    @Override
    public void accept( RoadBike b ) {
        System.out.println( "BS - Fixing road bike" );
    }
}
