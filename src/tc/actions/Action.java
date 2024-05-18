package tc.actions;

public abstract class Action {
    public abstract void effects();
    public abstract int pointChanges();
    public abstract int lifeChanges();
}
