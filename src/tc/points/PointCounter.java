package tc.points;

import tc.Main;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PointCounter {

    private static final Logger LOGGER = Logger.getLogger( Main.class.getName() );

    //Actions actions = null;
    private int points = 0;
    private int life = 0;

    public PointCounter(ArrayList<String> actions){

        LOGGER.setLevel(Level.ALL);
        this.iterate(actions);
    }

    private void iterate(ArrayList<String> actions) {
        if(actions.isEmpty())
            LOGGER.severe( "No actions found after parsing the content of the file.");

        for(String act:actions){
            //Builder
            switch(act){
                case "coin":
                    points+=5;
                    break;
            }
        }
    }

    public int getPoints(){
        return points;
    }
}
