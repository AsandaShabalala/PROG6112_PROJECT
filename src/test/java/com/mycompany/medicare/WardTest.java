/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.medicare;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author User
 */
public class WardTest {
    

    //Test for registering a patient
    @Test
    public void testRegisterPatient() {
    
    Ward ward = new Ward();
    
    Patient patient = new Patient(
            "Thabani",
            "Buthelezi",
            "P001",
            25,
            "Male",
            "asthma",
            patientCategory.OUTPATIENT
        );
    
    boolean result = ward.addPatient(patient);
    
    assertTrue(result);
    assertEquals(patient, ward.search("P001"));
    
    }
    
    //Test for searching a patient
    @Test
    public void testSearchPatient() {
    
    Ward ward = new Ward();
    
    Patient patient = new Patient(
            "Thabani",
            "Buthelezi",
            "P001",
            25,
            "Male",
            "asthma",
            patientCategory.OUTPATIENT
        );
    
    ward.addPatient(patient);
    Patient found = ward.search("P001");
    
    assertNotNull(found);

    assertEquals("Thabani", found.getFirstName());
    assertEquals("Buthelezi", found.getLastName());
    
    } 
    
    //Test for updating patient details
    @Test
    public void testUpdateatient() {
    
    Ward ward = new Ward();
    
    Patient patient = new Patient(
            "Thabani",
            "Buthelezi",
            "P001",
            25,
            "Male",
            "asthma",
            patientCategory.OUTPATIENT
        );
    ward.addPatient(patient);
    
    patient.setFirstName("James");
    patient.setAge(26);
    patient.setMedicalCondition("HIV");
    
    ward.updatePatient(patient, "P001");
    
    Patient updatedPatient = ward.search("P001");
    
    assertEquals("James", updatedPatient.getFirstName());
    assertEquals("HIV", updatedPatient.getMedicalCondition());
    
    } 
    
    //Test for deleting a patient
    @Test
    public void testDeletePatient() {
    
    Ward ward = new Ward();
    
    Patient patient = new Patient(
            "Thabani",
            "Buthelezi",
            "P001",
            25,
            "Male",
            "asthma",
            patientCategory.OUTPATIENT
        );
    
    ward.addPatient(patient);
    
    assertTrue(ward.removePatient("P001"));
    assertNull(ward.search("P001"));
    }
    
    //Test for allocating bed number
    @Test
    public void testAllocateBed() {
    
    Ward ward = new Ward();
    
    Inpatient patient = new Inpatient(
            "Thabani",
            "Buthelexi",
            "P001",
            25,
            "Male",
            "asthma"
    );
    
    boolean result = ward.allocateBed(patient);
    
    assertTrue(result);         
    assertEquals(1, patient.getBedNumber());    //bed number should return 1 since the patient is stored inthe first empty bed
    
    }
    
    //Test to stop bed allocation if the beds are full i will use a loop to fill the beds with one patient basically and test
    @Test
    public void testBedsAreFulL(){
        
        Ward ward = new Ward();
        
        Patient patient = new Inpatient(
            "Thabani",
            "Buthelexi",
            "P001",
            25,
            "Male",
            "asthma"
        );
        
        for(int i = 1; i <= 20; i++){
            
            ward.allocateBed((Inpatient) patient);
         }
        
        Inpatient extraPatient = new Inpatient(
            "Extra",
            "Patient",
            "P002",
            30,
            "Male",
            "Flu"
        );
        
        //allocate bed should return false since all the beds are now full 
        assertFalse(ward.allocateBed(extraPatient));
    }

    
    //Test releasing a bed after the patient is removed
    @Test
    public void testReleaseBed() {
    
        Ward ward = new Ward();

        Inpatient patient = new Inpatient(
                "Thabani",
                "Buthelexi",
                "P001",
                25,
                "Male",
                "asthma"
        );
        ward.addPatient(patient);
        boolean bedAllocated = ward.allocateBed(patient);
        boolean bedReleased = ward.removePatient("P001");
        
        assertTrue(bedAllocated);
        assertTrue(bedReleased);
        assertNull(ward.search("P001"));
        
    
    }
}
