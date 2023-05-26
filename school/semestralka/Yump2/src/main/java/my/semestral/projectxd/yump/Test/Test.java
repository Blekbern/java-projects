package my.semestral.projectxd.yump.Test;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.*;
import java.util.Scanner;

public class Test {

    public static void main( String[] args ) throws IOException {
//        String fileName = "/my/semestral/projectxd/yump/Test/something.txt";
//
//        File file = new File( fileName );
//        Scanner scan = new Scanner( file );
//
//        System.out.println( scan.nextLine() );

//        File dir = new File( "/home/dominhtu/School/pjv/semestralka/dominhtu/Yump2/src/main/java/my/semestral/projectxd/yump/Levels" );
//        File[] files = dir.listFiles();
//        for( File file : files ) {
//            System.out.println( file.getName() );
//        }

//        BufferedReader reader = new BufferedReader( new FileReader( fileName ) );
//        String line;
//        while ((line = reader.readLine()) != null ) {
//            System.out.println( line );
//        }
        File file = new File( "/home/dominhtu/School/pjv/semestralka/dominhtu/Yump2/src/main/java/my/semestral/projectxd/yump/Test/wtf.txt" );
        int i = 2;
        FileWriter outputFile = new FileWriter( file );
        System.out.println( "Something " + i + " ok" );
    }
}
