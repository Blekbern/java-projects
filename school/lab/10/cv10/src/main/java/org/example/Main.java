package org.example;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;

public class Main {

    static int clientCount = 0;
    static LinkedList<String> words = new LinkedList<String>();

    public static void main(String[] args) throws IOException {


        ServerSocket ss = new ServerSocket( 20000 );
        System.out.println( "Socket available" );

        while( clientCount < 5 ) {
            Socket cs = ss.accept();
            System.out.println("Client connected");
            clientCount++;

            Thread t = new Thread( new ServerProcess( cs, words ) );
            t.start();
        }
        ss.close();
    }
}