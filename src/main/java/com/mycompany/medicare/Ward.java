/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.medicare;

/**
 *
 * @author Student
 */
public class Ward {
    
    private int row = 4;
    private int column = 5;
    
    Patient[][] beds;

    public Ward() {
        
        beds = new Patient[row][column];
    }
    
    public boolean register(Patient patient){
        
        for(int i =0; i< beds.length; i++){
            for(int y =0; y< beds[i].length; y++){
                
                if(beds[i][y] == null){
                    beds[i][y] = patient;
                    return true;
                }
            }
        }
        return false;
    }
    
}
