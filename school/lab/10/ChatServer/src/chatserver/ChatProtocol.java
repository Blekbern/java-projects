/*
 * ChatProtocol.java
 *
 * Created on 24. duben 2007, 0:16
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
public class ChatProtocol {
    
    private static final int WAITING = 0;
    private static final int USER = 1;
    private static final int BYE = 2;

    private int state = WAITING;

    public String processInput(String theInput) {
        String theOutput = null;

        if (state == WAITING) {
            theOutput = "Napis mi sem neco:";
            state = USER;
        } else if (state == USER) {
            theOutput = "Zprava byla dorucena! Rozluc se:";
            state = BYE;
        } else if (state == BYE) {
            theOutput = "Bye.";
            state = WAITING;
        }
        return theOutput;
    }
    
}
