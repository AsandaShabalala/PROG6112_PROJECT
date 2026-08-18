/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.medicare;

import java.util.Scanner;

/**
 *
 * @author Student
 */


public class MediCare {
    
    private static Ward ward = new Ward();
    static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        int choice;
       
        System.out.println("******** WELCOME TO MEDICARE *********");
        System.out.println("****** HOSPITAL WARD MANAGEMENT ******");
        
        do{
            Menu();
            
            if (scanner.hasNextInt()) {     //checks if the user entered a number or not
                choice = scanner.nextInt();
                scanner.nextLine();
            
            } else {
                System.out.println("Please enter a valid number.");
                scanner.nextLine();
            return;
        }
            System.out.println();
            switch(choice){

                case 1 -> registerPatient();
                case 2 -> searchPatient();
                case 3 -> updatePatientDetails();
                case 4 -> deletePatient();
                case 5 -> ward.displayPatients();
                case 6 -> ward.displayEmptyBeds();
                case 7 -> ward.displayOccupiedBeds();
                case 8 -> ward.wardLayout();
                case 9 -> ward.totals();
                case 0 -> System.out.print("GOODBYE");

                default -> {
                    System.out.println("Invalid option Selected please choose a vaild Option");
                }
            }
        }while (choice != 0);
    }
       
    //method for the menu
    private static void Menu() {
         
        System.out.println();
        System.out.println("PLEASE SELECT AN OPTION FROM 0-9");
        System.out.println("1. Register new patient : ");
        System.out.println("2. Search patient by ID : ");
        System.out.println("3. Update patient details : ");
        System.out.println("4. Delete patient : ");
        System.out.println("5. Display all patients : ");
        System.out.println("6. Display available Beds : ");
        System.out.println("7. Display occupied Beds : ");
        System.out.println("8. Display Wardlayout : ");
        System.out.println("9. View total number of patients, occupied beds and ward occupancy : ");
        System.out.println("0. Exit");
 
   }
    
    //methods inthis main class are mainly for getting user input and then they call the methods 
    //from the ward object
    
    private static void searchPatient(){
        System.out.println("Enter the Patient Id of the patient you are looking for");
        String id = scanner.nextLine().toUpperCase();
        
        Patient patient = ward.search(id);
        
        if(patient != null){
            
            System.out.println("\t Patient Found");
            patient.displayDetails();
        }
        else{
            System.out.println("Not Patient with Id " + id+ " was found");
        }
        
    }
    
    private static void registerPatient() {
        
        System.out.print("How many patients would you like to register?: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        
        for(int i = 0; i < choice; i++){
            
            System.out.println();
            System.out.println("\tEnter the details for Patient " + (i+1));
    
            System.out.print("First name: ");
            String firstName = scanner.nextLine();

            System.out.print("Last name: ");
            String lastName = scanner.nextLine();

            System.out.print("Gender: ");
            String gender = scanner.nextLine();


            String id;
            do{
                System.out.print("Patient ID: ");
                id = scanner.nextLine().toUpperCase();
                
                if(ward.search(id)!= null){
  
                    System.out.println("PATIENT with this ID already exist choose another ID");
                    id = null;
              }
            }while(id == null);
            
            int age;
            do{
                System.out.print("Enter Age: ");

                if(scanner.hasNextInt()){
                    age = scanner.nextInt();
                    scanner.nextLine();
                }else{
                    System.out.println("Please enter a number");
                    scanner.nextLine();
                    age = -1;
                }
            }while(age < 0);
            
            System.out.print("Medical condition: ");
            String condition = scanner.nextLine();

            System.out.print("Category (1=Inpatient, 2=Outpatient, 3=Emergency): ");
            int category = scanner.nextInt();
            scanner.nextLine();

            Patient patient;
            
            //if patient is an inpatient they get sent to the inpatient class then the super() will pass them onto the Patient class 
            switch (category) {
                case 1 -> patient = new Inpatient(firstName, lastName, id, age, gender, condition);
                        
                case 2 -> patient = new Patient(firstName, lastName, id, age, gender, condition, patientCategory.OUTPATIENT);

                case 3 -> patient = new Patient(firstName, lastName, id, age, gender, condition, patientCategory.EMERGENCY);

                default -> {
                    System.out.println("Invalid category.");
                    return;
                }

            }
            //adds the patient into the Patients arraay and allocates them a bed if they are an Inpatient
            if(ward.addPatient(patient)){
                System.out.println("PATIENT SUCCESSFULLY REGISTERED");
                
                if(patient instanceof Inpatient){
                    
                    if(ward.allocateBed((Inpatient) patient)){
                        System.out.println("Bed has also has been allocated to the patient");
                    }else{
                        System.out.println("BEDS ARE FULL");
                    }
                }
            }
            else{
                System.out.println("Patient Registration failed");
            }
        }
    }
    
    private static void deletePatient(){
        System.out.println("Enter the the Id of the patient you want to delete: ");
        String Id = scanner.nextLine().toUpperCase();
        
        if(ward.search(Id) != null){
            ward.removePatient(Id);
            System.out.println("Patient succesfully removed from the System");
        }
        else{
            System.out.println("Patient with that Id not found");
        }
    }
    
    private static void updatePatientDetails(){
        
        System.out.println("Enter the the Id of the patient you want to Update: ");
        String Id = scanner.nextLine().toUpperCase();
        
        Patient patient = ward.search(Id);
        if(patient != null){
        
            System.out.println("Enter the new details of patient : "+ Id );
            System.out.print("First name: ");
            String firstName = scanner.nextLine();
            patient.setFirstName(firstName);

            System.out.print("Last name: ");
            String lastName = scanner.nextLine();
            patient.setLastName(lastName);

            System.out.print("Gender: ");
            String gender = scanner.nextLine();
            patient.setGender(gender);

            System.out.print("Enter Age: ");
            int age = scanner.nextInt();
            scanner.nextLine();
            patient.setAge(age);

            System.out.print("Medical condition: ");
            String condition = scanner.nextLine();
            patient.setMedicalCondition(condition);

            System.out.print("Category (1=Inpatient, 2=Outpatient, 3=Emergency): ");
            int category = scanner.nextInt();
            
            switch(category){
                
                case 1 -> patient.setCategory(patientCategory.INPATIENT);
                case 2 -> patient.setCategory(patientCategory.OUTPATIENT);
                case 3 -> patient.setCategory(patientCategory.EMERGENCY);
                
                default -> {
                    System.out.println("Inavalid category selected please try Updating patient info again");   
                    return;
                }
            }

        
            ward.updatePatient(patient, Id);
        }
        else{
            System.out.println("Patient Not found");
        }
        
    }
}