package my.semestral.projectxd.yump.Model;


/**
 * Player class defines a player as a Sprite
 */
public class Player extends Sprite {

    private boolean isInAir;
    private final double jumpStrength = -500;

    /**
     * Creates a new Player instance with these given parameters
     * @param health - health points
     * @param posX - x coordinate
     * @param posY - y coordinate
     * @param width - width
     * @param height - height
     * @param movementSpeed - movement speed
     */
    public Player( int health, double posX, double posY, double width, double height, double movementSpeed, int maxHealth ) {
        super( health, posX, posY, width, height, movementSpeed, maxHealth );
    }


    /**
     * Gets jump strength
     * @return jump strength
     */
    public double getJumpStrength() {
        return jumpStrength;
    }


    /* ------------------------------- METHODS ------------------------------- */

    /**
     * Method checks whether the player is in air or not (player's velocityY != 0)
     */
    public void setInAir() {
        isInAir = ( getVelocityY() != 0 ) ? true : false;
    }

    /**
     * Method implements jumping action for the player. Player cannot jump if he's in air
     */
    public void jump() {
        setInAir();
        if( isInAir ) return;
        setVelocityY( jumpStrength );
    }
    /* ------------------------------- ------- ------------------------------- */
}
