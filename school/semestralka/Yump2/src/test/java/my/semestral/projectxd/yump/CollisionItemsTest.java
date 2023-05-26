package my.semestral.projectxd.yump;

import my.semestral.projectxd.yump.Controller.CollisionItems;
import my.semestral.projectxd.yump.Model.HealthPotion;
import my.semestral.projectxd.yump.Model.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CollisionItemsTest {

    private Player player;
    private CollisionItems collisionItems;

    @BeforeEach
    public void init() {
        player = new Player( 1, 0, 0, 20, 20, 20, 2 );
        collisionItems = new CollisionItems( player );
    }

    @Test
    public void testHeal() {
        HealthPotion potion = new HealthPotion( 0, 0, 1, 1 );
        collisionItems.pickedUp( potion );
        Assertions.assertEquals( 2, player.getHealth() );
    }

    @Test
    public void testNoOverheal() {
        HealthPotion potion = new HealthPotion( 0, 0, 1, 1 );
        collisionItems.pickedUp( potion );
        collisionItems.pickedUp( potion );
        collisionItems.pickedUp( potion );
        Assertions.assertEquals( 2, player.getHealth() );
    }

    @Test
    public void testOverheal_returnFalse() {
        HealthPotion potion = new HealthPotion( 0, 0, 1, 1 );
        collisionItems.pickedUp( potion );
        collisionItems.pickedUp( potion );
        Assertions.assertEquals( false, collisionItems.pickedUp( potion ) );
    }


}
