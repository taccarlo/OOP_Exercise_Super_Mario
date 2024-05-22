package tc.test.points;

import org.junit.jupiter.api.Test;
import tc.main.points.PointCounter;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This class contains the tests of PointCounter class
 *
 * @author Carlo Tacchella
 * @version v0.0.1
 * @since 2024-05-22
 */
class PointCounterTest {
    @Test
    void isStartingWithTest() {
        PointCounter pc = new PointCounter(new ArrayList<>());
        assertTrue(pc.isStartingWith("a","a"));
        assertFalse(pc.isStartingWith("ab","b"));
        assertFalse(pc.isStartingWith("ab","ac"));
        assertTrue(pc.isStartingWith("ciao","cia"));
        assertFalse(pc.isStartingWith("ciaoatutti","ciaoo"));
    }

    @Test
    void getMonsterTest() {
        PointCounter pc = new PointCounter(new ArrayList<>());
        assertEquals(pc.getMonster("ConsecutivelyJumpOnBlargg"), "Blargg".toLowerCase());
        assertEquals(pc.getMonster("ConsecutivelyJumpOnBig_Boo"), "Big_Boo".toLowerCase());
    }

}