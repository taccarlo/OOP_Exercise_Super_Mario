package tc.monsters;

import tc.interfaces.Monster;
import tc.util.MonsterPoints;

public class BeachKoopa implements Monster {
    @Override
    public int value() {
        return MonsterPoints.BEACHKOOPA;
    }
}
