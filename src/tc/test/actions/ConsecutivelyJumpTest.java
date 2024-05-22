package tc.test.actions;

import org.junit.jupiter.api.Test;
import tc.main.Constants;
import tc.main.actions.ConsecutivelyJump;
import tc.main.monsters.BeachKoopa;
import tc.main.monsters.Blargg;
import tc.main.util.MonsterPoints;

import static org.junit.jupiter.api.Assertions.*;

class ConsecutivelyJumpTest {
    @Test
    void ConsecutivelyJumpBuilderTest() {
        ConsecutivelyJump cj = new ConsecutivelyJump.ConsecutivelyJumpBuilder().setMonster(new Blargg()).build();
        Constants c = new Constants();
        assertEquals(cj.pointChanges(), MonsterPoints.BLARGG);
        ConsecutivelyJump cj2 = new ConsecutivelyJump.ConsecutivelyJumpBuilder().setMonster(new BeachKoopa()).build();
        assertEquals(cj2.pointChanges(), MonsterPoints.BEACHKOOPA);

    }

}