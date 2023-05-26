package my.semestral.projectxd.yump.View;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import my.semestral.projectxd.yump.Controller.GameController;
import my.semestral.projectxd.yump.Model.*;

import java.util.ArrayList;


/**
 * GameWindow class displays the current game window
 */
public class GameWindow extends Application {

    private ArrayList<Rectangle> spriteHitbox;
    private Rectangle playerHitbox;
    private ArrayList<Rectangle> platformTiles;
    private ArrayList<Rectangle> potionHitbox;
    private GameController gameController;
    private Rectangle victoryPoleHitbox;
    private final int windowWidth = 1920;
    private final int windowHeight = 1080;
    private Group root;
    private Scene scene;
    private Text text = new Text();


    /**
     * Gets window width
     * @return window with
     */
    public int getWindowWidth() {
        return windowWidth;
    }

    /**
     * Gets window height
     * @return window height
     */
    public int getWindowHeight() {
        return windowHeight;
    }

    /**
     * Method will render all the sprites' position on window
     */
    public void renderSprites() {
        playerHitbox.setX( gameController.getCurrentLevel().getPlayer().getPosX() );
        playerHitbox.setY( gameController.getCurrentLevel().getPlayer().getPosY() );
        text.setText( gameController.getCurrentLevel().getPlayer().getHealth() + "/" + gameController.getCurrentLevel().getPlayer().getMaxHealth() );
        text.setX( playerHitbox.getX() + gameController.getCurrentLevel().getPlayer().getWidth() / 2  );
        text.setY( playerHitbox.getY() + gameController.getCurrentLevel().getPlayer().getHeight() / 2 );
        if( !(spriteHitbox.isEmpty()) ) {
            for(int i = 0; i < gameController.getCurrentLevel().getEnemies().size(); i++ ) {
                spriteHitbox.get( i ).setX( gameController.getCurrentLevel().getEnemies().get(i).getPosX() );
                spriteHitbox.get( i ).setY( gameController.getCurrentLevel().getEnemies().get(i).getPosY() );
            }
        }
    }

    /**
     * Method will add all the rectangles inside the current level for view
     */
    public void addRootChildren() {
        initShapes();
        for( Rectangle sprite : spriteHitbox )
            root.getChildren().add( sprite );
        for( Rectangle potionHB : potionHitbox )
            root.getChildren().add( potionHB );
        root.getChildren().add( playerHitbox );
        root.getChildren().add( text );
        if( victoryPoleHitbox != null )
            root.getChildren().add( victoryPoleHitbox );
        for( Rectangle platformTile : platformTiles )
            root.getChildren().add( platformTile );
    }

    /**
     * Method will remove all the rectangles inside the current level for view
     */
    public void removeAllRootChildren() {
        for( Rectangle sprite : spriteHitbox )
            root.getChildren().remove( sprite );
        spriteHitbox.clear();
        for( Rectangle potionHB : potionHitbox )
            root.getChildren().remove( potionHB );
        potionHitbox.clear();
        root.getChildren().remove( playerHitbox );
        root.getChildren().remove( text );
        if( victoryPoleHitbox != null ) {
            root.getChildren().remove(victoryPoleHitbox);
            victoryPoleHitbox = null;
        }
        for( Rectangle platformTile : platformTiles )
            root.getChildren().remove( platformTile );
        platformTiles.clear();
    }

    /**
     * Removes the potion hitbox from the screen
     * @param index gets the i-th position of potion hitbox array
     */
    public void removePotion( int index ) {
        root.getChildren().remove( potionHitbox.get(index) );
        potionHitbox.remove( index );
    }

    /**
     * Removes the enemy hitbox from the screen
     * @param index gets the i-th position of enemy hitbox array
     */
    public void removeEnemy( int index ) {
        root.getChildren().remove( spriteHitbox.get(index) );
        spriteHitbox.remove( index );
    }

    /**
     * Initializes all the rectangles from the current level
     */
    public void initShapes() {
        spriteHitbox = new ArrayList<Rectangle>();
        platformTiles = new ArrayList<Rectangle>();
        potionHitbox = new ArrayList<Rectangle>();
        text.setFill( Color.WHITE );

        // init victory pole
        if( gameController.getCurrentLevel().getPole() != null ) {
            victoryPoleHitbox = new Rectangle(
                gameController.getCurrentLevel().getPole().getPosX(),
                gameController.getCurrentLevel().getPole().getPosY(),
                gameController.getCurrentLevel().getPole().getWidth(),
                gameController.getCurrentLevel().getPole().getHeight()
            );
            victoryPoleHitbox.setFill(Color.GOLD);
        }

        // init potions hitbox
        for( HealthPotion potion : gameController.getCurrentLevel().getPotions() ) {
            Rectangle potionHB = new Rectangle(
                    potion.getPosX(),
                    potion.getPosY(),
                    potion.getWidth(),
                    potion.getHeight()
            );
            potionHB.setFill( Color.GREEN );
            potionHitbox.add( potionHB );
        }

        // init player shape
        playerHitbox = new Rectangle(
                gameController.getCurrentLevel().getPlayer().getPosX(),
                gameController.getCurrentLevel().getPlayer().getPosY(),
                gameController.getCurrentLevel().getPlayer().getWidth(),
                gameController.getCurrentLevel().getPlayer().getHeight()
        );

        // init enemies shape
        for( Enemy enemy : gameController.getCurrentLevel().getEnemies() ) {
            Rectangle enemyHitbox = new Rectangle(
                    enemy.getPosX(),
                    enemy.getPosY(),
                    enemy.getWidth(),
                    enemy.getHeight()
            );
            enemyHitbox.setFill( Color.RED );
            spriteHitbox.add( enemyHitbox );
        }

        // init platform shapes
        for( PlatformTile platform : gameController.getCurrentLevel().getPlatformTiles() ) {
            Rectangle platformTile = new Rectangle(
                    platform.getPosX(),
                    platform.getPosY(),
                    platform.getWidth(),
                    platform.getHeight()
            );
            platformTiles.add( platformTile );
        }
    }


    @Override
    public void start( Stage stage ) throws Exception {
        root = new Group();
        scene = new Scene( root, Color.DEEPSKYBLUE );

        gameController = new GameController( this, scene );

        stage.setTitle( "Yump" );
        stage.setScene( scene );
        stage.setWidth( windowWidth );
        stage.setHeight( windowHeight );
        stage.setFullScreen( true );
        stage.show();
    }


    public static void main( String[] args ) {
        launch( args );
    }
}
