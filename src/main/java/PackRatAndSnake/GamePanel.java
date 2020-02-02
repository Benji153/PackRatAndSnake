/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PackRatAndSnake;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author Danie
 */
public class GamePanel extends JPanel implements Runnable{
    
    boolean gameRunning = true;
    Thread game;
    Color setColor = Color.black;
    Random random = new Random();
    
    public GamePanel(){
        game = new Thread(this);
        game.start();
    }

    @Override
    public void run() {
        while(gameRunning){
            
            try {
                Thread.sleep(1000/6);
                repaint();
                update();
            } catch (InterruptedException ex) {
                Logger.getLogger(GamePanel.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
    
    @Override
    public void paintComponent(Graphics g){
        g.setColor(setColor);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
    }
    
    public void update(){
        setColor = new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255));
    }
    
}
