package tc.main.actions;

public class Coin extends Action{

    @Override
    public int pointChanges() {
        return 10;
    }

    @Override
    public int lifeChanges() {
        return 0;
    }
}
