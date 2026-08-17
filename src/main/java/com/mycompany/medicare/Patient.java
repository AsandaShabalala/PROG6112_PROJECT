/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.medicare;

/**
 *
 * @author Student
 */
public class Patient {
    
    private String firstName;
    private String lastName;
    private int patientId;
    private int age;
    private String gender;
    private String medicalCondition;
    private patientCategory category;

    public Patient(String firstName, String lastName, int patientId, int age, String gender, String medicalCondition, patientCategory category) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.patientId = patientId;
        this.age = age;
        this.gender = gender;
        this.medicalCondition = medicalCondition;
        this.category = category;
    }
    
    public void displayDetails(){
        
        System.out.println("Name              : " + firstName );
        System.out.println("Last Name         : " + lastName);
        System.out.println("Gender            : " + gender);
        System.out.println("Age               : " + age);
        System.out.println("Medical Condition : " + medicalCondition);
        System.out.println("Category          : " + category);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getPatientId() {
        return patientId;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getMedicalCondition() {
        return medicalCondition;
    }

    public patientCategory getCategory() {
        return category;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setMedicalCondition(String medicalCondition) {
        this.medicalCondition = medicalCondition;
    }

    public void setCategory (patientCategory category) {
        this.category = category;
    }
    
    
}
