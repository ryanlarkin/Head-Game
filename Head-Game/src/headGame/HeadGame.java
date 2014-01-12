package headGame;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import static headGame.Head.speed;

/**
 * Initialization logic
 * @author eandr127
 * @author Jan Bodnar
 */
public class HeadGame extends JFrame {
    
public static int X = 0;
public static int Y = 0;

    /**
     * Initializes the {@link Board}, initializes the
     *  {@link EnemyHead}, {@link Head} and {@link Board} parameters and starts the command listener
     * @throws MalformedURLException if the users skin is null when calling {@link GetImage}
     */
    public HeadGame() throws MalformedURLException {
        add(new Board());
        System.out.println("Game started");
        System.out.println("Head speed "  + speed+" (" + speed / 100 + ")");
        this.addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent e) {
                // This is only called when the user releases the mouse button.
                Y=getContentPane().getSize().height;
                X=getContentPane().getSize().width;
                Head.maxY=Y - 16;
                Head.maxX=X - 16;
            }
        });
        
        String user = Launcher.getUser();
        GetImage getImage = new GetImage(new URL("http://skins.minecraft.net/MinecraftSkins/"+user+".png"));
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
    /**
     * Starts the {@link CommandListener}
     */
    public void startCMD(){
        new CommandListener();
    }

    /**
     * Starts the {@link Launcher}
     * @param args the Java arguments
     * @throws MalformedURLException if the users skin is null when calling {@link GetImage}
     */
    public static void main(String[] args) throws MalformedURLException {
        new Launcher();
    }
}