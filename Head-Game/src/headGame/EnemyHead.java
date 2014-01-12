package headGame;


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
 * @author Jan Bodnar
 */
public class EnemyHead {
    private int x;
    private int y;
    private int width;
    private int height;
    private boolean visible;
    private BufferedImage image;

    /**
     * The enemy heads on the {@link Board}
     * @param x the X coordinate of the {@link EnemyHead}
     * @param y the Y coordinate of the {@link EnemyHead}
     * @throws MalformedURLException if the users skin is null when calling {@link GetImage}
     */
    public EnemyHead(int x, int y) throws MalformedURLException {
        String user = Launcher.getUser();
        GetImage getImage = new GetImage(new URL("http://skins.minecraft.net/MinecraftSkins/"+user+".png"));
        image = getImage.head;     
        width = 16;
        height = 16;
        visible = true;
        this.x = x;
        this.y = y;
    }

    /**
     * Moves the {link EnemyHead}
     */
    public void move() {
        if (x < 0) {
            x = (int) Head.maxX;
        }
        else if (y < 0) {
            y = (int) Head.maxY;
        }
        else if(y > Head.y && x>Head.x){
            y-=1;
            x-=1;
        }
        else if (y < Head.y && x< Head.x){
            y += 1;
            x += 1;
        }
        else if(x > Head.x && y< Head.y){
            x-=1;
            y+=1;
        }
        else if(x< Head.x && y > Head.y){
            x+=1;
            y-=1;
        }
        else if(x<Head.x){
            x+=1;
        }
        else if(x>Head.x){
            x-=1;
        }
        else if(y < Head.y){
            y+=1;
        }
        else if(y > Head.y){
            y-=1;
        }             
    }
    
    /**
     * Gets the X coordinate of the {@link EnemyHead}
     * @return the X coordinate of the {@link EnemyHead}
     */ 
    public int getX() {
        return x;
    }

    /**
     * Gets the X coordinate of the {@link EnemyHead}
     * @return the X coordinate of the {@link EnemyHead}
     */    
    public int getY() {
        return y;
    }

    /**
     * Get if {@link Head} is visible
     * @return Weather {@link Head} is visible or not
     */    
    public boolean isVisible() {
        return visible;
    }

    /**
     * Set the {@link EnemyHead} to visible or invisible
     * @param visible if true visible, if false invisible
     */    
    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    /**
     * Gets the {@link EnemyHead}'s {@link java.awt.Image} 
     * @return The {@link EnemyHead}'s {@link java.awt.Image}
     */
    public Image getImage() {
        return image;
    }

    /**
     * Gets the bounds of the {@link EnemyHead}
     * @return The bounds of the {@link EnemyHead}
     */    
    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }
}