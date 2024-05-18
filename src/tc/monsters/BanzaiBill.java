package tc.monsters;

import tc.interfaces.Monster;
import tc.util.MonsterPoints;

public class BanzaiBill implements Monster {
    @Override
    public int value() {
        return MonsterPoints.BANZAIBILL;
    }
}
