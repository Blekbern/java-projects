package my.semestral.projectxd.yump.Model;

/**
 * Class represents health potion as an item
 */
public class HealthPotion extends Item {

    /**
     * Creates health potion instance
     * @param posX - x position
     * @param posY - y position
     * @param width - width
     * @param height - height
     */
    public HealthPotion(double posX, double posY, double width, double height) {
        super(posX, posY, width, height);
    }

    /**
     * Method checks whether player can be healed or not if yes heal by one health
     * @param player gets ref to player
     * @return true if player was healed
     */
    public boolean healPlayer( Player player ) {
        if( player.getHealth() < player.getMaxHealth() ) {
            player.setHealth(player.getHealth() + 1);
            return true;
        }
        return false;
    }

}
