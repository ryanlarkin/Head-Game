package rtype;

import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;

/**
 *
 * @author eandr127
 */
public class getImage {
     private BufferedImage img;
     BufferedImage craft;
     BufferedImage Facetest256;
     Rectangle rect = new Rectangle(8, 16);

    public getImage(URL url){
        BufferedImage[] array = new BufferedImage[2];
        try {
            img = ImageIO.read(url);
            img =cropImage(img, rect);
            Facetest256 = enlarge(img, 32);
            craft = enlarge(img, 2);
            img = enlarge(img, 2);
            if(url.equals("http://skins.minecraft.net/MinecraftSkins/Dinnerbone.png") || url.equals("http://skins.minecraft.net/MinecraftSkins/Grumm.png")){
                img = flipImage(img,180);
                Facetest256 = flipImage(Facetest256,180);
                craft = flipImage(craft, 180);
            }
            array[0] = craft;
            array[1] = Facetest256;
         } 
         catch (IOException e) {
         }
      
    }
    
    public static BufferedImage enlarge(BufferedImage image, int n) {
        int w = n * image.getWidth();
        int h = n * image.getHeight();
        
        BufferedImage enlargedImage = new BufferedImage(w, h, image.getType());
        
        for (int y=0; y < h; ++y)
            for (int x=0; x < w; ++x)
                enlargedImage.setRGB(x, y, image.getRGB(x/n, y/n));
        
        return enlargedImage;
    }
    
    private BufferedImage cropImage(BufferedImage src, Rectangle rect) {
        BufferedImage dest = src.getSubimage(8, 8, 8, 8);
        return dest; 
    }
    
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