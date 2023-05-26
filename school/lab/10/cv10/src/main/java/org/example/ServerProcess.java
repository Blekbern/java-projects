package org.example;

import java.io.*;
import java.net.Socket;
import java.util.LinkedList;

public class ServerProcess implements Runnable {

    private Socket cs;
    private LinkedList<String> words;

    public ServerProcess( Socket cs, LinkedList<String> words ) {
        this.cs = cs;
        this.words = words;
    }

    @Override
    public void run() {
        InputStream is = null;
        try {
            is = cs.getInputStream();
            OutputStream os = cs.getOutputStream();

            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            PrintWriter pw = new PrintWriter(os);
            String line = br.readLine();
            System.out.println( "Client send data: " + line );
            synchronized( words ) {
                words.add( line );
                pw.println( "End of connection. Data send: " + line );
                for( String word : words ) {
                    pw.println(word);
                }
            }
            pw.flush();

            is.close();
            os.close();
            cs.close();
        } catch( IOException e ) {
            System.out.println( "idk" );
        }
    }
}
