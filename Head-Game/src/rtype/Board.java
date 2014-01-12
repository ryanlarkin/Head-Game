package rtype;


import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import static rtype.Craft.x;

/**
 *
 * @author eandr127
 */
public class Board extends JPanel implements ActionListener {
    
    private Timer timer;
    private Craft craft;
    private ArrayList aliens;
    private boolean ingame;
    private int B_WIDTH;
    private int B_HEIGHT;

    private int[][] pos = { 
        {2380, 29}, {2500, 59}, {1380, 89},
        {780, 109}, {580, 139}, {680, 239}, 
        {790, 259}, {760, 50}, {790, 150},
        {980, 209}, {560, 45}, {510, 70},
        {930, 159}, {590, 80}, {530, 60},
        {940, 59}, {990, 30}, {920, 200},
        {900, 259}, {660, 50}, {540, 90},
        {810, 220}, {860, 20}, {740, 180},
        {820, 128}, {490, 170}, {700, 30}
     };

    public Board() throws MalformedURLException {

        addKeyListener(new TAdapter());
        setFocusable(true);
        setBackground(Color.BLACK);
        setDoubleBuffered(true);
        ingame = true;

        

        craft = new Craft();

        initAliens();

        timer = new Timer(5, this);
        timer.start();
    }

    public boolean getInGame(){
        return ingame;
    }
    
    public void addNotify() {
        super.addNotify();
        B_WIDTH = getWidth();
        B_HEIGHT = getHeight();   
    }

    public void initAliens() throws MalformedURLException {
        aliens = new ArrayList();

        for (int i=0; i<pos.length - 15; i++ ) {
            aliens.add(new Alien(pos[i][0], pos[i][1]));
        }
    }
    String user = Launcher.getUser();
    getImage getImage = new getImage(new URL("http://skins.minecraft.net/MinecraftSkins/"+user+".png"));

    public void paint(Graphics g) {
        super.paint(g);

        if (ingame) {
            Graphics2D g2d = (Graphics2D)g;
            if (craft.isVisible())
                g2d.drawImage(getImage.craft, craft.getX(), craft.getY(), this);
                g2d.drawImage(getImage.craft, craft.getX(), craft.getY(), this);
                for (int i = 0; i < aliens.size(); i++) {
                    Alien a = (Alien)aliens.get(i);
                    if (a.isVisible())
                        g2d.drawImage(a.getImage(), a.getX(), a.getY(), this);
                }
            g2d.setColor(Color.WHITE);
            g2d.drawString("Mobs left: " + aliens.size(), 5, 15);
        } 
        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }

    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < aliens.size(); i++) {
            Alien a = (Alien) aliens.get(i);
            if (a.isVisible()) 
                a.move();
            else aliens.remove(i);
        }
        
        try {
            craft.move();
        } catch (MalformedURLException ex) {
            Logger.getLogger(Board.class.getName()).log(Level.SEVERE, null, ex);
        } catch (LineUnavailableException ex) {
            Logger.getLogger(Board.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(Board.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Board.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            checkCollisions();
        } catch (MalformedURLException ex) {
            Logger.getLogger(Board.class.getName()).log(Level.SEVERE, null, ex);
        } catch (LineUnavailableException ex) {
            Logger.getLogger(Board.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(Board.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Board.class.getName()).log(Level.SEVERE, null, ex);
        }
        repaint();  
    }

    public void checkCollisions() throws MalformedURLException, LineUnavailableException, UnsupportedAudioFileException, IOException {
        Rectangle r3 = craft.getBounds();
        
        for (int j = 0; j<aliens.size(); j++) {
            Alien a = (Alien) aliens.get(j);
            Rectangle r2 = a.getBounds();
            
            if (r3.intersects(r2)) {
                
                craft.x = (int) (craft.maxX/2);
                craft.y = (int) (craft.maxY/2);
                
                a.setVisible(false);
                
                Random rand = new Random(); 
                int value = rand.nextInt(4);
                
                switch (value) {
                    case 0:  craft.play("explode1.wav");
                        break;
                    case 1:  craft.play("explode2.wav");
                        break;
                    case 2:  craft.play("explode3.wav");
                        break;
                    case 3:  craft.play("explode4.wav");
                        break;
                }
            }
        }
    }


    private class TAdapter extends KeyAdapter {

        public void keyReleased(KeyEvent e) {
            craft.keyReleased(e);
        }

        public void keyPressed(KeyEvent e) {
            craft.keyPressed(e);
        }
    }
}