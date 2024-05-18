package tc.monsters;

import tc.interfaces.Monster;
import tc.util.MonsterPoints;

public class BigBoo implements Monster {
    @Override
    public int value() {
        return MonsterPoints.BIGBOO;
    }
}
