package my.semestral.projectxd.yump.Model;


/**
 * Platform class representing a platform for sprites to stand on
 */
public class PlatformTile {

    private double posX;
    private double posY;
    private double width;
    private double height;

    /**
     * Creates platform instance
     * @param posX - x position
     * @param posY - y position
     * @param width - width
     * @param height - height
     */
    public PlatformTile( double posX, double posY, double width, double height ) {
        this.posX = posX;
        this.posY = posY;
        this.width = width;
        this.height = height;
    }


    /* ------------------------------- GETTERS ------------------------------- */

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
    /* ------------------------------- ------- ------------------------------- */


}
