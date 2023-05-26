package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Calculator extends JFrame implements ActionListener {

    private JButton plus;
    private JButton minus;
    private JButton reset;
    private JLabel text;

    private ActionHandler handler;

    public Calculator(String title) throws HeadlessException {
        handler = new ActionHandler( text );
        super(title);
        this.setDefaultCloseOperation( EXIT_ON_CLOSE );
        this.setSize( 500, 420 );
        plus = new JButton( "plus" );
        plus.setPreferredSize( new Dimension( 100, 100 ) );
//        add( plus );
        minus = new JButton( "minus" );
//        add( minus );
        reset = new JButton( "reset" );
//        add( reset );
        text = new JLabel( "0" );
//        add( text );
//        setLayout( new FlowLayout() );


        setLayout( new BorderLayout() );
        JPanel panel1 = new JPanel();
        panel1.setBackground( Color.RED );
        panel1.setLayout( null );
        panel1.setPreferredSize( new Dimension(150, 250) );
        panel1.add( plus );
        plus.setBounds( 20, 20, 60, 90 );
        add( panel1, BorderLayout.NORTH );
        add( minus, BorderLayout.SOUTH );
        add( reset, BorderLayout.WEST );
        add( text, BorderLayout.EAST );



        plus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
//                System.out.println( actionEvent );
//                System.out.println( actionEvent.getActionCommand() );
//                System.out.println( actionEvent.getWhen() );
//                System.out.println( actionEvent.paramString() );
                int cnt = Integer.parseInt( text.getText() );
                cnt++;
                text.setText( cnt + "" );
                System.out.println( cnt );
            }
        });

        // Neanonymni deklarace
        ActionListener plusAction = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                // something
            }
        };



//        plus.addMouseListener(new MouseListener() {
//            @Override
//            public void mouseClicked(MouseEvent mouseEvent) {
//                System.out.println( "Clicked!" );
//            }
//
//            @Override
//            public void mousePressed(MouseEvent mouseEvent) {
//                return;
//            }
//
//            @Override
//            public void mouseReleased(MouseEvent mouseEvent) {
//                return;
//            }
//
//            @Override
//            public void mouseEntered(MouseEvent mouseEvent) {
//                System.out.println( "Mouse entered!" );
//            }
//
//            @Override
//            public void mouseExited(MouseEvent mouseEvent) {
//                System.out.println( "Mouse exited!" );
//            }
//        });

        minus.addActionListener( new ActionHandler( text ) );


        // plus.addActionListener( this ) pro implements ActionListener (naimplementovany actionPerformed)
    }


    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        switch( actionEvent.getActionCommand() ) {
            case "plus":
                break;
            case "minus":
                break;
            case "reset":
                break;
        }
    }

    private class privActionHandler {
        // same as external
    }
}

