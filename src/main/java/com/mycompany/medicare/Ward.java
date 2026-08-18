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
        
        //4 rows and 5 coloumns since the beds are arranged in  4 by 5
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
                
                if(Patients[i][y] == null){                
                    Patients[i][y] = patient;
                    return true;
                }
            }
        }
        return false;
    }
    
    //method to search for patients
    public Patient search(String Id){
        
        for(int i =0; i < Patients.length; i++){
            for(int y=0; y<Patients[i].length; y++){
                
                if(Patients[i][y] != null && Id.equals(Patients[i][y].getPatientId())){
                    
                    return Patients[i][y];
                }
            }
        }
        return null;
    }
    
    //method to remove patients
    //It also realeses a bed if when the patient removed was an inpatient
    public boolean removePatient(String Id){
        
        for(int i=0; i <Patients.length; i++){
            for(int y=0; y< Patients[i].length; y++){
                if(Patients[i][y] != null && Patients[i][y].getPatientId().equals(Id)){
                    
                    Patients[i][y] = null;
                    
                    //now searching the beds array to release Bed if the patient is discharged
                    for (int x = 0; x < beds.length; x++) {
                        for (int z = 0; z < beds[x].length; z++) {

                            if (beds[x][z] != null &&
                                    beds[x][z].getPatientId().equals(Id)) {

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
        int z = 1;
        
        for (Patient[] Patient : Patients) {
            for (int y = 0; y < Patient.length; y++) {
                if (Patient[y] != null) {
                    System.out.println("\t Patient " +z);
                    Patient[y].displayDetails();
                    z++;
                    System.out.println();
                }
            }
        }        
    }
    
    //method to update patient details
    public void updatePatient(Patient patient, String patientId){
        
        for(int i =0; i< Patients.length; i++){
            for(int y =0; y< Patients[i].length; y++){
                
                if(Patients[i][y] != null && patientId.equals(Patients[i][y].getPatientId())){
                    
                    Patients[i][y] = patient;
                    System.out.println("DETAILS SUCCESSFULLY UPDATED");
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
                    
                    patient.setBedNumber(4);
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
                    
                    System.out.print("[Bed: "+i+":"+y+ " E]\t");
                }
                else{
                    System.out.print("[Bed:"+i+":"+y+ " O]\t");
                }
            }
            System.out.println();
        }
    }
    
    //method to display Occupied Beds
    public void displayOccupiedBeds(){
        
        int total = 0;
        
        System.out.println("Occupied Beds");
        for(int i= 0;i < beds.length; i++ ){
            for(int y=0; y< beds[i].length; y++ ){
                
                if(beds[i][y] != null){
                    
                    System.out.print("bed: " +i+":"+y +" is occupied\t");
                    total++;
                }
                
            }
            System.out.println();
        }  
        if(total <=0){
            System.out.println("There are no occupied beds");
        }
        else{
            System.out.println("Occupied beds : " + total);
        }
    }
    
    //method to display Occupied Beds
    public void displayEmptyBeds(){
        
        int total = 0;
        
        System.out.println("Empty Beds");
        for(int i= 0;i < beds.length; i++ ){
            for(int y=0; y< beds[i].length; y++ ){
                
                if(beds[i][y] == null){
                    
                    System.out.print("bed: " +i+":"+y +" is Available\t");
                    total++;
                }
                
            }
            System.out.println();
        }  
        if(total <=0){
            System.out.println("There are no Empty beds");
        }
        else{
            System.out.println("Empty beds : " + total);
        }
    }
    
    //prints out a report of beds occupied, ward occupancy % and total patients
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
        //casted it to a double since it kept on return 0
        wardOccupancy = ((double)totalBedsOccupied/ wardTotal) * 100;
        
        System.out.println("***********WARD REPORT**************");
        System.out.println("Registered Patients : " + totalPatients);
        System.out.println("Occupied Beds       : " + totalBedsOccupied);
        System.out.println("Ward Occupancy      : " + wardOccupancy+"%");
        
    }
    
    
}
