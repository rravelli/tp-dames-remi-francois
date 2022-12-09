package edu.centralenantes.dame;

/**
 *
 * @author inky19
 */
public class Pion {
    
    private Point pos;
    
    public Pion(){
        pos = new Point();
    }
    
    public void setPos(int x, int y){
        pos.setX(x);
        pos.setY(y);
    }
    
    public Point getPos(){
        return pos;
    }
}
