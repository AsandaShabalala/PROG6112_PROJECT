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
                    
                    //using a nested if to allocate beds to inpateints
                    if(patient.getCategory().equals("Inpatient")){
                        allocateBed(patient);
                    }
                }
            }
        }
        return false;
    }
    
    //method to search for patients
    public Patient search(int Id){
        
        for(int i =0; i < Patients.length; i++){
            for(int y=0; y<Patients[i].length; y++){
                
                if(Patients[i][y] != null && Id == Patients[i][y].getPatientId()){
                    
                    return Patients[i][y];
                }
            }
        }
        return null;
    }
    
    //method to remove patients
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
    
    //,ethod to display all registered patients
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
    
    //method to update patient details
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
    
    //method to allocate availabe beds to inpatients
    public void allocateBed(Patient patient) {

        for (int i = 0; i < beds.length; i++) {
            for (int y = 0; y < beds[i].length; y++) {

                if (beds[i][y] == null) {
                    beds[i][y] = patient;
                }
            }
        }
    }
}
