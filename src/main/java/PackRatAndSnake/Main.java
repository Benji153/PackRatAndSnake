/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PackRatAndSnake;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 *
 * @author Danie
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame gameWindow = new JFrame("Pack-Rat vs. Snake");
        gameWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        GamePanel game = new GamePanel();
        gameWindow.setSize(new Dimension(500,500));
        gameWindow.add(game,BorderLayout.CENTER);
        gameWindow.setVisible(true);
        
    }
    
}
