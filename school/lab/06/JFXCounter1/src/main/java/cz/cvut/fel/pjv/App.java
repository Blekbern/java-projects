package cz.cvut.fel.pjv;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;

import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    private Label label = new Label("0");
    private Button btPlus = new Button("+");
    private Button btMinus = new Button("-");

    @Override
    public void start(Stage stage) {

        BorderPane border = new BorderPane();

        VBox vbox = new VBox();
        vbox.setSpacing(10);
        vbox.setStyle("-fx-background-color: blue;");

        border.setTop(vbox);
        
        StackPane stPane = new StackPane();
        border.setCenter(stPane);
        label.setStyle("-fx-font-size:25px; -fx-font-weight:800;");
        stPane.getChildren().add(label);
                
        btPlus.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                System.out.println(t.toString());
                System.out.println(t.getSource().getClass().getName());
                System.out.println( ((Button) t.getSource()).getText());                
                System.out.println(t.getTarget().toString());                
                label.setText(""+(Integer.parseInt(label.getText())+1));
            }           
        });
        
        btMinus.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                System.out.println(t.toString());
                System.out.println(t.getSource().getClass().getName());
                System.out.println( ((Button) t.getSource()).getText());                
                System.out.println(t.getTarget().toString());                
                label.setText(""+(Integer.parseInt(label.getText())-1));
            }
        });
        
        vbox.getChildren().add(btPlus);
        vbox.getChildren().add(btMinus);

        Scene scene = new Scene(border, 200, 400);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }    

}
