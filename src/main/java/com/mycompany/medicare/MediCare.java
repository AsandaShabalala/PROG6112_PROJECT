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
        
        do{
            Menu();
            choice = scanner.nextInt();
            scanner.nextLine();
            
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
                

                default -> {
                    System.out.println("Invalid option Selected please choose a vaild Option");
                }
            }
        }while (choice != 0);
        
        System.out.println("GOODBYE");
    }
    
    

    private static void Menu() {
        
        System.out.println();
        System.out.println("******** WELCOME TO MEDICARE *********");
        System.out.println("****** HOSPITAL WARD MANAGEMENT ******");    
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
    
    private static void searchPatient(){
        System.out.println("Enter the Patient Id of the patient you are looking for");
        int id = scanner.nextInt();
        scanner.nextLine();
        
        Patient patient = ward.search(id);
        
        if(patient != null){
            
            System.out.println("\t Patient Found");
            patient.displayDetails();
            //System.out.println("PATIENT FOUND");
            //System.out.println("Name              : " + patient.getFirstName());
           // System.out.println("Last Name         : " + patient.getLastName());
          //  System.out.println("Medical condition : " + patient.getMedicalCondition());
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
            
            System.out.println("\tEnter the details for Patient " + (i+1));
    
            System.out.print("First name: ");
            String firstName = scanner.nextLine();

            System.out.print("Last name: ");
            String lastName = scanner.nextLine();

            System.out.print("Gender: ");
            String gender = scanner.nextLine();

            System.out.print("Patient ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Enter Age: ");
            int age = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Medical condition: ");
            String condition = scanner.nextLine();

            System.out.print("Category (1=Inpatient, 2=Outpatient, 3=Emergency): ");
            int category = scanner.nextInt();
            scanner.nextLine();


            Patient patient;

            switch (category) {
                case 1 -> patient = new Inpatient(firstName, lastName, id, age, gender, condition);
                        
                case 2 -> patient = new Patient(firstName, lastName, id, age, gender, condition, patientCategory.OUTPATIENT);

                case 3 -> patient = new Patient(firstName, lastName, id, age, gender, condition, patientCategory.EMERGENCY);

                default -> {
                    System.out.println("Invalid category.");
                    return;
                }

            }
            if(ward.addPatient(patient)){
                System.out.println("PATIENT SUCCESSFULLY REGISTERED");
                
                if(patient instanceof Inpatient){
                    
                    ward.allocateBed((Inpatient) patient);
                }
            }
            else{
                System.out.println("Registration failed");
            }
        }
    }
    
    private static void deletePatient(){
        System.out.println("Enter the the Id of the patient you want to delete: ");
        int Id = scanner.nextInt();
        
        if(ward.search(Id) != null){
            ward.removePatient(Id);
            System.out.println("Patient succesfully removed from the System");
        }
        else{
            System.out.println("Patient with that Id not found");
        }
    }
    
    private static void updatePatientDetails(){
        
        System.out.println("Enter the the Id of the patient you want to delete: ");
        int Id;
        
        if (scanner.hasNextInt()) {
            Id = scanner.nextInt();
            scanner.nextLine();
        } else {
            System.out.println("Please enter a valid number.");
            scanner.nextLine();
            return;
        }
        
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