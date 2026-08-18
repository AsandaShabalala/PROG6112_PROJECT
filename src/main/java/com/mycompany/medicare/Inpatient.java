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
    
    private int wardNumber = 1;
    private int bedNumber = -1;  //setting to -1 since it does not have an actuall value
    
    public Inpatient(String firstName, String lastName, String patientId, int age, String gender, String medicalCondition) {
        super(firstName, lastName, patientId, age, gender, medicalCondition, patientCategory.INPATIENT);
    }

    //Override the method to add the attributes
    @Override
     public void displayDetails(){
        System.out.println("Name              : " + getFirstName() );
        System.out.println("Last Name         : " + getLastName() );
        System.out.println("Gender            : " + getGender() );
        System.out.println("Age               : " + getAge() );
        System.out.println("Patient ID        : " + getPatientId());
        System.out.println("Medical Condition : " + getMedicalCondition() );
        System.out.println("Category          : " + getCategory() );
        System.out.println("Ward Number       : " + wardNumber);
        System.out.println("Bed Number        : " + bedNumber);
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
