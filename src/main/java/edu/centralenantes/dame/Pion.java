package edu.centralenantes.dame;

import java.util.LinkedList;


/**
 *
 * @author inky19
 */
public class Pion {
    
    private Point pos;
    private int player;
    private Pion[][] plateau;
    
    public Pion(){
        pos = new Point();
    }
    
    public Pion(int x, int y, int player, Pion[][] plateau) {
        pos = new Point(x, y);
        this.player = player; 
        this.plateau = plateau;
    }
    
    /**
     * Déplace le pion dans la grille et supprime les pions ennemis sur le chemin.
     * @param dep Direction de déplacement
     * @return Si le déplacement est un succès.
     */
    public boolean move(Point dep){
        Point newPos = new Point(pos.getX() + dep.getX(), pos.getY() + dep.getY());
        LinkedList<Pion> toRemove = new LinkedList<>(); // Pions à supprimer
        if (newPos.isValid()){
            System.out.println("Le point est valide");
            while (newPos.isValid() && plateau[newPos.getX()][newPos.getY()] != null){
                if (plateau[newPos.getX()][newPos.getY()].getPlayer() != player){
                    toRemove.add(plateau[newPos.getX()][newPos.getY()]);
                    newPos.setX(newPos.getX()+dep.getX());
                    newPos.setY(newPos.getY()+dep.getY());
                } else {
                    return false;
                }
            }
            // Suppression des pions ennemis
            for (Pion p: toRemove){
                p.remove();
            }
            plateau[pos.getX()][pos.getY()] = null;
            pos = newPos;
            
            if (newPos.getY() == (9-player*9)){
                plateau[pos.getX()][pos.getY()] = new Dame(pos.getX(), pos.getY(), player, plateau);
            } else {
                plateau[pos.getX()][pos.getY()] = this;
            }
            return true;
                
            }
        return false;
        }
       
    /**
     * Supprime le pion du plateau.
     */
    public void remove(){
        plateau[pos.getX()][pos.getY()] = null;
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
