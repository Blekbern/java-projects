package org.example;

public class MountainBike extends Bicycle {

    protected String suspension;

    public MountainBike( int cadence, int speed, int gear, String suspension ) {
        super( cadence, speed, gear ); // super must be called before initializing other attributes
        this.suspension = suspension;
    }

    @Override
    public void printDescription() {
        System.out.println( "Bike is in gear "+ gear + " with a cadence of " + cadence + " and travelling at a speed of "
                            + speed + " and suspension " + suspension );
    }

    public void visit( BasicService bs ) {
        bs.accept( this );
    }

}
