package headGame;


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
import static headGame.Head.x;

/**
 * The game's {@link JPanel}
 * @author eandr127
 * @author Jan Bodnar
 */
public class Board extends JPanel implements ActionListener {
    
    private Timer timer;
    private Head heads;
    private ArrayList enemyHeads;
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

    /**
     * Initialize the {@link Board}
     * @throws MalformedURLException if the users skin is null when calling {@link GetImage}
     */
    public Board() throws MalformedURLException {

        addKeyListener(new TAdapter());
        setFocusable(true);
        setBackground(Color.BLACK);
        setDoubleBuffered(true);
        ingame = true;

        

        heads = new Head();

        initEnemyHeads();

        timer = new Timer(5, this);
        timer.start();
    }

    /**
     * Gets weather it is in game or not
     * @return weather it is in game or not
     */
    public boolean getInGame(){
        return ingame;
    }
    
    /**
     * Initialize {@link EnemyHead}s
     * @throws MalformedURLException if the users skin is null when calling {@link GetImage} 
     */
    public void initEnemyHeads() throws MalformedURLException {
        enemyHeads = new ArrayList();

        for (int i=0; i<pos.length - 15; i++ ) {
            enemyHeads.add(new EnemyHead(pos[i][0], pos[i][1]));
        }
    }
    String user = Launcher.getUser();
    GetImage getImage = new GetImage(new URL("http://skins.minecraft.net/MinecraftSkins/"+user+".png"));

    /***
     * Paints the {@link Board}
     * @param g the {@link java.awt.Graphics} to draw with
     */
    public void paint(Graphics g) {
        super.paint(g);

        if (ingame) {
            Graphics2D g2d = (Graphics2D)g;
            if (heads.isVisible())
                g2d.drawImage(getImage.head, heads.getX(), heads.getY(), this);
                g2d.drawImage(getImage.head, heads.getX(), heads.getY(), this);
                for (int i = 0; i < enemyHeads.size(); i++) {
                    EnemyHead a = (EnemyHead)enemyHeads.get(i);
                    if (a.isVisible())
                        g2d.drawImage(a.getImage(), a.getX(), a.getY(), this);
                }
            g2d.setColor(Color.WHITE);
            g2d.drawString("Mobs left: " + enemyHeads.size(), 5, 15);
        } 
        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }
    
    /**
     * Update {@link Board}
     * @param e Actions between updates
     */
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < enemyHeads.size(); i++) {
            EnemyHead a = (EnemyHead) enemyHeads.get(i);
            if (a.isVisible()) 
                a.move();
            else enemyHeads.remove(i);
        }
        
        try {
            heads.move();
        } catch (MalformedURLException ex) {
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
        } catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(Board.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Board.class.getName()).log(Level.SEVERE, null, ex);
        }
        repaint();  
    }

    /**
     * Checks if the {@link Head} hit an {@link EnemyHead}
     * @throws MalformedURLException in case the {@link java.net.URL} does not exist
     * @throws UnsupportedAudioFileException in case the sound format of the {@link java.io.File} is unsupported
     * @throws IOException in case their is an error reading the {@link java.io.File}
     */
    public void checkCollisions() throws MalformedURLException, UnsupportedAudioFileException, IOException {
        Rectangle r3 = heads.getBounds();
        
        for (int j = 0; j<enemyHeads.size(); j++) {
            EnemyHead a = (EnemyHead) enemyHeads.get(j);
            Rectangle r2 = a.getBounds();
            
            if (r3.intersects(r2)) {
                
                heads.x = (int) (heads.maxX/2);
                heads.y = (int) (heads.maxY/2);
                
                a.setVisible(false);
                
                Random rand = new Random(); 
                int value = rand.nextInt(4);
                
                switch (value) {
                    case 0:  heads.play("explode1.wav");
                        break;
                    case 1:  heads.play("explode2.wav");
                        break;
                    case 2:  heads.play("explode3.wav");
                        break;
                    case 3:  heads.play("explode4.wav");
                        break;
                }
            }
        }
    }

    /**
     * Handles {@link java.awt.event.KeyEvent}s
     */
    private class TAdapter extends KeyAdapter {
        
        /**
         * Handle {@link java.awt.event.KeyEvent} pressed
         * @param e the {@link java.awt.event.KeyEvent} to handle
         */
        public void keyReleased(KeyEvent e) {
            heads.keyReleased(e);
        }

        /**
         * Handle {@link java.awt.event.KeyEvent} released
         * @param e the {@link java.awt.event.KeyEvent} to handle
         */
        public void keyPressed(KeyEvent e) {
            heads.keyPressed(e);
        }
    }
}