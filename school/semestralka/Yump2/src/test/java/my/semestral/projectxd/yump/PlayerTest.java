package my.semestral.projectxd.yump;

import my.semestral.projectxd.yump.Model.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PlayerTest {

    private Player player;

    @BeforeEach
    public void init() {
        player = new Player( 4, 0, 0, 50, 50, 200, 5 );
    }

    @Test
    public void testConstruct() {
        Assertions.assertEquals( 4, player.getHealth());
        Assertions.assertEquals( 0, player.getPosX());
        Assertions.assertEquals( 0, player.getPosY());
        Assertions.assertEquals( 50, player.getWidth());
        Assertions.assertEquals( 50, player.getHeight());
        Assertions.assertEquals( 200, player.getMovementSpeed());
        Assertions.assertEquals( 5, player.getMaxHealth());
    }

    @Test
    public void testJump_returnVelocityYNeg500() {
        player.jump();
        Assertions.assertEquals( -500, player.getVelocityY() );
    }

    @Test
    public void testNoDoubleJump() {
        player.jump();
        player.jump();
        Assertions.assertEquals( -500, player.getVelocityY() );
    }
}
