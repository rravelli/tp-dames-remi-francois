package edu.centralenantes.dame;

/**
 *
 * @author inky19
 */
public class Pion {
    
    private Point pos;
    private int player;
    
    public Pion(){
        pos = new Point();
    }
    
    public Pion(int x, int y, int player) {
        pos = new Point(x, y);
        this.player = player; 
    }
    
    public void setPos(int x, int y){
        pos.setX(x);
        pos.setY(y);
    }
    
    public Point getPos(){
        return pos;
    }
    
    public int getPlayer() {
        return player;
    }
}
