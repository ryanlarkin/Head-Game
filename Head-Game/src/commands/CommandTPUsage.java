package commands;

/**
 * Prints the usage for {@link CommandTP} to the terminal
 * @author eandr127
 */
public class CommandTPUsage {
    
    /**
     * Prints the usage for {@link CommandTP} to the terminal
     * @param cmdArgs the command arguments
     */    
    public CommandTPUsage(String[] cmdArgs){
        System.out.println("Not enough args");
        System.out.println("Usage: /tp [X] [Y]");
    }
}
