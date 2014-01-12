package rtype;


import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ImageIcon;


public class Alien {

    private String craft = "alien.png";

    private int x;
    private int y;
    private int width;
    private int height;
    private boolean visible;
    private BufferedImage image;

    public Alien(int x, int y) throws MalformedURLException {
       String user = Launcher.getUser();
getImage getImage = new getImage(new URL("http://skins.minecraft.net/MinecraftSkins/"+user+".png"));
  image = getImage.craft;     
        width = 16;
        height = 16;
        visible = true;
        this.x = x;
        this.y = y;
    }


    public void move() {
        if (x < 0) {
            x = (int) Craft.maxX;
        }
        else
         if (y < 0) {
            y = (int) Craft.maxY;
         }


        else
         if(y > Craft.y && x>Craft.x){
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
    
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    public Image getImage() {
        return image;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }

    void isVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}