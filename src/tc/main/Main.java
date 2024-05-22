package tc.main;

import tc.main.input.FileManager;
import tc.main.parsing.CommandsParser;
import tc.main.points.PointCounter;

import java.util.ArrayList;
import java.util.logging.Logger;
import java.util.logging.Level;

/**
 * A simple command-line application for solving Super Mario Algorithm.
 * This is the Main File
 *
 * @author Carlo Tacchella
 * @version v0.0.1
 * @since 2024-05-22
 */

public class Main {
    private static final Logger LOGGER = Logger.getLogger( Main.class.getName() );

    public static void main(String[] args) {

        System.out.println("\n*****************\nSuper Mario\n*****************\n");
        LOGGER.setLevel(Level.ALL);

        LOGGER.info("Reading from the file the game actions.");

        FileManager fm = new FileManager();

        // get tc.main.input text from the file
        String input = fm.getInput();

        LOGGER.info("Action sequence read: "+input);

        CommandsParser cp = new CommandsParser(input);

        ArrayList<String> actions = cp.getTokens();

        LOGGER.info("Action sequence ArrayList: "+actions);

        PointCounter pc = new PointCounter(actions);
        boolean win = pc.gameSimulation();

        System.out.println("\n*****************\nRESULTS: \n*****************\n");
        if(win){
            System.out.println("Winning game, life count never went down to zero.");
        }
        else{
            System.out.println("Lost game, life count went down to zero at least one time.");
        }

        System.out.println("Total points Gained: "+pc.getPoints());
        System.out.println("Total life Gained: "+pc.getLives());
        System.out.println("Game actions: "+actions.toString());

    }
}