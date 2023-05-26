package my.semestral.projectxd.yump.Model;

/**
 * Abstract class representing a general item in the game
 */
public abstract class Item {
    private double posX;
    private double posY;
    private double width;
    private double height;

    /**
     * Constructor for creating items
     * @param posX - x position
     * @param posY - y position
     * @param width - width
     * @param height - height
     */
    public Item( double posX, double posY, double width, double height ) {
        this.posX = posX;
        this.posY = posY;
        this.width = width;
        this.height = height;
    }

    /**
     * Gets x position
     * @return x position
     */
    public double getPosX() {
        return posX;
    }

    /**
     * Gets y position
     * @return y position
     */
    public double getPosY() {
        return posY;
    }

    /**
     * Gets width
     * @return width
     */
    public double getWidth() {
        return width;
    }

    /**
     * Gets height
     * @return height
     */
    public double getHeight() {
        return height;
    }
}
