package tc.game;

import java.util.ArrayList;

public class GameCreation {
    public GameCreation(ArrayList<String> actions){
        this.CreateGame(actions);
    }

    private void CreateGame(ArrayList<String> actions) {
        Action l;
        for(String i : actions){
            //se è una coin uso un oggetto specifico
            //se è un invincible uso un oggetto specifico
            // se è un fireball uso un oggetto specifico
            //se è un Jump
            //se è un consecutively jump

          // se è un mostro uso un builder
             l = ActionBuilder.newAction().name()

        }
    }
}
