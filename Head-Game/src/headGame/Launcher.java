package headGame;

import java.awt.BorderLayout;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;

/**
 * The startup logic
 * @author eandr127
 */
public class Launcher {
    public static String user;
    boolean isLooped = true;
    boolean click = false;

    /**
     * The startup logic
     * @throws MalformedURLException in case skin does not exist
     */
    public Launcher() throws MalformedURLException {
        /**System.out.println("Please enter your username.");
        while(isLooped == true){
            Scanner sc = new Scanner(System.in);
            user = sc.nextLine();
            //NOTE: We are not related to Minecraft or Mojang
            GetImage getImage = new GetImage(new URL("http://skins.minecraft.net/MinecraftSkins/"+user+".png"));
            if(getImage.Facetest256 != null){
                System.out.println("User set to "+user+".");
                isLooped = false;
                if (click == false){
                    click = true;
                    isLooped=false;
                    System.out.println("Starting game.");
                    new HeadGame();
                }
            }
            else {
                System.out.println("The username you entered either doesn't exist or doesn't have a skin.");
                //NOTE: We are not related to Minecraft or Mojang
                System.out.println("Please enter Minecraft your username.");
            }
        }**/  
        JFrame frame = new JFrame("FrameDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(250, 250);
        JTextField field = new JTextField();
        field.setBounds(125, 125, 250, 5);
        JButton button = new JButton("Play");
        JLabel out = new JLabel();
        out.setText("Please enter a username above.");
        frame.getContentPane().add(field, BorderLayout.NORTH);
        frame.getContentPane().add(button, BorderLayout.SOUTH);
        frame.getContentPane().add(out, BorderLayout.CENTER);
        frame.setVisible(true);
        
        button.addActionListener( (e) -> {
            System.out.println(field.getText());
            if(start(field.getText()) == false) {
                out.setText("There was a problem when trying to start your game");
            }
            else {
                out.setText("Starting game");
                frame.setVisible(false);
            }
        });
    }
    
    private boolean start(String playerName) {
        try {
            user = playerName;
            GetImage getImage = new GetImage(new URL("http://skins.minecraft.net/MinecraftSkins/"+user+".png"));
            if(getImage.Facetest256 != null){
                System.out.println("User set to "+user+".");
                isLooped = false;
                if (click == false){
                    click = true;
                    isLooped=false;
                    System.out.println("Starting game.");
                    new HeadGame();
                    return true;
                }
            }
            else {
                System.out.println("The username you entered either doesn't exist or doesn't have a skin.");
                //NOTE: We are not related to Minecraft or Mojang
                System.out.println("Please enter Minecraft your username.");
                return false;
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(Launcher.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    /**
     * Gets the last user entered on startup
     * @return The last user entered on startup
     */
    public static String getUser() {
        return user;
    }
}