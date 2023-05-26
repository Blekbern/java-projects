package my.semestral.projectxd.yump.Controller;

import javafx.scene.shape.Rectangle;

/**
 * Interface for collision logic
 */
public interface CollisionInterface {

    /**
     * Collision from topside
     * @param entity object which it collides with
     * @return true if collides
     */
    public boolean collideTop( Rectangle entity );

    /**
     * Collision from botside
     * @param entity object which it collides with
     * @return true if collides
     */
    public boolean collideBot( Rectangle entity );

    /**
     * Collision from leftside
     * @param entity object which it collides with
     * @return true if collides
     */
    public boolean collideLeft( Rectangle entity );

    /**
     * Collision from rightside
     * @param entity object which it collides with
     * @return true if collides
     */
    public boolean collideRight( Rectangle entity );
}
