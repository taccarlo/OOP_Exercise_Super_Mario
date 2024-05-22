package tc.main.input;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import java.util.logging.Level;
import java.util.logging.Logger;

import tc.main.Constants;

/**
 * This class manages the input file of the application
 *
 * @author Carlo Tacchella
 * @version v0.0.1
 * @since 2024-05-22
 */

public class FileManager {

    private static final Logger LOGGER = Logger.getLogger( FileManager.class.getName() );
    private final String lineRead;

    public FileManager(){
        LOGGER.setLevel(Level.ALL);
        Constants c = new Constants();
        try {
            File myObj = new File(c.getPath() + "/" + c.getFileName());
            Scanner myReader = new Scanner(myObj);
            StringBuilder sb = new StringBuilder();

            while (myReader.hasNextLine()) {
                sb.append(myReader.nextLine());
            }

            lineRead=sb.toString();
            myReader.close();
        } catch (FileNotFoundException e) {
            LOGGER.severe("Error occurred trying to open file");
            throw new RuntimeException(e);
        }

    }
    public String getInput() {
        return lineRead;
    }
}
