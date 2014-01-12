package rtype;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import javax.swing.JFrame;

/**
 *
 * @author eandr127
 */
public class Launcher extends JFrame{
    public static String user;
    boolean isLooped = true;
    boolean click = false;
    
    public Launcher() throws MalformedURLException{
        System.out.println("Please enter your username.");
        while(isLooped == true){
            Scanner sc = new Scanner(System.in);
            user = sc.nextLine();
            getImage getImage = new getImage(new URL("http://skins.minecraft.net/MinecraftSkins/"+user+".png"));
            if(getImage.Facetest256 != null){
                System.out.println("User set to "+user+".");
                isLooped = false;
                if (click == false){
                    click = true;
                    isLooped=false;
                    System.out.println("Starting game.");
                    new RType();
                }
            }
            else {
                System.out.println("The username you entered either doesn't exist or doesn't have a skin.");
                System.out.println("Please enter your username.");
            }
        }   
    }
    
    public static String getUser(){
        return user;
    }
}