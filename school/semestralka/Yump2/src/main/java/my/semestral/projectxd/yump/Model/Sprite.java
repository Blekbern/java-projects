package my.semestral.projectxd.yump.Model;

/**
 * Sprite abstract class defines the sprite's basic attributes and methods.
 * Has information of sprite's POSITION, VELOCITY, WIDTH, HEIGHT, MOVEMENTSPEED
 */
public abstract class Sprite {

    private double posX;
    private double posY;

    private double velocityX;
    private double velocityY;

    private int health;
    private final int maxHealth;

    private final double width;
    private final double height;

    private final double movementSpeed;
    private final double gravityForce = 1000;

    /**
     * Creates a new Sprite instance with these given parameters
     * @param health - health points
     * @param posX - x coordinate
     * @param posY - y coordinate
     * @param width - width
     * @param height - height
     * @param movementSpeed - movement speed
     * @param maxHealth - max health
     */
    public Sprite( int health, double posX, double posY, double width, double height, double movementSpeed, int maxHealth ) {
        this.health = health;
        this.posX = posX;
        this.posY = posY;
        this.width = width;
        this.height = height;
        this.movementSpeed = movementSpeed;
        this.maxHealth = maxHealth;
    }

    // --------------------------------------- SETTERS ---------------------------------------

    /**
     * Sets the sprite's horizontal position
     * @param posX value of x coordinate
     */
    public void setPosX( double posX ) {
        this.posX = posX;
    }

    /**
     * Sets the sprite's vertical position
     * @param posY value of y coordinate
     */
    public void setPosY( double posY ) {
        this.posY = posY;
    }

    /**
     * Sets the sprite's horizontal velocity
     * @param velocity value of horizontal velocity
     */
    public void setVelocityX( double velocity ) {
        this.velocityX = velocity;
    }

    /**
     * Sets the sprite's vertical velocity
     * @param velocity value of vertical velocity
     */
    public void setVelocityY( double velocity ) {
        this.velocityY = velocity;
    }

    /**
     * Sets sprite's health
     * @param health value of health
     */
    public void setHealth( int health ) {
        this.health = health;
    }

    // --------------------------------------- ------- ---------------------------------------

    // --------------------------------------- GETTERS ---------------------------------------

    /**
     * Gets the sprite's current horizontal position
     * @return x coordinate
     */
    public double getPosX() {
        return posX;
    }

    /**
     * Gets the sprite's current vertical position
     * @return y coordinate
     */
    public double getPosY() {
        return posY;
    }

    /**
     * Gets the sprite's current horizontal velocity
     * @return horizontal velocity
     */
    public double getVelocityX() {
        return velocityX;
    }

    /**
     * Gets the sprite's vertical velocity
     * @return vertical velocity
     */
    public double getVelocityY() {
        return velocityY;
    }

    /**
     * Gets the sprite's width
     * @return width
     */
    public double getWidth() {
        return width;
    }

    /**
     * Gets the sprite's height
     * @return height
     */
    public double getHeight() {
        return height;
    }

    /**
     * Gets the sprite's movement speed
     * @return movement speed
     */
    public double getMovementSpeed() {
        return movementSpeed;
    }

    /**
     * Gets sprite's current health
     * @return health
     */
    public int getHealth() {
        return health;
    }

    /**
     * Gets sprite's max health
     * @return max health
     */
    public int getMaxHealth() {
        return maxHealth;
    }

    // --------------------------------------- ------- ---------------------------------------

    // --------------------------------------- METHODS ---------------------------------------

    /**
     * Method will simulate gravity force applied on the sprite
     * @param elapsedTime
     */
    public void gravityPull( double elapsedTime ) {
        velocityY += gravityForce * elapsedTime;
    }

    /**
     * Method for taking damage. When sprites take damage it decrements their health by one
     */
    public void takeDamage() {
        --health;
    }

}
