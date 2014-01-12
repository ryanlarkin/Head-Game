package commands;

/**
 * Prints the usage for {@link CommandSpeed} to the terminal
 * @author eandr127
 */
public class CommandSpeedUsage{
    
    /**
     * Prints the usage for {@link CommandSpeed} to the terminal
     * @param cmdArgs the command arguments
     */
    public CommandSpeedUsage(String[] cmdArgs){
        System.out.println("Not enough args");
        System.out.println("Usage: /speed [Speed]");
    }
}
