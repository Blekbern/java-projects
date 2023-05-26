package org.example;

public enum BikeColor {
    WHITE( 6001, "bila" ),
    BLUE( 6600, "modra" );

    private final int code;
    private final String nameCZ;

    public void function() {
        System.out.println( code + " " + nameCZ );
    }

    private BikeColor( int code, String nameCZ ) {
        this.code = code;
        this.nameCZ = nameCZ;
    }
}
