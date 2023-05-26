package org.example;

public class RoadBike extends Bicycle {

    int tireWidth;

    public RoadBike( int cadence, int speed, int gear, int tireWidth ) {
        super(cadence, speed, gear);
        this.tireWidth = tireWidth;
    }

    @Override
    public void printDescription() {
        System.out.println( "Bike is in gear "+ gear + " with a cadence of " + cadence + " and travelling at a speed of "
                + speed + " and tire width " + tireWidth );
    }

    public void visit( BasicService bs ) {
        bs.accept( this );
    }

}
