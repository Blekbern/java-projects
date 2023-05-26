package org.example;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main2 {

    public static void main( String[] args ) throws IOException {

        Socket cs = new Socket( "localhost" , 20000 );

        InputStream is = cs.getInputStream();
        OutputStream os = cs.getOutputStream();
        BufferedReader br = new BufferedReader( new InputStreamReader( is ) );
        PrintWriter pw = new PrintWriter( os );

        ExecutorService pool = Executors.newFixedThreadPool( 5 );

        for( int i = 0; i < 10; i++ ) {
            ClientProcess cp = new ClientProcess( i );
            pool.submit( cp );
        }
    }
}
