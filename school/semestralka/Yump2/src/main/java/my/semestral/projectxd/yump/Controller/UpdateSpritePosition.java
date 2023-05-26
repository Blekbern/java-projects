package my.semestral.projectxd.yump.Controller;

import javafx.scene.shape.Rectangle;
import my.semestral.projectxd.yump.Model.Sprite;

/**
 * UpdateSpritePosition class serves as a controller for updating sprite's coordinates in model and update its position in view
 */
public class UpdateSpritePosition {

    private Sprite sprite;

    /**
     * Creates a new UpdateSpritePosition instance
     * @param sprite reference to the Player class itself to get Model's information
     */
    public UpdateSpritePosition( Sprite sprite ) {
        this.sprite = sprite;
    }

    /**
     * Method will update sprite's position based on the elapsed time
     * @param elapsedTime elapsed time calculated between each frame
     */
    public void updateSpritePosition( double elapsedTime ) {
        sprite.setPosX( sprite.getPosX() + sprite.getVelocityX() * elapsedTime );
        sprite.setPosY( sprite.getPosY() + sprite.getVelocityY() * elapsedTime );
        sprite.gravityPull( elapsedTime );
    }

}
