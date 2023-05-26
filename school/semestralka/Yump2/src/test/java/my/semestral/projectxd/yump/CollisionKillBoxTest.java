package my.semestral.projectxd.yump;

import my.semestral.projectxd.yump.Controller.CollisionKillBox;
import my.semestral.projectxd.yump.Model.Enemy;
import my.semestral.projectxd.yump.Model.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CollisionKillBoxTest {

    private CollisionKillBox ckb;
    private Player player;

    @BeforeEach
    public void init() {
        player = new Player(1,0,0,10,10,10,10 );
        ckb = new CollisionKillBox( player );
    }

    @Test
    public void killEnemy_return1() {
        Enemy enemy = new Enemy( 1, 0,9,10,10,0,1 );
        Assertions.assertEquals( 1, ckb.kill( enemy ) );
    }

    @Test
    public void getKilled_returnNeg1() {
        Enemy enemy = new Enemy( 1, 9, 0, 10, 10, 0 , 1 );
        Assertions.assertEquals( -1, ckb.kill( enemy ) );
    }
}
