package rtype;


import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ImageIcon;

/**
 * The enemy heads on the {@link Board}
 * @author eandr127
 */
public class Alien {

    private String craft = "alien.png";

    private int x;
    private int y;
    private int width;
    private int height;
    private boolean visible;
    private BufferedImage image;

    /**
     * The enemy heads on the {@link Board}
     * @param x the X coordinate of the {@link Alien}
     * @param y the Y coordinate of the {@link Alien}
     * @throws MalformedURLException if the users skin is null when calling {@link GetImage}
     */
    public Alien(int x, int y) throws MalformedURLException {
        String user = Launcher.getUser();
        GetImage getImage = new GetImage(new URL("http://skins.minecraft.net/MinecraftSkins/"+user+".png"));
        image = getImage.craft;     
        width = 16;
        height = 16;
        visible = true;
        this.x = x;
        this.y = y;
    }

    /**
     * Moves the {link Alien}
     */
    public void move() {
        if (x < 0) {
            x = (int) Craft.maxX;
        }
        else if (y < 0) {
            y = (int) Craft.maxY;
        }
        else if(y > Craft.y && x>Craft.x){
            y-=1;
            x-=1;
        }
        else if (y < Craft.y && x< Craft.x){
            y += 1;
            x += 1;
        }
        else if(x > Craft.x && y< Craft.y){
            x-=1;
            y+=1;
        }
        else if(x< Craft.x && y > Craft.y){
            x+=1;
            y-=1;
        }
        else if(x<Craft.x){
            x+=1;
        }
        else if(x>Craft.x){
            x-=1;
        }
        else if(y < Craft.y){
            y+=1;
        }
        else if(y > Craft.y){
            y-=1;
        }             
    }
    
    /**
     * Gets the X coordinate of the {@link Alien}
     * @return the X coordinate of the {@link Alien}
     */ 
    public int getX() {
        return x;
    }

    /**
     * Gets the X coordinate of the {@link Alien}
     * @return the X coordinate of the {@link Alien}
     */    
    public int getY() {
        return y;
    }

    /**
     * Get if {@link Craft} is visible
     * @return Weather {@link Craft} is visible or not
     */    
    public boolean isVisible() {
        return visible;
    }

    /**
     * Set the {@link Alien} to visible or invisible
     * @param visible if true visible, if false invisible
     */    
    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    /**
     * Gets the {@link Alien}'s {@link java.awt.Image} 
     * @return The {@link Alien}'s {@link java.awt.Image}
     */
    public Image getImage() {
        return image;
    }

    /**
     * Gets the bounds of the {@link Alien}
     * @return The bounds of the {@link Alien}
     */    
    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }
}