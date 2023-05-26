package my.semestral.projectxd.yump.Controller;

import javafx.scene.shape.Rectangle;
import my.semestral.projectxd.yump.Model.HealthPotion;
import my.semestral.projectxd.yump.Model.Player;
import my.semestral.projectxd.yump.Model.VictoryPole;

/**
 * Logic for picking up items
 */
public class CollisionItems {

    private Player player;

    /**
     * Creates collision item instance
     * @param player init player attribute
     */
    public CollisionItems( Player player ) {
        this.player = player;
    }

    /**
     * Method makes player pick up health potion if he needs to
     * @param potion gets ref to HealthPotion
     * @return true if player picked up potion
     */
    public boolean pickedUp( HealthPotion potion ) {
        Rectangle playerHitbox = new Rectangle( player.getPosX(), player.getPosY(), player.getWidth(), player.getHeight() );
        Rectangle potionHB = new Rectangle( potion.getPosX(), potion.getPosY(), potion.getWidth(), potion.getHeight() );
        if( playerHitbox.getBoundsInParent().intersects(potionHB.getBoundsInParent())) {
            if( potion.healPlayer(player) )
                return true;
        }
        return false;
    }

    /**
     * Method makes player touch the pole
     * @param pole gets ref to VictoryPole
     * @return true if player touched pole
     */
    public boolean touchPole( VictoryPole pole ) {
        Rectangle playerHitbox = new Rectangle( player.getPosX(), player.getPosY(), player.getWidth(), player.getHeight() );
        Rectangle vicPole = new Rectangle( pole.getPosX(), pole.getPosY(), pole.getWidth(), pole.getHeight() );
        if( playerHitbox.getBoundsInParent().intersects(vicPole.getBoundsInParent()))
                return true;
        return false;
    }
}
