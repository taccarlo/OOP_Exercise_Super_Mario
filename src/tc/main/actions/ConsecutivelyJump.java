package tc.main.actions;
import tc.main.interfaces.Monster;

public class ConsecutivelyJump extends Action{
    private int pointChanged=0;
    @Override
    public void effects() {

    }

    @Override
    public int pointChanges() {
        return pointChanged;
    }

    @Override
    public int lifeChanges() {
        return 0;
    }

    private ConsecutivelyJump(ConsecutivelyJumpBuilder builder){
        this.pointChanged = builder.monster.value();
    }

    public static class ConsecutivelyJumpBuilder {
        private Monster monster ;

        public ConsecutivelyJump build(){
            return new ConsecutivelyJump(this);
        }
        public ConsecutivelyJumpBuilder setMonster(Monster m){
            this.monster = m;
            return this;
        }
    }
}
