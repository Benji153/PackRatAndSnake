
package PackRatAndSnake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;


public class PackRat {
   
    public int speed = 2;
    public Rectangle bounds;
    public int currentDirection = 0;
    public int currentPellets = 0;
    
    
    public PackRat(int x,int y, int width ,int height){
        this.bounds = new Rectangle(x,y,width,height);
    }
    
    public void draw(Graphics g){
        g.setColor(new Color(150,75,0));
        g.fillRect(bounds.x, bounds.y, bounds.width, bounds.height);
    }
    
    public void update(){
        switch(currentDirection){
                case 0:
                    break;
                case 1:
                    this.bounds.y-=speed;
                    break;
                case 2:
                    this.bounds.x+=speed;
                    break;
                case 3:
                    this.bounds.y+=speed;
                    break;
                case 4:
                    this.bounds.x-=speed;
                    break;
                default:
                    this.currentDirection=0;
                    break;
        }
    }
    
}
