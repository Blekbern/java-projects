package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionHandler implements ActionListener {

    private JLabel text;

    public ActionHandler( JLabel text ) {
        this.text = text;
    }

    @Override
    public void actionPerformed( ActionEvent actionEvent ) {
         switch( actionEvent.getActionCommand() ) {
             case "plus":
                 System.out.println( "Clicked on plus!" );
                 // same as Calculator
                 break;
             case "minus":
                 System.out.println( "Clicked on minus!" );
                 break;
             case "reset":
                 System.out.println( "Clicked on reset!" );
                 break;
         }
    }
}
