package tc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import java.io.InputStream;

import java.util.logging.Level;
import java.util.logging.Logger;

import tc.Constants;

public class FileManager {

    private static final Logger LOGGER = Logger.getLogger( Main.class.getName() );
    private String lineRead="";

    public FileManager(){
        LOGGER.setLevel(Level.ALL);
        Constants c = new Constants();
        try {
            File myObj = new File(c.getPath()+"/"+c.getFileName());
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
