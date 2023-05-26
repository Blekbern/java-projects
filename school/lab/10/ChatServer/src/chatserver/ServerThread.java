/*
 * ServerThread.java
 *
 * Created on 24. duben 2007, 0:28
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
public class ServerThread extends Thread {
    
    private Socket socket = null;
    
    /** Creates a new instance of ServerThread */
    public ServerThread(Socket socket) {
        super("ServerThread");
	this.socket = socket;
    }
    
    public void run() {

	try {
	    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
	    BufferedReader in = new BufferedReader(
				    new InputStreamReader(
				    socket.getInputStream()));

	    String inputLine, outputLine;
	    ChatProtocol kkp = new ChatProtocol();
	    outputLine = kkp.processInput(null);
	    out.println(outputLine);

            
	    while ((inputLine = in.readLine()) != null) {
		outputLine = kkp.processInput(inputLine);
		out.println(outputLine);
		if (inputLine.equals("Bye."))
		    break;
	    }
	    out.close();
	    in.close();
	    socket.close();

	} catch (IOException e) {
	    e.printStackTrace();
	}
    }
    
}

