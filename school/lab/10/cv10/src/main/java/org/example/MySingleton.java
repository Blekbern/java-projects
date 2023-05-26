package org.example;

public class MySingleton {

    private int data;
    static private MySingleton obj = null;

    static public MySingleton getInstance() {
        if( obj == null ) {

        }
        return obj;
    }
}
