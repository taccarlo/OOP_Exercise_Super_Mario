package tc.monsters;
import tc.interfaces.Monster;
import tc.util.MonsterPoints;

public class Blargg implements Monster {
    @Override
    public int value() {
        return MonsterPoints.BLARGG;
    }
}
