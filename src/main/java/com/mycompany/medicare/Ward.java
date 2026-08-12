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
    Patient[][] outPatients;
    Patient[][] Emergency;
    Patient[][] Patients;

    public Ward() {
        
        beds = new Patient[row][column];
        outPatients = new Patient[row][column];
        Emergency = new Patient[row][column];
        Patients = new Patient[row][column];
    }
    
    public boolean register(Patient patient){
        
        for(int i =0; i< Patients.length; i++){
            for(int y =0; y< Patients[i].length; y++){
                
                if(Patients[i][y] == null){
                    Patients[i][y] = patient;
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean search(int Id){
        
        for(int i =0; i < Patients.length; i++){
            for(int y=0; y<Patients[i].length; y++){
                
                if(Patients[i][y] != null && Id == Patients[i][y].getPatientId()){
                    
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean removePatient(int Id){
        
        for(int i=0; i <Patients.length; i++){
            for(int y=0; y< Patients[i].length; y++){
                if(Patients[i][y] != null && beds[i][y].getPatientId() == Id){
                    
                    Patients[i][y] = null;
                    beds[i][y] = null;
                    return true;
                }
            }
        }
        return false;
    }
    
    public void displayPatients(){
        
        for(int i =0; i< Patients.length; i++){
            for(int y =0; y< Patients[i].length; y++){
                
                if (Patients[i][y] != null){
                    System.out.println("Name              : " + Patients[i][y].getFirstName() );
                    System.out.println("Last Name         : " + Patients[i][y].getLastName() );
                    System.out.println("Gender            : " + Patients[i][y].getGender() );
                    System.out.println("Age               : " + Patients[i][y].getAge() );
                    System.out.println("Medical Condition : " + Patients[i][y].getMedicalCondition() );
                    System.out.println("Category          : " + Patients[i][y].getCategory() );
                }
            }
        }        
    }
    
    public void updatePatient(Patient patient, int patientId){
        
        for(int i =0; i< Patients.length; i++){
            for(int y =0; y< Patients[i].length; y++){
                
                if(Patients[i][y] != null && patientId == Patients[i][y].getPatientId()){
                    
                    Patients[i][y] = patient;
                    return;
                }  
            
                
            }
        }
                
    }
}
