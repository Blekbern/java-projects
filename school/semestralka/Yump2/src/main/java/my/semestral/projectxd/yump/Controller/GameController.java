package my.semestral.projectxd.yump.Controller;

import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import my.semestral.projectxd.yump.Model.*;
import my.semestral.projectxd.yump.View.GameWindow;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * Main game logic class
 */
public class GameController {

    private Scene scene;
    private GameWindow gameWindow;

    private long prevTime = -1;
    private boolean gamePaused = false;

    private LinkedList<ScreenLevel> screenLevels;
    private ScreenLevel currentLevel;
    private boolean screenTransition = true;

    private Player player = null;
    private ArrayList<CollisionController> cc;
    private InputHandler inputHandler;
    private ArrayList<UpdateSpritePosition> usp;
    private CollisionKillBox killCollision;
    private CollisionItems pickItem;

    // GAME LOOP
    private AnimationTimer timer = new AnimationTimer() {
        @Override
        public void handle( long now ) {
            double elapsedTime = 0;
            if( prevTime > 0 )
                elapsedTime = (now - prevTime) / 1_000_000_000.0;

            inputHandler.handleInputs();

            // when moving to next level (the screen transitioned) initialize new current level
            if( screenTransition ) {
                initCurrentLevel();
                gameWindow.addRootChildren();
                screenTransition = false;
            }

            // checks for enemy's movement
            for( Enemy enemy : currentLevel.getEnemies() ) {
                if( enemy.isPatrolling() ) {
                    enemy.horizontalMovementPattern( enemy.getStart(), enemy.getEnd() );
                }
                if( enemy.isJumping() ) {
                    enemy.jump( -1000 );
                }
            }

            // updates every sprites' position
            for( UpdateSpritePosition updatePos : usp ) {
                updatePos.updateSpritePosition( elapsedTime );
            }

            // collision with platforms
            for( CollisionController collision : cc ) {
                Thread ccThread = new Thread( collision );
                ccThread.start();
            }

            // logic for picking up potions
            if( !(currentLevel.getPotions().isEmpty()) ) {
                for( int i = 0; i < currentLevel.getPotions().size(); i++ ) {
                    if( pickItem.pickedUp( currentLevel.getPotions().get(i) ) ) {
                        currentLevel.getPotions().remove( currentLevel.getPotions().remove(i) );
                        gameWindow.removePotion(i);
                    }
                }
            }

            // logic for touching the pole (win condition)
            if( currentLevel.getPole() != null ) {
                if( pickItem.touchPole( currentLevel.getPole() ) ) {
                    restartGame();
                }
            }

            // logic for killing or be killed
            if( !(currentLevel.getEnemies().isEmpty())) {
                for (int i = 0; i < currentLevel.getEnemies().size(); i++) {
                    int result = killCollision.kill(currentLevel.getEnemies().get(i));
                    switch (result) {
                        case 1:
                            currentLevel.getEnemies().remove(currentLevel.getEnemies().remove(i));
                            gameWindow.removeEnemy(i);
                            break;
                        case -1:
                            restartGame();
                        case 0:
                            break;
                    }
                }
            }

            // view sprites with updated positions on window
            gameWindow.renderSprites();

            if( player.getPosY() + player.getHeight() < 0 ) {
                // player moves to the next level if he gets above the gaming screen
                moveToNextLevel();
            } else if (player.getPosY() > 1080 ) {
                // player moves to the previous level if he gets below the gaming screen
                moveToPrevLevel();
            }

            prevTime = now;
        }

        @Override
        // pause method
        public void stop() {
            super.stop();
            prevTime = -1;
        }
    };


    /**
     * Creates the whole game and its logic
     * @param gameWindow main window
     * @param scene scene for inputs
     */
    public GameController( GameWindow gameWindow, Scene scene ) {
        this.gameWindow = gameWindow;
        this.scene = scene;
        initLevels(Constants.LEVELS_PATH );
        startGameLoop();
    }



    /**
     * Method init all the levels from a file
     * @param filePath gets path to the file
     */
    public void initLevels( String filePath ) {
        // gets all levelX.txt files
        File lvlFile = new File( filePath );
        File[] levelList = lvlFile.listFiles();
        // sort list so i initialize levels in correct order
        Arrays.sort( levelList, new Comparator<File>() {
            @Override
            public int compare(File file, File t1) {
                return t1.getName().compareTo( file.getName() );
            }
        });

        screenLevels = new LinkedList<ScreenLevel>();

        // init lvls from files and getting them into the linked list
        for( File levelFile : levelList ) {
            ScreenLevel screenLevel = new ScreenLevel( levelFile );
            screenLevels.push( screenLevel );
            // if there is a player in the screen level means it is the current level
            if( screenLevel.getPlayer() != null ) {
                player = screenLevel.getPlayer();
                currentLevel = screenLevel;
            }
        }

        // NEW GAME - getPlayer was not found
        if( currentLevel == null )
            currentLevel = screenLevels.getFirst();
        if( player == null ) {
            player = new Player(5, 300, 700, 50, 75, 200, 5);
            currentLevel.setPlayer(player);
        }
        // init INPUT, KILL, PICK-ITEM, logic for player
        inputHandler = new InputHandler( player, scene, this );
        killCollision = new CollisionKillBox( player );
        pickItem = new CollisionItems( player );
    }

    /**
     * Initializes current level. Makes a UpdateSpritePosition array for updating each sprite.
     * Makes Collision logic for player and enemies
     */
    public void initCurrentLevel() {
        // first player
        usp = new ArrayList<UpdateSpritePosition>();
        usp.add( new UpdateSpritePosition( player ));
        cc = new ArrayList<CollisionController>();
        cc.add( new CollisionController( player, currentLevel.getPlatformTiles() ) );

        // enemies
        for( Enemy enemy : currentLevel.getEnemies() ) {
            cc.add( new CollisionController( enemy, currentLevel.getPlatformTiles() ) );
            usp.add( new UpdateSpritePosition( enemy ) );
        }
    }

    /**
     * Method moves the player to the next level.
     * Change current level.
     * Move the player to the bottom screen.
     */
    public void moveToNextLevel() {
        int index = screenLevels.indexOf( currentLevel );
        currentLevel = screenLevels.get( index + 1 );
        player.setPosY( gameWindow.getWindowHeight() );
        currentLevel.setPlayer( player );
        player.setVelocityY(player.getVelocityY() + player.getVelocityY() / 3 );
        gameWindow.removeAllRootChildren();
        screenTransition = true;
    }

    /**
     * Method moves the player to the previous level.
     * Change current level.
     * Move the player to the top of screen.
     */
    public void moveToPrevLevel() {
        int index = screenLevels.indexOf( currentLevel );
        currentLevel = screenLevels.get( index - 1 );
        player.setPosY( 0 );
        currentLevel.setPlayer( player );
        gameWindow.removeAllRootChildren();
        screenTransition = true;
    }

    /**
     * Method restarts the whole game. Resets all the values and reinitializes levels from file
     */
    public void restartGame() {
        stopGameLoop();
        gameWindow.removeAllRootChildren();
        currentLevel = null;
        player = null;
        initLevels( Constants.LEVELS_PATH );
        screenTransition = true;
        startGameLoop();
    }

    /**
     * Method for saving game state. Will save in a package SaveFiles with each file acting as a level.
     */
    public void saveGame() {
        int currLvlIndex = screenLevels.indexOf( currentLevel );
        int cnt = 1;
        // For each level make one file
        for( ScreenLevel screenLevel : screenLevels ) {
            File fileName = new File( Constants.SAVE_FILES_PATH + "/level" + cnt + ".txt" );
            try( FileWriter writer = new FileWriter(fileName) ) {
                if( cnt - 1 == currLvlIndex ) {
                    writer.write(
                            "Player,"
                                    + player.getHealth()
                                    + "," + player.getPosX()
                                    + "," + player.getPosY()
                                    + "," + player.getWidth()
                                    + "," + player.getHeight()
                                    + "," + player.getMovementSpeed()
                                    + "," + player.getMaxHealth() + "\n"
                    );
                }

                if( screenLevel.getPole() != null ) {
                    writer.write(
                            "VictoryPole,"
                            + screenLevel.getPole().getPosX()
                            + "," + screenLevel.getPole().getPosY()
                            + "," + screenLevel.getPole().getWidth()
                            + "," + screenLevel.getPole().getHeight() + "\n"
                    );
                }

                for( PlatformTile platform : screenLevel.getPlatformTiles() ) {
                    writer.write(
                            "Platform,"
                                    + platform.getPosX()
                                    + "," + platform.getPosY()
                                    + "," + platform.getWidth()
                                    + "," + platform.getHeight()  + "\n"
                    );
                }

                for( HealthPotion potion : screenLevel.getPotions() ) {
                    writer.write(
                            "Potion,"
                                    + potion.getPosX()
                                    + "," + potion.getPosY()
                                    + "," + potion.getWidth()
                                    + "," + potion.getHeight()  + "\n"
                    );
                }


                for( Enemy enemy : screenLevel.getEnemies() ) {
                    if( enemy.isPatrolling() ) {
                        writer.write(
                                "EnemyP,"
                                    + enemy.getHealth()
                                    + "," + enemy.getPosX()
                                    + "," + enemy.getPosY()
                                    + "," + enemy.getWidth()
                                    + "," + enemy.getHeight()
                                    + "," + enemy.getMovementSpeed()
                                    + "," + enemy.getMaxHealth()
                                    + "," + enemy.getStart()
                                    + "," + enemy.getEnd() + "\n"

                        );
                    } else if(enemy.isJumping()) {
                        writer.write(
                                "EnemyJ,"
                                        + enemy.getHealth()
                                        + "," + enemy.getPosX()
                                        + "," + enemy.getPosY()
                                        + "," + enemy.getWidth()
                                        + "," + enemy.getHeight()
                                        + "," + enemy.getMovementSpeed()
                                        + "," + enemy.getMaxHealth()
                                        + "," + enemy.isJumping() + "\n"
                        );

                    } else {
                        writer.write(
                                "Enemy,"
                                        + enemy.getHealth()
                                        + "," + enemy.getPosX()
                                        + "," + enemy.getPosY()
                                        + "," + enemy.getWidth()
                                        + "," + enemy.getHeight()
                                        + "," + enemy.getMovementSpeed()
                                        + "," + enemy.getMaxHealth() + "\n"
                        );
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            cnt++;
        }
    }

    /**
     * Method loads game from a SaveFile. Initializes levels from a save file
     */
    public void loadGame() {
        stopGameLoop();
        gameWindow.removeAllRootChildren();
        initLevels( Constants.SAVE_FILES_PATH );
        screenTransition = true;
        startGameLoop();
    }


    /**
     * Method starts the main game loop
     */
    public void startGameLoop() {
        gamePaused = false;
        timer.start();
    }

    /**
     * Method stops game loop acting as pause
     */
    public void stopGameLoop() {
        gamePaused = true;
        timer.stop();
    }

    /**
     * Gets current level
     * @return current level
     */
    public ScreenLevel getCurrentLevel() {
        return currentLevel;
    }

    /**
     * Checks wether the game is paused
     * @return true if game paused
     */
    public boolean isGamePaused() {
        return gamePaused;
    }

}
