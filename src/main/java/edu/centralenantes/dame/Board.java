/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.centralenantes.dame;

import java.util.Scanner;

/**
 *
 * @author remir
 */
public class Board {
    public Pion[][] plateau;
    public int turn;
    public Scanner s;
    
    public Board() {
        plateau = new Pion[10][10];
        for (int y=0; y < 4; y++) {
            for (int x=0; x < 10; x++) {
                if ((x + y) % 2 == 0) {
                    plateau[x][y] = new Pion(x,y,0,plateau);
                }
            }
        }
        for (int y=9; 6 <= y; y--) {
            for (int x=0; x < 10; x++) {
                if ((x + y) % 2 == 0) {
                    plateau[x][y] = new Pion(x,y,1,plateau);
                }
            }
        }
        turn = 0;
        
    }
    
    public void nextTurn() {
        System.out.println(this);
        System.out.println("C'est au tour du joueur "+turn);
        Point pos = null;
        s = new Scanner(System.in);
        while (pos == null) {
            System.out.println("Sélectionner un pion de la fome : x[ESPACE]y ");
            String posString = s.nextLine();
            try {
                String[] positions = posString.split(" ");
                pos = new Point(Integer.parseInt(positions[0]),Integer.parseInt(positions[1]));
            } catch (NumberFormatException e) {}
            if (pos != null ) {
                if (plateau[pos.getX()][pos.getY()] == null || plateau[pos.getX()][pos.getY()].getPlayer() != turn) {
                    pos=null;
                }
            }  
        }

        System.out.println("Pion "+pos+" sélectionné\n");
        Pion pion = plateau[pos.getX()][pos.getY()];
        
        
        
        pos = null;
        while (pos == null) {
            System.out.println("Choisir direction, gauche [g] ou droite [d]");
            String posString = s.nextLine();
            if (posString.equals("g")) {
                pos = new Point(-1,1 - pion.getPlayer()*2);
            } else if (posString.equals("d")) {
                pos = new Point(1,1 - pion.getPlayer()*2);
            }
            if (pion != null && !pion.move(pos)) {
                pos = null;
            }
        }
        
        
        turn = 1 - turn;
    }
    
    
    
    @Override
    public String toString() {
        String s = "  |";
        for (int i=0; i < 10; i++) {
            s+= i + "  ";
        }
        s+= "\n--";
        for (int i=0; i < 10; i++) {
            s+= "---";
        }
        s+= "\n";
        for (int y=0; y < 10; y++) {
            s+= y + " |";
            for (int x=0; x < 10; x++) {
                
                if (plateau[x][y] != null) {
                    if (plateau[x][y] instanceof Dame) {
                        s += "D" + plateau[x][y].getPlayer() + " ";
                    } else {
                        s += "P" + plateau[x][y].getPlayer() + " ";
                    }
                    
                } else {
                    s += "-- ";
                }
            }
            s += "\n";
        }
        return s;
    }
    
    public Pion[][] getPlateau() {
        return plateau;
    }

    public int getTurn() {
        return turn;
    }

    public void setPlateau(Pion[][] plateau) {
        this.plateau = plateau;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }
    
    
    
}
