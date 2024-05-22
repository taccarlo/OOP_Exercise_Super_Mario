package tc.main.monsters;

import tc.main.interfaces.Monster;
import tc.main.util.MonsterPoints;

public class BanzaiBill implements Monster {
    @Override
    public int value() {
        return MonsterPoints.BANZAIBILL;
    }
}
