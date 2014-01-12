package rtype;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import static rtype.Craft.speed;

/**
 *
 * @author eandr127
 */
public class RType extends JFrame {
    
public static int X = 0;
public static int Y = 0;

    public RType() throws MalformedURLException {
        add(new Board());
        System.out.println("Game started");
        System.out.println("Head speed "  + speed+" (" + speed / 100 + ")");
        this.addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent e) {
                // This is only called when the user releases the mouse button.
                Y=getContentPane().getSize().height;
                X=getContentPane().getSize().width;
                Craft.maxY=Y - 16;
                Craft.maxX=X - 16;
            }
        });
        
        String user = Launcher.getUser();
        getImage getImage = new getImage(new URL("http://skins.minecraft.net/MinecraftSkins/"+user+".png"));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("Head Game: "+ user);
        setResizable(true);
        setExtendedState(MAXIMIZED_BOTH);
        //setResizable(false);
        setVisible(true);
        ImageIcon img = new ImageIcon(getImage.Facetest256);
        setIconImage(img.getImage());
        Y=getContentPane().getSize().height;
        X=getContentPane().getSize().width;
        startCMD();
    }

    public void startCMD(){
        new CommandListener();
    }


    public static void main(String[] args) throws MalformedURLException {
        new Launcher();
    }
}