package my.semestral.projectxd.yump;

import javafx.scene.shape.Rectangle;
import my.semestral.projectxd.yump.Controller.CollisionController;
import my.semestral.projectxd.yump.Model.PlatformTile;
import my.semestral.projectxd.yump.Model.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CollisionControllerTest {

    private Player player;
    private ArrayList<PlatformTile> platformTiles;
    private CollisionController cc;

    @BeforeEach
    public void initPlayer() {
        player = new Player( 1, 20, 25, 100, 100, 0, 4 );
        platformTiles = new ArrayList<PlatformTile>();
    }

    @Test
    public void testCollisionTop_true() {
        PlatformTile tile = new PlatformTile( 10,120, 200, 200 );
        platformTiles.add( tile );
        cc = new CollisionController( player, platformTiles );

        Assertions.assertEquals( true, cc.collideTop( new Rectangle( tile.getPosX(), tile.getPosY(), tile.getWidth(), tile.getHeight() ) ) );
    }

    @Test
    public void testCollisionTop_playerPos() {
        PlatformTile tile = new PlatformTile( 10,120, 200, 200 );
        platformTiles.add( tile );
        cc = new CollisionController( player, platformTiles );

        // 5 pixels inside platform (move player 5 pixels up)
        cc.handleCollision();
        Assertions.assertEquals( 20, player.getPosY() );
    }

    @Test
    public void testCollisionBot_false() {
        PlatformTile tile = new PlatformTile( 500, 500, 1, 1 );
        platformTiles.add( tile );
        cc = new CollisionController( player, platformTiles );

        Assertions.assertEquals( false, cc.collideTop( new Rectangle( tile.getPosX(), tile.getPosY(), tile.getWidth(), tile.getHeight() ) ) );
    }
}
