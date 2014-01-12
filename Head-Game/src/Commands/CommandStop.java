package Commands;

/**
 *
 * @author eandr127
 */
public class CommandStop{
    public CommandStop(String[] cmdArgs){
        if(cmdArgs.length != 1){
            if (cmdArgs.length < 0){
                System.out.println("Not enough args");
                System.out.println("Usage: /stop");
            }
            else {
                System.out.println("Too many args");
                System.out.println("Usage: /stop");
            }
        }
        else {
            System.out.println("Stoping game.");
            System.exit(0);
        }
    }
}
