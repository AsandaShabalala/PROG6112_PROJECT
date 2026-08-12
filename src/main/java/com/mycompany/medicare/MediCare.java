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
        
    }
    
    private static void Menu() {
    System.out.println("===== HOSPITAL WARD MANAGEMENT =====");
    System.out.println("1. Register new patient");
    System.out.println("2. Search patient by ID");
    System.out.println("3. Update patient details");
    System.out.println("4. Delete patient");
    System.out.println("5. Display all patients");
    System.out.println("0. Exit");
    }
    
    private static void registerPatient() {
        
    
        System.out.print("First name: ");
        String firstName = scanner.nextLine();
        
        System.out.print("Last name: ");
        String lastName = scanner.nextLine();
        
        System.out.print("Last Gender: ");
        String gender = scanner.nextLine();
        
        System.out.print("Patient ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        
        System.out.println("Enter Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        
        System.out.print("Medical condition: ");
        String condition = scanner.nextLine();

        System.out.print("Category (1=Inpatient, 2=Outpatient, 3=Emergency): ");
        int category = scanner.nextInt();
        
        
        Patient patient;
        switch (category){
            case 1 -> patient = new Inpatient(firstName, lastName, id, age, gender, condition, "Inpatient");
            case 2 -> patient = new Outpatient(firstName, lastName, id, age, gender,condition, "Outpatient");
            case 3 -> patient = new Emergency(firstName, lastName, id, age, gender, condition, "Emergency");
            
            default -> {
                System.out.println("Invalid category. Registration cancelled.");
                return;
            }   
        }
    }
}
