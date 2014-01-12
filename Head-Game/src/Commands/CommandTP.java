/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Commands;

import rtype.Craft;

/**
 *
 * @author Ryan
 */
public class CommandTP{
public CommandTP(String[] cmdArgs){
    if(cmdArgs.length != 3){
    if (cmdArgs.length < 3){
        System.out.println("Not enough args");
        System.out.println("Usage: /tp [X] [Y]");
    }
    else{
      System.out.println("Too many args");
              System.out.println("Usage: /tp [X] [Y]");
    }
}
else{
    int toX = Integer.parseInt(cmdArgs[1]);
    int toY = Integer.parseInt(cmdArgs[2]);
    if(Craft.maxX < toX){
       System.out.println("X must be less than " + Craft.maxX); 
    }
        if(Craft.maxY < toY){
       System.out.println("Y must be less than " + Craft.maxY); 
    }
        else{
            
        
    Craft.x = toX ;
        Craft.y = toY ;
        System.out.println("Tp sucsess");
        }
}
}    
}
