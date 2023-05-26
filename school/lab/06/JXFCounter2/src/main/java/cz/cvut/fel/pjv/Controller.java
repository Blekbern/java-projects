package cz.cvut.fel.pjv;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Controller {
    @FXML
    private Label namedLabel;

    @FXML
    private void countUp() throws IOException {
        System.out.println("Count UP");   
        int i = Integer.parseInt(namedLabel.getText())+1;
        namedLabel.setText(""+i);
    }
    
    @FXML
    private void countDown() throws IOException {
         System.out.println("Count DOWN"); 
         int i = Integer.parseInt(namedLabel.getText())-1;
         namedLabel.setText(""+i);         
        
    }
    
    
}
