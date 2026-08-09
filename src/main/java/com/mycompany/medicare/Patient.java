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
    private String category;

    public Patient(String firstName, String lastName, int patientId, int age, String gender, String medicalCondition, String category) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.patientId = patientId;
        this.age = age;
        this.gender = gender;
        this.medicalCondition = medicalCondition;
        this.category = category;
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

    public String getCategory() {
        return category;
    }
    
    
}
