package my.semestral.projectxd.yump.Controller;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import my.semestral.projectxd.yump.Model.Player;


/**
 * InputHandler class handles the user's input making the player act in a specific way according to the key inputs.
 */
public class InputHandler {

    private Player player;
    private boolean leftPressed;
    private boolean rightPressed;
    private boolean spacePressed;
    private Scene scene;
    private GameController gc;


    /**
     * Constructor initializes this class' attributes.
     * @param player gets the model Player object to handle the inputs.
     * @param scene is used to set the key events on.
     */
    public InputHandler( Player player, Scene scene, GameController gc ) {
        this.player = player;
        leftPressed = false;
        rightPressed = false;
        spacePressed = false;
        this.scene = scene;
        this.gc = gc;
    }

    /**
     * Main handling method for inputs
     */
    public void handleInputs() {
        keyRegister();
        if( rightPressed && !leftPressed ) player.setVelocityX( player.getMovementSpeed() );
        if( leftPressed && !rightPressed ) player.setVelocityX( -player.getMovementSpeed() );
        if( (!rightPressed && !leftPressed) || (rightPressed && leftPressed) ) player.setVelocityX( 0 );
        if( spacePressed ) player.jump();
    }


    /**
     * Method that registers user's inputs (moving, jumping).
     */
    public void keyRegister() {
        // Event handler for key when pressed
        this.scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle( KeyEvent keyEvent ) {
                switch( keyEvent.getCode() ) {
                    case A:
                    case LEFT:
                        leftPressed = true;
                        break;
                    case D:
                    case RIGHT:
                        rightPressed = true;
                        break;
                    case SPACE:
                        spacePressed = true;
                        break;
                    case R:
                        gc.restartGame();
                        break;
                    case P:
                        if( gc.isGamePaused() ){
                            gc.startGameLoop();
                        } else {
                            gc.stopGameLoop();
                        }
                        break;
                    case F5:
                        gc.saveGame();
                        break;
                    case F9:
                        gc.loadGame();
                        break;
                    default:
                        break;
                }
            }
        });

        // Event handler for key when released
        this.scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                switch( keyEvent.getCode() ) {
                    case A:
                    case LEFT:
                        leftPressed = false;
                        break;
                    case D:
                    case RIGHT:
                        rightPressed = false;
                        break;
                    case SPACE:
                        spacePressed = false;
                        break;
                    default:
                        break;

                }
            }
        });
    }
}
