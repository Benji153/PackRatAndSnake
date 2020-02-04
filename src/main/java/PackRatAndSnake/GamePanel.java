/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PackRatAndSnake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
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
    PackRat player;
    ArrayList<Pellet> pellets = new ArrayList();
    Random random = new Random();
    int pTimer = 0;
    int pTime = 100;
    int score = 0;
    
    public GamePanel(){
        game = new Thread(this);
        game.start();
        player = new PackRat(0,0,20,20);
        this.setFocusable(true);
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                
            }

            @Override
            public void keyPressed(KeyEvent e) {
                int id = e.getKeyCode();
                if(id == (KeyEvent.VK_W)){
                    player.currentDirection=1;
                }else if(id == (KeyEvent.VK_D)){
                    player.currentDirection=2;
                }else if(id == (KeyEvent.VK_S)){
                    player.currentDirection=3;
                }else if(id == (KeyEvent.VK_A)){
                    player.currentDirection=4;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                
            }
        });
    }

    @Override
    public void run() {
        while(gameRunning){
            
            try {
                Thread.sleep(1000/60);
                repaint();
                update();
            } catch (InterruptedException ex) {
                Logger.getLogger(GamePanel.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
    
    @Override
    public void paintComponent(Graphics g){
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        draw(g);
        g.setColor(Color.white);
        g.drawString("Current Score: " + score, 15, 15);
    }
    
    public void draw(Graphics g){
        player.draw(g);
        pellets.forEach((p) -> {
            p.draw(g);
        });
    }
    
    public void update(){
        player.update();
        pellets.forEach((p) -> {
            p.update();
        });
        //check if a new pellet should be added to screen
        if(pTimer<pTime){
            pTimer++;
        }else{
            pTimer=0;
            addPellet();
        }
        
        //check if player has collided with a pellet
        for(int i = 0;i<pellets.size();i++){
            if(player.bounds.intersects(pellets.get(i).bounds)){
              score++;
              pellets.remove(i);
              i--;
          }  
        }
    }
    
    public void addPellet(){
        Pellet p = new Pellet(random.nextInt(this.getWidth()-20)+20,random.nextInt(this.getWidth()-20)+20,10,10);
        pellets.add(p);
    }
    
}
