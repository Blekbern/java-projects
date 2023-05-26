import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Scanner input = new Scanner(System.in);
//        int sum = 0;
//        int n = 0;
//        int numIn;
//        System.out.println( "Insert numbers" );
//        while( (numIn = input.nextInt()) != 0 ) {
//            sum += numIn;
//            n++;
//        }
//        if( n == 0 ) {
//            System.err.println( "Unable to find average" );
//            return;
//        }
//        System.out.println( "Average: " + (double)sum/n);
        System.out.println( factorization() );
    }
    public static String factorization() {
        Scanner input = new Scanner( System.in );
        int num = input.nextInt();
        int divisor = 2;
        String primeFact = String.valueOf(num) + " = ";
        while( num != 1 ) {
            if( num % divisor == 0 ) {
                num /= divisor;
                primeFact += divisor + "*";
            } else {
                divisor++;
            }
        }
        return primeFact;
    }

    public static void printArray( int array[] ) {
        for( int i = 0; i < array.length; i++ ) {
            System.out.println( array[i] );
        }
    }

    public static int[] fillArray( int len ) {
        int array[] = new int[len];
        for( int i = 0; i < len; i++ ) {
            array[i] = i + 1;
        }
        return array;
    }

    public static int[] fillRandArray( int len, int min, int max ) {
        int array[] = new int[len];
        Random random = new Random();
        for( int i = 0; i < len; i++ ) {
            array[i] = random.ints( min, max );
        }
    }

    public static void sortArray( int array[] ) {
        for( int i = 0; i < array.length; i++ ) {
            // bubble sort
        }
    }
}