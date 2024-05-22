package tc.main.monsters;

import tc.main.interfaces.Monster;
import tc.main.util.MonsterPoints;

/**
 * The BanzaiBill class used by ConsecutiveJumpingOn action
 *
 * @author Carlo Tacchella
 * @version v0.0.1
 * @since 2024-05-22
 */

public class BanzaiBill implements Monster {
    @Override
    public int value() {
        return MonsterPoints.BANZAIBILL;
    }
}
