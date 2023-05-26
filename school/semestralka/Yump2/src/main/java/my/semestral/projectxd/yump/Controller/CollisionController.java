package my.semestral.projectxd.yump.Controller;

import javafx.scene.shape.Rectangle;
import my.semestral.projectxd.yump.Model.PlatformTile;
import my.semestral.projectxd.yump.Model.Sprite;
import java.util.logging.Logger;


import java.util.ArrayList;

/**
 * CollisionController class will handle the collision's physics with platforms
 */
public class CollisionController implements Runnable, CollisionInterface {

    private Sprite sprite;
    private ArrayList<PlatformTile> platformTiles;


    private final Logger LOGGER = Logger.getLogger(CollisionController.class.getName());



    public CollisionController( Sprite sprite, ArrayList<PlatformTile> platformTiles ) {
        this.sprite = sprite;
        this.platformTiles = platformTiles;
    }

    /**
     * Method that handles sprite's collision with a platform
     */
    public void handleCollision() {
        Rectangle spriteHitbox = new Rectangle( sprite.getPosX(), sprite.getPosY(), sprite.getWidth(), sprite.getHeight() );
        for( PlatformTile platform : platformTiles ) {
            Rectangle platformTile = new Rectangle(platform.getPosX(), platform.getPosY(), platform.getWidth(), platform.getHeight());
            if (spriteHitbox.getBoundsInParent().intersects(platformTile.getBoundsInParent())) {
                // COLLISION FROM TOPSIDE
                if (collideTop(platformTile)) {
                    sprite.setVelocityY(0);
                    sprite.setPosY(platformTile.getY() - sprite.getHeight());
                }

                // COLLISION FROM THE BOTTOM SIDE
                if (collideBot(platformTile)) {
                    sprite.setVelocityY(-sprite.getVelocityY());
                    sprite.setPosY(platformTile.getY() + platformTile.getHeight());
                }

                // COLLISION FROM LEFT SIDE
                if (collideLeft(platformTile)) {
                    sprite.setVelocityX(0);
                    sprite.setPosX(platformTile.getX() - sprite.getWidth());
                }

                // COLLISION FROM THE RIGHT SIDE
                if (collideRight(platformTile)) {
                    sprite.setVelocityX(0);
                    sprite.setPosX(platformTile.getX() + platformTile.getWidth());
                }
            }
        }
    }

    /**
     * Method checks whether the sprite collided from the top or not.
     * @param entity object with which the sprite collides.
     * @return true if sprite collides
     */
    @Override
    public boolean collideTop( Rectangle entity ) {
        if( sprite.getPosY() + sprite.getHeight() > entity.getY() &&
            sprite.getPosY() < entity.getY() &&
            sprite.getPosX() + sprite.getWidth() > entity.getX() + 5 &&
            sprite.getPosX() < entity.getX() + entity.getWidth() - 5 )
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
        if( sprite.getPosY() < entity.getY() + entity.getHeight() &&
            sprite.getPosY() > entity.getY() &&
            sprite.getPosX() + sprite.getWidth() > entity.getX() + 5 &&
            sprite.getPosX() < entity.getX() + entity.getWidth() - 5  )
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
        if( sprite.getPosX() + sprite.getWidth() > entity.getX() &&
            sprite.getPosX() < entity.getX() &&
            sprite.getPosY() + sprite.getHeight() > entity.getY() &&
            sprite.getPosY() < entity.getY() + entity.getHeight() )
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
        if( sprite.getPosX() < entity.getX() + entity.getWidth() &&
            sprite.getPosX() + sprite.getWidth() > entity.getX() + entity.getWidth() &&
            sprite.getPosY() + sprite.getHeight() > entity.getY() &&
            sprite.getPosY() < entity.getY() + entity.getHeight() )
        {
            return true;
        }
        return false;
    }

    @Override
    public void run() {
        handleCollision();
    }
}
