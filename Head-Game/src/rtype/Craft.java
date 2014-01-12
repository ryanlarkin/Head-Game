package rtype;

import java.awt.Color;
import static java.awt.Color.white;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import javax.swing.ImageIcon;

/**
 * The head on the {@link Board}
 * @author eandr127
 */
public class Craft {


    private String craft = "craft.png";

    public static int X;
    public static int Y;
    private int width;
    private int height;
    private int dx;
    private int dy;
    public static int x;
    public static int y;
    private BufferedImage image;
    private boolean visible;

    /**
     * The head on the {@link Board}
     * @throws MalformedURLException if the users skin is null when calling {@link GetImage1}
     */
    public Craft() throws MalformedURLException {
        //ImageIcon ii = new ImageIcon(this.getClass().getResource("craft.png"));
        String user = Launcher.getUser();
        GetImage1 getImage = new GetImage1(new URL("http://skins.minecraft.net/MinecraftSkins/"+user+".png"));
        image = getImage.craft;
        width = image.getWidth();
        height = image.getHeight();
        visible = true;
        x = 40;
        y = 60;
    }
    
    /**
     * Plays a {@link java.io.File} inside JAR based on filename
     * @param filename the path to {@link java.io.File}
     * @throws MalformedURLException in case the {@link java.net.URL} does not exist
     * @throws UnsupportedAudioFileException in case the sound format of the {@link java.io.File} is unsupported
     * @throws IOException in case their is an error reading the {@link java.io.File}
     */
    public void play(String filename) throws MalformedURLException, UnsupportedAudioFileException, IOException
    {
        try {
            URL defaultSound = this.getClass().getResource(filename);
            // getClass().getSy.getResource("/images/ads/WindowsNavigationStart.wav");
            File soundFile = new File(defaultSound.toURI());
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start( );
        } 
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
   

    double minX = 0;
    double minY = 0;
    public static double maxX = 384 - 16;

    public static double maxY = 261 - 16;
    public static double speed = 100;
    
    /**
     * Moves the {link Craft}
     * @throws MalformedURLException in case the {@link java.net.URL} does not exist
     * @throws UnsupportedAudioFileException in case the sound format of the {@link java.io.File} is unsupported
     * @throws IOException in case their is an error reading the {@link java.io.File}
     */
    public void move() throws MalformedURLException, UnsupportedAudioFileException, IOException {
        x = (int) (x + (dx * (speed / 100)));
        y = (int) (y + (dy * (speed / 100)));
        
        if (x > maxX) {
            Random rand = new Random(); 
            int value = rand.nextInt(4);
            switch (value) {
                case 0:  play("explode1.wav");
                     break;
                case 1:  play("explode2.wav");
                     break;
                case 2:  play("explode3.wav");
                     break;
                case 3:  play("explode4.wav");
                     break;
            }

        x = (int) maxX  / 2;
        y = (int) (maxY / 2);
        }
        
        if (y > maxY){
            Random rand = new Random(); 
            int value = rand.nextInt(4);
            switch (value) {
                case 0:  play("explode1.wav");
                    break;
                case 1:  play("explode2.wav");
                    break;
                case 2:  play("explode3.wav");
                    break;
                case 3:  play("explode4.wav");
                    break;
            }
                
            x = (int) maxX  / 2;
            y = (int) (maxY / 2);
        }
        
        if (x < minX){
            Random rand = new Random(); 
            int value = rand.nextInt(4);
            switch (value) {
                case 0:  play("explode1.wav");
                     break;
                case 1:  play("explode2.wav");
                     break;
                case 2:  play("explode3.wav");
                     break;
                case 3:  play("explode4.wav");
                     break;
            }
            
            x = (int) maxX  / 2;
            y = (int) (maxY / 2);
        }
        
        if (y < minY){
            Random rand = new Random(); 
            int value = rand.nextInt(4);
            switch (value) {
                case 0:  play("explode1.wav");
                     break;
                case 1:  play("explode2.wav");
                     break;
                case 2:  play("explode3.wav");
                     break;
                case 3:  play("explode4.wav");
                     break;
            }
            
            x = (int) maxX  / 2;
            y = (int) (maxY / 2);
        }       
    }
    
    /**
     * Gets the X coordinate of the {@link Craft}
     * @return the X coordinate of the {@link Craft}
     */
    public int getX() {
        return x;
    }

    /**
     * Gets the Y coordinate of the {@link Craft}
     * @return the Y coordinate of the {@link Craft}
     */    
    public int getY() {
        return y;
    }

    /**
     * Handle {@link java.awt.event.KeyEvent} pressed
     * @param e the {@link java.awt.event.KeyEvent} to handle
     */
    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = -1;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 1;
        }

        if (key == KeyEvent.VK_UP) {
            dy = -1;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 1;
        }
        if (key == KeyEvent.VK_SPACE) {
            speed *= 2;
        }
        //if(key == KeyEvent.VK_ESCAPE){
            
        //}
        if (key == KeyEvent.VK_P) {
            System.out.println("X = " + x);
            System.out.println("Y = " + y);
        }
    }

    /**
     * Handle {@link java.awt.event.KeyEvent} released
     * @param e the {@link java.awt.event.KeyEvent} to handle
     */
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_UP) {
            dy = 0;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 0;
        }
        if (key == KeyEvent.VK_SPACE) {
            speed /= 2;
        }
    }
    
    /**
     * Set the {@link Craft} to visible or invisible
     * @param visible if true visible, if false invisible
     */
    public void setVisible(boolean visible) {
        this.visible = visible;
    }
    
    /**
     * Get if {@link Craft} is visible
     * @return Weather {@link Craft} is visible or not
     */
    public boolean isVisible() {
        return visible;
    }
    
    /**
     * Gets the bounds of the {@link Craft}
     * @return The bounds of the {@link Craft}
     */
    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }
}