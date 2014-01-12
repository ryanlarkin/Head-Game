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

    public Craft() throws MalformedURLException {
        //ImageIcon ii = new ImageIcon(this.getClass().getResource("craft.png"));
    String user = Launcher.getUser();
    getImage getImage = new getImage(new URL("http://skins.minecraft.net/MinecraftSkins/"+user+".png"));
        image = getImage.craft;
        width = image.getWidth();
        height = image.getHeight();
        visible = true;
        x = 40;
        y = 60;
    }
    public void play(String filename) throws MalformedURLException, LineUnavailableException, UnsupportedAudioFileException, IOException
{
try {
     URL defaultSound = this.getClass().getResource(filename);
     // getClass().getSy.getResource("/images/ads/WindowsNavigationStart.wav");
     File soundFile = new File(defaultSound.toURI());
     AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);
     Clip clip = AudioSystem.getClip();
     clip.open(audioInputStream);
     clip.start( );
} catch (Exception ex) {
     ex.printStackTrace();
}
}
   

double minX = 0;
double minY = 0;
public static double maxX = 384 - 16;

public static double maxY = 261 - 16;
public static double speed = 100;
    public void move() throws MalformedURLException, LineUnavailableException, UnsupportedAudioFileException, IOException {

        x = (int) (x + (dx * (speed / 100)));
        y = (int) (y + (dy * (speed / 100)));
if (x > maxX){
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

x =         (int) maxX  / 2;
y =         (int) (maxY / 2);
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
x =         (int) maxX  / 2;
y =         (int) (maxY / 2);
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
x =         (int) maxX  / 2;
y =         (int) (maxY / 2);
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
x =         (int) maxX  / 2;
y =         (int) (maxY / 2);
}       
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

   // public BufferedImage getImage() {
    //    return getImage();
   // }

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
        public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public boolean isVisible() {
        return visible;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }
}