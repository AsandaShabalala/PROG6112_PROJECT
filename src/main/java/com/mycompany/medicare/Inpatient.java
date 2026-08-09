/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.medicare;

/**
 *
 * @author Student
 */
public class Inpatient extends Patient {
    
    public Inpatient(String firstName, String lastName, int patientId, int age, String gender, String medicalCondition, String category) {
        super(firstName, lastName, patientId, age, gender, medicalCondition, category);
    }
    
    @Override
    public String getCategory() {
        return "In patient";
    }
}
