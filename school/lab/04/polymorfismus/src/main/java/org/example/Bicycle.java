package org.example;

public class Bicycle {

    protected int cadence;
    protected int speed;
    protected int gear;


    public Bicycle( int cadence, int speed, int gear ) {
        this.cadence = cadence;
        this.speed = speed;
        this.gear = gear;
    }

    public void printDescription() {
        System.out.println( "Bike is in gear "+ gear + " with a cadence of " + cadence + " and travelling at a speed of " + speed );
    }

    /*
     public void visit( BasicService bs ) {
         bs.accept( this );
     }

     public void visit( Car c ) {
         c.accept( this );
     }
    */

    public void visit( BicycleVisitable c ) {
        c.accept( this );
    }
}
