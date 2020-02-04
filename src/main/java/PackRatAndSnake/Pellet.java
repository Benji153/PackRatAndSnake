
package PackRatAndSnake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;


public class Pellet {
    
    public Rectangle bounds;
    Color color = Color.yellow;
    
    public Pellet(int x,int y,int width,int height){
        this.bounds = new Rectangle(x,y,width,height);
    }
    
    public void draw(Graphics g){
        g.setColor(color);
        g.fillOval(bounds.x, bounds.y, bounds.width, bounds.height);
    }
    
    public void update(){
        
    }
    
}
