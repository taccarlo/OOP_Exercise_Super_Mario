package tc.main.actions;

public class Invincible extends Action{

    @Override
    public int pointChanges() {
        return 0;
    }

    @Override
    public int lifeChanges() {
        return -1;
    }
}
