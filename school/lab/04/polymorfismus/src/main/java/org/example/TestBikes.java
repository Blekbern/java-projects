package org.example;

public class TestBikes {
    public static void main(String[] args) {
        Bicycle bike1, bike2, bike3;

        bike1 = new Bicycle( 20, 10, 1 );
        bike2 = new MountainBike( 20, 10, 5, "Dual" );
        bike3 = new RoadBike( 40, 20, 0, 23 );

        bike1.printDescription();
        bike2.printDescription();
        bike3.printDescription();

        /* ----------------------------------------------- */

        BasicService bs, mbs, rbs;

        bs = new BasicService();
        mbs = new MountainBikeService();
        rbs = new RoadBikeService();

        System.out.println( "Basic service:" );
        bs.accept( bike1 );
        bs.accept( bike2 );
        bs.accept( bike3 );

        System.out.println( "Mountain bike service:" );
        mbs.accept( bike1 );
        mbs.accept( bike2 );
        mbs.accept( bike3 );

        System.out.println( "Road bike service:" );
        rbs.accept( bike1 );
        rbs.accept( bike2 );
        rbs.accept( bike3 );

        /* ----------------------------------------------- */

        System.out.println( "Basic service:" );
        bike1.visit( bs );
        bike2.visit( bs );
        bike3.visit( bs );

        System.out.println( "Mountain bike service:" );
        bike1.visit( mbs );
        bike2.visit( mbs );
        bike3.visit( mbs );

        System.out.println( "Road bike service:" );
        bike1.visit( rbs );
        bike2.visit( rbs );
        bike3.visit( rbs );




    }
}
