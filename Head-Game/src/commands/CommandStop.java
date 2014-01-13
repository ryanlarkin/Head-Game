package commands;

/**
 * Stops the game
 * @author eandr127
 */
public class CommandStop {
    
    /**
     * Stops the game
     * @param cmdArgs the command arguments
     */
    public CommandStop(String[] cmdArgs){
        System.out.println("Stoping game.");
        System.exit(0);
    }
}