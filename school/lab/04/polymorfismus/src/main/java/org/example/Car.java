package org.example;

import java.util.ArrayList;
import java.util.List;

public class Car implements BicycleVisitable {
    List<BicycleHolder> carHolders = new ArrayList<BicycleHolder>(4);
    // <? extends Bicycle> wtf is this
    public void accept( Bicycle b ) {
        carHolders.add( new BicycleHolder( b ) );
    }
    public void accept( MountainBike mb ) {
        carHolders.add( new BicycleHolder( mb ) );
    }
    public void accept( RoadBike rb ) {
        carHolders.add( new BicycleHolder( rb ) );
    }

    @Override
    public String toString() {
        String res = "";
        for( BicycleHolder carHolder : carHolders ) {
            res += carHolder + "\n";
        }
        return res;
    }
}
