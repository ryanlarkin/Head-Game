package headGame;

import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;

/**
 * Gets the image from the {@link java.net.URL} and sets the {@link Head}'s {@link java.awt.Image} to it
 * @author eandr127
 */
public class GetImage {
     private BufferedImage img;
     BufferedImage head;
     BufferedImage Facetest256;
     Rectangle rect = new Rectangle(8, 16);
     
    /**
     * Gets the image from {@link java.net.URL} and sets the {@link Head}'s {@link java.awt.Image} to it
     * @param url the URL of the image
     */ 
    public GetImage(URL url){
        BufferedImage[] array = new BufferedImage[2];
        try {
            img = ImageIO.read(url);
            img =cropImage(img, rect);
            Facetest256 = enlarge(img, 32);
            head = enlarge(img, 2);
            img = enlarge(img, 2);
            if(url.equals("http://skins.minecraft.net/MinecraftSkins/Dinnerbone.png") || url.equals("http://skins.minecraft.net/MinecraftSkins/Grumm.png")){
                img = flipImage(img,180);
                Facetest256 = flipImage(Facetest256,180);
                head = flipImage(head, 180);
            }
            array[0] = head;
            array[1] = Facetest256;
         } 
         catch (IOException e) {
         }
      
    }
    
    /**
     * Enlarges an {@link java.awt.Image} using the factor n
     * @param image the {@link java.awt.Image} to enlarge
     * @param n the factor to enlarge the {@link java.awt.Image}
     * @return The enlarged {@link java.awt.Image} 
     */
    public static BufferedImage enlarge(BufferedImage image, int n) {
        int w = n * image.getWidth();
        int h = n * image.getHeight();
        
        BufferedImage enlargedImage = new BufferedImage(w, h, image.getType());
        
        for (int y=0; y < h; ++y)
            for (int x=0; x < w; ++x)
                enlargedImage.setRGB(x, y, image.getRGB(x/n, y/n));
        
        return enlargedImage;
    }
    /**
     * Crops an {@link java.awt.Image} using a {@link java.awt.Rectangle}
     * @param src the {@link java.awt.Image} to crop
     * @param rect the {@link java.awt.Rectangle} to crop the {@link java.awt.Image}
     * @return The cropped {@link java.awt.Image}
     */
    
    private BufferedImage cropImage(BufferedImage src, Rectangle rect) {
        BufferedImage dest = src.getSubimage(8, 8, 8, 8);
        return dest; 
    }
    
    /**
     * Rotates an {@link java.awt.Image} using by deg's degrees
     * @param src the {@link java.awt.Image} to rotate
     * @param deg the number of degrees to rotate the {@link java.awt.Image} 
     * @return The rotated {@link java.awt.Image}
     */
    private BufferedImage flipImage(BufferedImage src, int deg){
        // The required drawing location
        int drawLocationX = 300;
        int drawLocationY = 300;
        // Rotation information
        double rotationRequired = Math.toRadians(deg);
        double locationX = src.getWidth() / 2;
        double locationY = src.getHeight() / 2;
        AffineTransform tx = AffineTransform.getRotateInstance(rotationRequired, locationX, locationY);
        AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
        src = op.filter(src, null);
        return src;    
    }
}