package commands;

import headGame.Head;

/**
 * Teleports the {@link headGame.Head} to a specified location
 * @author eandr127
 */
public class CommandTP{

    /**
     * Teleports the {@link headGame.Head} to a specified location
     * @param cmdArgs the command arguments
     */    
    public CommandTP(String[] cmdArgs){
        if(cmdArgs.length != 3){
            if (cmdArgs.length < 3){
                System.out.println("Not enough args");
                System.out.println("Usage: /tp [X] [Y]");
            }
            else {
                System.out.println("Too many args");
                System.out.println("Usage: /tp [X] [Y]");
            }
        }
        else {
            int toX = Integer.parseInt(cmdArgs[1]);
            int toY = Integer.parseInt(cmdArgs[2]);
            if(Head.maxX < toX){
                System.out.println("X must be less than " + Head.maxX); 
            }
            if(Head.maxY < toY){
                System.out.println("Y must be less than " + Head.maxY); 
            }
            else {
                Head.x = toX ;
                Head.y = toY ;
                System.out.println("Tp sucsess");
            }
        }
    }    
}
