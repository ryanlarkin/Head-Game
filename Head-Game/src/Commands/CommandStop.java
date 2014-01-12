/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Commands;

/**
 *
 * @author Ryan
 */
public class CommandStop{
    public CommandStop(String[] cmdArgs){
    if(cmdArgs.length != 1){
    if (cmdArgs.length < 0){
        System.out.println("Not enough args");
        System.out.println("Usage: /stop");
    }
    else{
      System.out.println("Too many args");
              System.out.println("Usage: /stop");
    }
}
else{
System.out.println("Stoping game.");
System.exit(0);
}
}
}
