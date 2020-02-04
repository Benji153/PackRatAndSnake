/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PackRatAndSnake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

/**
 *
 * @author benji
 */
public class Snake {

    Color color = Color.green;
    ArrayList<Rectangle> cells = new ArrayList();
    int currentDirection = 0;
    int speed = 12;
    boolean addC = false;
    int cSize = 0;
    int moveTimer = 0;
    int moveTime = 8;
    

    public Snake(int x, int y, int cSize) {
        cells.add(new Rectangle(x, y, cSize + 5, cSize + 5));
        this.cSize = cSize;
    }

    public void draw(Graphics g) {
        g.setColor(color);
        cells.forEach((c) -> {
            g.fillOval(c.x, c.y, c.width, c.height);
        });
    }
    
    public void addCell(){
        addC = true;
    }

    public void update() {
        if(moveTimer>=moveTime){
        if(addC){
            Rectangle t = cells.get(cells.size()-1);
            cells.add(new Rectangle(t.x,t.y,cSize,cSize));
            addC = false;
        }
        if (currentDirection != 0) {
            for (int i = cells.size()-1; i > 0; i--) {
                cells.get(i).x = cells.get(i - 1).x;
                cells.get(i).y = cells.get(i - 1).y;
            }
        }
        switch (currentDirection) {
            case 0:
                break;
            case 1:
                cells.get(0).y -= speed;
                break;
            case 2:
                cells.get(0).x += speed;
                break;
            case 3:
                cells.get(0).y += speed;
                break;
            case 4:
                cells.get(0).x -= speed;
                break;
            default:
                this.currentDirection = 0;
                break;
        }
        moveTimer=0;
        }else{
            moveTimer++;
        }
    }

}
