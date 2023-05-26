package org.example;

public class MountainBikeService extends BasicService {

    @Override
    public void accept( MountainBike b ) {
        System.out.println( "MBS - fixing mountain bike" );
    }

}
