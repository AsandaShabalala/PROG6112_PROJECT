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
    
    private int wardNumber;
    private int bedNumber;
    
    public Inpatient(String firstName, String lastName, int patientId, int age, String gender, String medicalCondition) {
        super(firstName, lastName, patientId, age, gender, medicalCondition, patientCategory.INPATIENT);
    }

    public int getWardNumber() {
        return wardNumber;
    }

    public int getBedNumber() {
        return bedNumber;
    }

    public void setWardNumber(int wardNumber) {
        this.wardNumber = wardNumber;
    }

    public void setBedNumber(int bedNumber) {
        this.bedNumber = bedNumber;
    }
    

}
