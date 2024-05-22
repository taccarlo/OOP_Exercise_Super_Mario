package tc.main;
/**
 * This class has the constants about the default values of the game and the path and the name of the input file
 *
 * @author Carlo Tacchella
 * @version v0.0.1
 * @since 2024-05-22
 */
public class Constants {

    // This file could be improved moving the properties in a property file.

    public String getPath(){
        return ".";
    }

    public String getFileName() {
        return "SuperMario-seq.txt";
    }

    public int defaultLifeNumber(){
        return 3;
    }

    public int defaultPoints(){
        return 2000;
    }
}

