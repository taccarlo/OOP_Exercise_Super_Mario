package tc.main.parsing;

import tc.main.Main;

import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CommandsParser {
    private final ArrayList<String> tokens = new ArrayList<>();
    private static final Logger LOGGER = Logger.getLogger( Main.class.getName() );

    public CommandsParser(String str){

        LOGGER.setLevel(Level.ALL);
        StringTokenizer tokenizer = new StringTokenizer(str, ",");
        String token;
        while (tokenizer.hasMoreElements()) {
            // put all actions lower case, without spaces to avoid mistakes in bad input format
            token = tokenizer.nextToken().toLowerCase().trim();
            tokens.add(token);
        }
        if(tokens.isEmpty()){
            LOGGER.warning("File is empty");
        }
    }

    public ArrayList<String> getTokens(){
        return tokens;
    }



}
