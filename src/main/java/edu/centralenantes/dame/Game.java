/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package edu.centralenantes.dame;

import java.io.IOException;

/**
 *
 * @author inky19
 */
public class Game {

    public static void main(String[] args) throws IOException {
        Board b = SaveManager.load();
        b.plateau[3][9] = null;
        while(true){
            b.nextTurn();
        }
        
        
        
    }
}
