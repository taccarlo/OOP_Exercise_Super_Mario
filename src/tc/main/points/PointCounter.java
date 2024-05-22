package tc.main.points;

import tc.main.Constants;
import tc.main.actions.*;
import tc.main.monsters.*;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class convert an arraylist of string in an arraylist of actions and simulate the super mario game computing the resulting amount of points and lives.
 *
 * @author Carlo Tacchella
 * @version v0.0.1
 * @since 2024-05-22
 */
public class PointCounter {

    private static final Logger LOGGER = Logger.getLogger( PointCounter.class.getName() );

    Constants c = new Constants();
    private int points = c.defaultPoints();
    private int lives = c.defaultLifeNumber();
    //Is final to not rebind the variable to point to a different collection instance
    private final ArrayList<Action> actionsList;

    public PointCounter(ArrayList<String> actions){
        LOGGER.setLevel(Level.ALL);
        actionsList = new ArrayList<>();
        this.iterate(actions);
    }

    private void iterate(ArrayList<String> actions) {
        if(actions == null || actions.isEmpty()|| actionsList ==null) {
            LOGGER.severe("No actions found after parsing the content of the file.");
        }
        else {

            for(String act:actions){
                if(act.compareTo("coin")==0){
                    actionsList.add(new Coin());
                }
                else if(isStartingWith(act, "invincible")){
                    actionsList.add(new Invincible());
                }
                else if(isStartingWith(act, "fireballon")){
                    actionsList.add(new Fireball());
                }
                else if(isStartingWith(act, "consecutivelyjumpon")){
                    // ex. ConsecutivelyJumpOnBlargg
                    String monster = this.getMonster(act);

                    // I choose this algorithm only to apply a case of Build design pattern, it could be done in simpler ways
                    switch (monster) {
                        case "banzai_bill":
                            actionsList.add(new ConsecutivelyJump.ConsecutivelyJumpBuilder().setMonster(new BanzaiBill()).build());
                            break;
                        case "beach_koopa":
                            actionsList.add(new ConsecutivelyJump.ConsecutivelyJumpBuilder().setMonster(new BeachKoopa()).build());
                            break;
                        case "big_boo":
                            actionsList.add(new ConsecutivelyJump.ConsecutivelyJumpBuilder().setMonster(new BigBoo()).build());
                            break;
                        case "blargg":
                            actionsList.add(new ConsecutivelyJump.ConsecutivelyJumpBuilder().setMonster(new Blargg()).build());
                            break;
                        default:
                            LOGGER.severe("Unknown monster \"" + monster + "\".");

                    }

                }
                else{
                    LOGGER.severe("Unexpected Action \""+act+"\".");

                }

            }
        }
    }

    public String getMonster(String a) {
        // "consecutivelyjumpon" 19 letters
        int l = 19;
        return a.toLowerCase().trim().substring(l);
    }

    public boolean isStartingWith(String a, String b){
        int l = b.length();
        if(a.length()<b.length())
            return false;
        return a.substring(0,l).toLowerCase().compareTo(b)==0;
    }

    public boolean gameSimulation(){
        boolean win = true;
        boolean lastWasCJ=false;
        int pointsGained = 0;
        for(Action act: actionsList){

                // R3: if last was consecutivelyJump life count +1
                boolean isCJ = act instanceof ConsecutivelyJump;
                if(isCJ && lastWasCJ){
                    lives++;
                }
                lastWasCJ=isCJ;

                points+=act.pointChanges();

                // based on Example A, everytime we gained 1000 points we gain a
                // life but remove that amount of points from the total
                // see README.md file
                pointsGained += act.pointChanges();
                if(pointsGained/1000>0){
                    lives++;
                    pointsGained-=1000;
                    points-=1000;
                }

                lives+=act.lifeChanges();
                if(lives<=0) {
                    win = false;
                }
        }
        return win;
    }
    public int getPoints(){
        return points;
    }
    public int getLives(){
        return lives;
    }
}