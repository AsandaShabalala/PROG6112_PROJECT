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
    
    private int row = 10;
    private int column = 10;
    
    Inpatient[][] beds;
    Patient[][] Patients;

    public Ward() {
        
        beds = new Inpatient[4][5];
        Patients = new Patient[row][column];
    }
    //method to register patients
    public boolean register(Patient patient){
        
        for(int i =0; i< Patients.length; i++){
            for(int y =0; y< Patients[i].length; y++){
                
                if(Patients[i][y] == null){
                    Patients[i][y] = patient;
                    
                    //using a nested if to allocate beds to inpateints
                    if(patient instanceof Inpatient){
                        allocateBed((Inpatient) patient);
                    }
                    return true;
                }
            }
        }
        return false;
    }
    
    //method to add patients
    public boolean addPatient(Patient patient){
        
        for(int i =0; i < Patients.length; i++){
            for(int y=0; y<Patients[i].length; y++){
                
                if(Patients[i][y] != null){
                    
                    Patients[i][y] = patient;
                    return true;
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
    //It also realeses a bed if when the patient is removed
    public boolean removePatient(int Id){
        
        for(int i=0; i <Patients.length; i++){
            for(int y=0; y< Patients[i].length; y++){
                if(Patients[i][y] != null && Patients[i][y].getPatientId() == Id){
                    
                    Patients[i][y] = null;
                    
                    //now searching the beds array to release Bed if the patient is discharged
                    for (int x = 0; x < beds.length; x++) {
                        for (int z = 0; z < beds[x].length; z++) {

                            if (beds[x][z] != null &&
                                beds[x][z].getPatientId() == Id) {

                                beds[x][z] = null;
                            }
                        }
                    }
                    return true;
                }
            }
        }  
        return false;
    }
    
    //method to display all registered patients
    public void displayPatients(){
        
        for(int i =0; i< Patients.length; i++){
            for(int y =0; y< Patients[i].length; y++){
                
            if (Patients[i][y] != null){
                Patients[i][y].displayDetails();
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
    
    //method to allocate availabe beds to inpatients returns false if not beds are available 
    public boolean allocateBed(Inpatient patient) {

        for (int i = 0; i < beds.length; i++) {
            for (int y = 0; y < beds[i].length; y++) {

                if (beds[i][y] == null) {
                    beds[i][y] = patient;
                    return true;
                }
            }
        }
        return false;
    }
    
    //method to display the ward layout
    public void wardLayout(){
        
        System.out.println("*****************WARD LAYOUT***************(E = empty, O = Occupied)");
        for(int i= 0;i < beds.length; i++ ){
            for(int y=0; y< beds[i].length; y++ ){
                
                if(beds[i][y] == null){
                    
                    System.out.print("[Bed:"+i+y+ " E]\t");
                }
                else{
                    System.out.print("Bed:"+i+y+ " O]\t");
                }
            }
            System.out.println();
        }
    }
    
    //method to display Occupied Beds
    public void displayOccupiedBeds(){
        
        System.out.println("Occupied Beds");
        for(int i= 0;i < beds.length; i++ ){
            for(int y=0; y< beds[i].length; y++ ){
                
                if(beds[i][y] == null){
                    
                    System.out.print("bed: " +i+y +" is occupied\t");
                }
            }
            System.out.println();
        }
    }
    
    public void totals(){
        
       int wardTotal =20; 
       int totalPatients =0;
       int totalBedsOccupied =0;
       double wardOccupancy;
       
        for(int i= 0;i < Patients.length; i++ ){
            for(int y=0; y< Patients[i].length; y++ ){
               
                if(Patients[i][y] != null){
                    
                    totalPatients++;
                }
            }
        }       
        //finding the total number of occupied beds
        for (int x = 0; x < beds.length; x++) {
            for (int z = 0; z < beds[x].length; z++) {

                if (beds[x][z] != null){

                    totalBedsOccupied++;
                }
            }
        }
        wardOccupancy = (totalPatients/ wardTotal) * 100;
        
        System.out.println("***********WARD REPORT**************");
        System.out.println("Registered Patients : " + totalPatients);
        System.out.println("Occupied Beds       : " + totalBedsOccupied);
        System.out.println("Bed Bccupancy       : " + wardOccupancy);
        
    }
    
    
}
