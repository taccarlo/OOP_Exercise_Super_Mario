package tc.main;

import tc.main.input.FileManager;
import tc.main.parsing.CommandsParser;
import tc.main.points.PointCounter;

import java.util.ArrayList;
import java.util.logging.Logger;
import java.util.logging.Level;

/**
 * A simple command-line application for solving Super Mario Algorithm.
 *
 * @author Carlo Tacchella
 * @version v0.0.1
 */

public class Main {
    private static final Logger LOGGER = Logger.getLogger( Main.class.getName() );

    public static void main(String[] args) {

        System.out.println("Super Mario");
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
        int points = pc.pointsCounting();
        LOGGER.info( "Punti contati in "+actions+" "+points);
        //pc.getIfDeathDuringGame();
        //pc.getLifeCountAfterGame();
        //pc.pointCounter(tc.main.actions);

        /*

        //export executable example
        //javadoc
        //Exception handling custom
         */

    }
}