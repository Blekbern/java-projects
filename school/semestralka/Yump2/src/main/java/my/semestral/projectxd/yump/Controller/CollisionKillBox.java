package my.semestral.projectxd.yump.Controller;

import javafx.scene.shape.Rectangle;
import my.semestral.projectxd.yump.Model.Enemy;
import my.semestral.projectxd.yump.Model.Player;
import java.util.logging.Logger;


/**
 * Class for killing logic
 */
public class CollisionKillBox implements CollisionInterface {

    private Player player;
    private final Logger logger = Logger.getLogger(CollisionKillBox.class.getName());
    private boolean showLogger = true;

    /**
     * Creates CollisionKillBox instance.
     * @param player gets ref to player
     */
    public CollisionKillBox(Player player ) {
        this.player = player;
    }

    /**
     * Method checks whether the sprite collided from the top or not.
     * @param entity object with which the sprite collides.
     * @return true if sprite collides
     */
    @Override
    public boolean collideTop( Rectangle entity ) {
        if( player.getPosY() + player.getHeight() > entity.getY() &&
            player.getPosY() < entity.getY() &&
            player.getPosX() + player.getWidth() > entity.getX() + 5 &&
            player.getPosX() < entity.getX() + entity.getWidth() - 5 )
        {
            return true;
        }
        return false;
    }

    /**
     * Method checks whether the sprite collided from the bottom or not.
     * @param entity object with which the sprite collides.
     * @return true if sprite collides
     */
    @Override
    public boolean collideBot( Rectangle entity ) {
        if( player.getPosY() < entity.getY() + entity.getHeight() &&
            player.getPosY() > entity.getY() &&
            player.getPosX() + player.getWidth() > entity.getX() + 5 &&
            player.getPosX() < entity.getX() + entity.getWidth() - 5  )
        {
            return true;
        }
        return false;
    }

    /**
     * Method checks whether the sprite collided from the left or not.
     * @param entity object with which the sprite collides.
     * @return true if sprite collides
     */
    @Override
    public boolean collideLeft( Rectangle entity ) {
        if( player.getPosX() + player.getWidth() > entity.getX() &&
            player.getPosX() < entity.getX() &&
            player.getPosY() + player.getHeight() > entity.getY() &&
            player.getPosY() < entity.getY() + entity.getHeight() )
        {
            return true;
        }
        return false;
    }

    /**
     * Method checks whether the sprite collided from the right or not.
     * @param entity object with which the sprite collides.
     * @return true if sprite collides
     */
    @Override
    public boolean collideRight( Rectangle entity ) {
        if( player.getPosX() < entity.getX() + entity.getWidth() &&
            player.getPosX() + player.getWidth() > entity.getX() + entity.getWidth() &&
            player.getPosY() + player.getHeight() > entity.getY() &&
            player.getPosY() < entity.getY() + entity.getHeight() )
        {
            return true;
        }
        return false;
    }

    /**
     * Method kills enemy or kills player based on collision sides
     * @param enemy gets ref to Enemy
     * @return 1 if Enemy is killed
     * @return -1 if Player is killed
     * @return 0 if no one was killed
     */
    public int kill(Enemy enemy ) {
        Rectangle playerHitbox = new Rectangle( player.getPosX(), player.getPosY(), player.getWidth(), player.getHeight() );
        Rectangle enemyHitbox = new Rectangle( enemy.getPosX(), enemy.getPosY(), enemy.getWidth(), enemy.getHeight() );
        if( playerHitbox.getBoundsInParent().intersects(enemyHitbox.getBoundsInParent()) ) {
            if( collideTop( enemyHitbox ) ) {
                player.setVelocityY( -player.getVelocityY() );
                enemy.takeDamage();
                if( enemy.getHealth() == 0 ) {
                    return 1;
                }
            }
            if( collideBot( enemyHitbox ) ) {
                player.takeDamage();
                logger.info( "You have taken damage!" );
                player.setPosY( enemyHitbox.getY() + enemyHitbox.getHeight() + 1 ); // + 1 to prevent intersection just in case
                player.setVelocityY( -player.getVelocityY() + player.getJumpStrength() / 3 );
                if( player.getHealth() == 0 )
                    return -1;
            }

            if( collideLeft( enemyHitbox ) ) {
                player.takeDamage();
                logger.info( "You have taken damage!" );
                player.setPosX(enemy.getPosX() - 5);
                if( player.getHealth() == 0 )
                    return -1;
            }
            if( collideRight( enemyHitbox ) ) {
                player.takeDamage();
                logger.info( "You have taken damage!" );
                player.setPosX(enemy.getPosX() + enemy.getWidth() + 5);
                if (player.getHealth() == 0)
                    return -1;
            }
        }
        return 0;
    }
}
