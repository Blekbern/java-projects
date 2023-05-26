package cz.cvut.fel.pjv.utils;

public final class ArrayUtil {

    private ArrayUtil() {}

    public static void sort( Comparable arr[] ) {
        for( int i = 0; i < arr.length; i++ ) {
            for( int j = 0; j < arr.length - 1 - i; j++ ) {
                if( arr[j].compareTo(arr[j + 1]) > 0 ) {
                    // swap
                }
            }
        }
    }
}
