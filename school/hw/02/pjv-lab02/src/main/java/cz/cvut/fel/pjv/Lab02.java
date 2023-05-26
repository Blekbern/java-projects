/*
 * File name: Lab06.java
 * Date:      2014/08/26 21:39
 * Author:    @author
 */

package cz.cvut.fel.pjv;


import java.util.ArrayList;
import java.lang.Math;
import java.util.Scanner;

public class Lab02 {

    public void start(String[] args) {
        homework();
    }

    public void homework() {
        int cnt = 0;
        int lines = 1;
        String num;
        ArrayList<Double> numArray = new ArrayList<Double>();
        TextIO textInput = new TextIO();
        while( textInput.stdin.hasNext() ) {
            num = textInput.getLine();
            if( textInput.isInteger( num ) || textInput.isDouble( num ) || textInput.isFloat( num ) ) {
                numArray.add( Double.parseDouble( num ) );
                cnt++;
                lines++;
            } else {
                System.err.println("A number has not been parsed from line " + lines );
                lines++;
            }
            if( cnt == 10 ) {
                double avg = getAverage( numArray );
                double stdDev = getStdDeviation( numArray, avg );
                System.out.printf( "%2d %.3f %.3f\n", cnt, avg, stdDev );
                cnt = 0;
                numArray.clear();
            }
        }
        if( cnt < 10 ) {
            System.err.println( "End of input detected!" );
            if( cnt > 1 ) {
                double avg = getAverage( numArray );
                double stdDev = getStdDeviation( numArray, avg );
                System.out.printf( "%2d %.3f %.3f\n", cnt, avg, stdDev );
            }
        }
    }

    public double getAverage( ArrayList<Double> numArray ) {
        double sum = 0;
        for( int i = 0; i < numArray.size(); i++ ) {
            sum += numArray.get( i );
        }
        return sum / numArray.size();
    }

    public double getStdDeviation( ArrayList<Double> numArray, double avg ) {
        double sum = 0;
        for( int i = 0; i < numArray.size(); i++ ) {
            sum += Math.pow( numArray.get( i ) - avg, 2 );
        }
        return Math.sqrt( sum / numArray.size() );
    }
}
