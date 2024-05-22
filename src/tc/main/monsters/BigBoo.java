package tc.main.monsters;

import tc.main.interfaces.Monster;
import tc.main.util.MonsterPoints;

/**
 * The BigBoo class used by ConsecutiveJumpingOn action
 *
 * @author Carlo Tacchella
 * @version v0.0.1
 * @since 2024-05-22
 */
public class BigBoo implements Monster {
    @Override
    public int value() {
        return MonsterPoints.BIGBOO;
    }
}
