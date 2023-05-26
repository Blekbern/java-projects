package my.semestral.projectxd.yump.Model;

/**
 * Enemy class defines enemy as a Sprite
 */
public class Enemy extends Sprite {

    private boolean isPatrolling;
    private double start;
    private double end;
    private boolean jumping;

    /**
     * Creates a new Enemy instance with these given parameters
     * @param health - health points
     * @param posX - x coordinate
     * @param posY - y coordinate
     * @param width - width
     * @param height - height
     * @param movementSpeed - movement speed
     * @param maxHealth - max health points
     */
    public Enemy( int health, double posX, double posY, double width, double height, double movementSpeed, int maxHealth ) {
        super( health, posX, posY, width, height, movementSpeed, maxHealth );
    }

    /**
     * Constructor for patrolling enemy
     * @param health - health points
     * @param posX - x coordinate
     * @param posY - y coordinate
     * @param width - width
     * @param height - height
     * @param movementSpeed - movement speed
     * @param maxHealth - max health points
     * @param start - starting x position for patrol
     * @param end - ending x position for patrol
     */
    public Enemy( int health, double posX, double posY, double width, double height, double movementSpeed, int maxHealth, double start, double end ) {
        super( health, posX, posY, width, height, movementSpeed, maxHealth );
        this.start = start;
        this.end = end;
        this.isPatrolling = true;
    }

    /**
     * Constructor for jumping enemy
     * @param health - health points
     * @param posX - x coordinate
     * @param posY - y coordinate
     * @param width - width
     * @param height - height
     * @param movementSpeed - movement speed
     * @param maxHealth - max health points
     * @param jumping - is jumping
     */
    public Enemy( int health, double posX, double posY, double width, double height, double movementSpeed, int maxHealth, boolean jumping ) {
        super( health, posX, posY, width, height, movementSpeed, maxHealth );
        this.jumping = jumping;
    }

    /**
     * Movement pattern for enemies to move horizontally
     * @param start - starting position
     * @param end - ending position
     */
    public void horizontalMovementPattern( double start, double end ) {
        if( getVelocityX() == 0 ) {
            setVelocityX( getMovementSpeed() );
        } else {
        if( getPosX() <= start )
            setVelocityX( getMovementSpeed() );
        if( getPosX() + getWidth() >= end )
            setVelocityX( -getMovementSpeed() );
        }
    }

    /**
     * Method for enemy's jumping mechanic
     * @param jumpStrength sets sensitivity for jump
     */
    public void jump( double jumpStrength ) {
        if( getVelocityY() == 0) {
            setVelocityY( jumpStrength );
        }
    }

    /**
     * Checks if enemy is patrolling
     * @return true if enemy is patrolling
     */
    public boolean isPatrolling() {
        return isPatrolling;
    }

    /**
     * Checks if enemy is jumping
     * @return true if enemy is jumping
     */
    public boolean isJumping() {
        return jumping;
    }

    /**
     * Gets starting patrolling position
     * @return double x coordinate
     */
    public double getStart() {
        return start;
    }

    /**
     * Gets ending patrolling position
     * @return double x coordinate
     */
    public double getEnd() {
        return end;
    }
}
