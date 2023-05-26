/*
 * Server.java
 *
 * Created on 24. duben 2007, 0:26
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package chatserver;

import java.net.*;
import java.io.*;

/**
 *
 * @author balikm1
 */
public class Server {
    
    
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        boolean listening = true;

        try {
            serverSocket = new ServerSocket(4444);
        } catch (IOException e) {
            System.err.println("Could not listen on port: 4444.");
            System.exit(-1);
        }

        while (listening)
	    new ServerThread(serverSocket.accept()).start();

        serverSocket.close();
    }
    
}
