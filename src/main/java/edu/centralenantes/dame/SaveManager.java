/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.centralenantes.dame;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;

/**
 *
 * @author inky19
 */
public abstract class SaveManager {
    public static final String SEP = ", ";
    
    public static void save(Board b) throws IOException{
        File file = chooseFile();
        BufferedWriter fileBuffer = new BufferedWriter(new FileWriter(file.getAbsolutePath()));
        fileBuffer.write("DAME 1.0");
        fileBuffer.newLine();
        fileBuffer.write("turn="+String.valueOf(b.getTurn()));
        fileBuffer.newLine();
        Pion[][] p = b.getPlateau();
        for (int i=0; i<p.length;i++){
            for (int j=0; j<p[0].length;j++){
                Pion pion = p[i][j];
                if (pion instanceof Pion){
                    fileBuffer.write("Pion" + SEP + String.valueOf(pion.getPos()) + SEP + String.valueOf(pion.getPlayer()));
                    fileBuffer.newLine();
                } else if (pion instanceof Dame){
                    fileBuffer.write("Dame" + SEP + String.valueOf(pion.getPos()) + SEP + String.valueOf(pion.getPlayer()));
                    fileBuffer.newLine();
                }
            }
        }
        fileBuffer.flush();
        fileBuffer.close();
    }
    
    public static Board load() throws FileNotFoundException, IOException{
        File file = chooseFile();
        BufferedReader reader = new BufferedReader(new FileReader(file));
        Board b = new Board();
        String line = reader.readLine();
        line = reader.readLine();
        b.setTurn(Integer.valueOf(line.substring(5, 6)));
        String data[];
        Pion[][] p = b.getPlateau();
        while (line != null){
            
            line = reader.readLine();
            data = line.split(SEP);
            switch (data[0]){
                case "Pion":
                    p[Integer.valueOf(data[1])][Integer.valueOf(data[2])] = new Pion(Integer.valueOf(data[1]), Integer.valueOf(data[2]), Integer.valueOf(data[3]));
                    break;
                case "Dame":
                    p[Integer.valueOf(data[1])][Integer.valueOf(data[2])] = new Dame(Integer.valueOf(data[1]), Integer.valueOf(data[2]), Integer.valueOf(data[3]));
                    break;
            }
            
        }
        return b;
    }
    
    private static File chooseFile(){
        JFileChooser fileExplorer = new JFileChooser();
        int res = fileExplorer.showOpenDialog(null);
        File file = null;
        if (res == JFileChooser.APPROVE_OPTION){
            file = fileExplorer.getSelectedFile();
        }
        return file;
    }
}
