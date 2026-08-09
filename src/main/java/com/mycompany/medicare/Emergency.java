/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.medicare;

/**
 *
 * @author Student
 */
public class Emergency extends Patient {
    
    public Emergency(String firstName, String lastName, int patientId, int age, String gender, String medicalCondition, String category) {
        super(firstName, lastName, patientId, age, gender, medicalCondition, category);
    }
    
    @Override
    public String getCategory() {
        return "Emergency";
    }
}
