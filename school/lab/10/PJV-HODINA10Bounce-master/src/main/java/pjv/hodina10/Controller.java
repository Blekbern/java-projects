/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pjv.hodina10;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mudromar
 */
public class Controller implements Runnable{

    private Model model;   
    
    public Controller(Model model){
        this.model = model;               
        new Thread(this).start();
    }
    
    @Override
    public void run() {        
        while(true){
            try {
                Thread.sleep(50);
            } catch (InterruptedException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                break;
            }
            synchronized(model){
                model.setxPosition(model.getxPosition()  + model.xVelocity);
                model.setyPosition(model.getyPosition()  + model.yVelocity);
                model.notifyObservers();
            }            
        }       
        
    }
    
}