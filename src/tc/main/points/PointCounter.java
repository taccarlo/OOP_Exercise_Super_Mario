package tc.main.points;

import tc.main.Constants;
import tc.main.actions.*;
import tc.main.monsters.*;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PointCounter {

    private static final Logger LOGGER = Logger.getLogger( PointCounter.class.getName() );

    Constants c = new Constants();
    private int points = c.defaultPoints();
    private int life = c.defaultLifeNumber();
    //Is final to not rebind the variable to point to a different collection instance
    private final ArrayList<Action> actionsList;

    public PointCounter(ArrayList<String> actions){

        LOGGER.setLevel(Level.ALL);
        this.iterate(actions);
         actionsList = new ArrayList<Action>();
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
                    /*
                        Banzai_Bill: 200 points
                        Beach_Koopa: 400 points
                        Big_Boo: 800 points
                        Blargg: 1600 points
                        ex. ConsecutivelyJumpOnBlargg

                     */
                    String monster = this.getMonster(act);

                    // I choose this algorithm only to apply a case of Build design pattern

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
                    LOGGER.severe("Unexpected Action.");

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
        return a.substring(0,l).toLowerCase().compareTo(b)==0;
    }

    public int pointsCounting(){
        for(Action act: actionsList){
                points+=act.pointChanges();
        }
        return points;
    }
}