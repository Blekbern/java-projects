package cz.cvut.fel.pjv;

import java.util.Scanner;

public class Lab01 {
    private Scanner input = new Scanner( System.in );
    public void start(String[] args) {
        homework();
    }

    public void homework() {
        int op;
        System.out.println( "Vyber operaci (1-soucet, 2-rozdil, 3-soucin, 4-podil):" );
        op = input.nextInt();
        switch( op ) {
            case 1:
                addition();
                break;
            case 2:
                subtraction();
                break;
            case 3:
                multiplication();
                break;
            case 4:
                division();
                break;
            default:
                System.out.println( "Chybna volba!" );
        }
    }

    public int decPoint() {
        System.out.println( "Zadej pocet desetinnych mist: " );
        int decimal = input.nextInt();
        if( decimal < 0 ) {
            System.out.println( "Chyba - musi byt zadane kladne cislo!" );
            return -1;
        }
        return decimal;
    }

    public void printRes( int decPt, char operand, double num1, double num2, double resNum ) {
        System.out.printf( "%." + decPt + "f " + operand + " %." + decPt + "f = %." + decPt + "f\n", num1, num2, resNum );
    }

    public void addition() {
        System.out.println( "Zadej scitanec: " );
        double addend1 = input.nextDouble();
        System.out.println( "Zadej scitanec: " );
        double addend2 = input.nextDouble();
        int decimalPt = decPoint();
        if( decimalPt == -1 ) return;
        printRes( decimalPt, '+', addend1, addend2, addend1 + addend2 );
    }

    public void subtraction() {
        System.out.println( "Zadej mensenec: " );
        double minuend = input.nextDouble();
        System.out.println( "Zadej mensitel: " );
        double subtrahend = input.nextDouble();
        int decimalPt = decPoint();
        if( decimalPt == -1 ) return;
        printRes( decimalPt, '-', minuend, subtrahend, minuend - subtrahend );
    }

    public void multiplication() {
        System.out.println( "Zadej cinitel: ");
        double multiplier = input.nextDouble();
        System.out.println( "Zadej cinitel: ");
        double multiplicand = input.nextDouble();
        int decimalPt = decPoint();
        if( decimalPt == -1 ) return;
        printRes( decimalPt, '*', multiplier, multiplicand, multiplier * multiplicand );
    }

    public void division() {
        System.out.println( "Zadej delenec: ");
        double dividend = input.nextDouble();
        System.out.println( "Zadej delitel: ");
        double divisor = input.nextDouble();
        if( divisor == 0 ) {
            System.out.println( "Pokus o deleni nulou!" );
            return;
        }
        int decimalPt = decPoint();
        if( decimalPt == -1 ) return;
        printRes( decimalPt, '/', dividend, divisor, dividend / divisor );
    }
}