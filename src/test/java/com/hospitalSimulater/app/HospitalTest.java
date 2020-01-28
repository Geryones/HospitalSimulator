package com.hospitalSimulater.app;


import com.hospitalSimulater.app.drugs.Drug;
import com.hospitalSimulater.app.patients.Patient;
import com.hospitalSimulater.app.patients.State;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.HashSet;

public class HospitalTest {
    Hospital hospital;


    @Before
    public void setUP(){
        hospital = new Hospital();
    }


    @Test
    public void testInputStates(){
        String input = "D,D,F,H,T";
        hospital.parsePatients(input);
        Assert.assertEquals(5, hospital.getPatients().size());
    }

    @Test
    public void testInputDrugs(){
        String input = "I,P";
        hospital.parsePrescription(input);
        Assert.assertEquals(2, hospital.getDrugs().size());
    }

    @Test
    public void testInputSameDrugs(){
        String input = "I,I,I,I,P";
        hospital.parsePrescription(input);
        Assert.assertEquals(2, hospital.getDrugs().size());
    }

    @Test
    public void testInputDrugsMix(){
        String input = "I,P,An,As";
        hospital.parsePrescription(input);
        Assert.assertEquals(2, hospital.getDrugs().size());
    }


    @Test
    public void testHospitalWithInsulin(){
        String[] input = new String[2];
        input[0] = "D,D";
        input[1] = "I";
        hospital.doYourJob(input);
        Assert.assertEquals("Fever:0, Healthy:0, Diabetes:2, Tuberculosis:0, Dead:0", hospital.getOutPutString());
    }

    @Test
    public void testHospitalWithCure(){
        String[] input = new String[2];
        input[0] = "F";
        input[1] = "P";
        hospital.doYourJob(input);
        Assert.assertEquals("Fever:0, Healthy:1, Diabetes:0, Tuberculosis:0, Dead:0", hospital.getOutPutString());

    }

    @Test
    public void testHospitalWithCertainDeath(){
        String[] input = new String[2];
        input[0] = "F,H,D,T,T,H";
        input[1] = "P,As";
        hospital.doYourJob(input);
        Assert.assertEquals("Fever:0, Healthy:0, Diabetes:0, Tuberculosis:0, Dead:6", hospital.getOutPutString());

    }

    @Test
    public void testHospitalWithCertainDeath2(){
        String[] input = new String[2];
        input[0] = "F,H,D,T,T,H";
        input[1] = "As,P";
        hospital.doYourJob(input);
        Assert.assertEquals("Fever:0, Healthy:0, Diabetes:0, Tuberculosis:0, Dead:6", hospital.getOutPutString());

    }

    @Test
    public void testHospitalWithCausedFever(){
        String[] input = new String[2];
        input[0] = "H";
        input[1] = "I,An";
        hospital.doYourJob(input);
        Assert.assertEquals("Fever:1, Healthy:0, Diabetes:0, Tuberculosis:0, Dead:0", hospital.getOutPutString());

    }

    @Test
    public void testHospitalWithCausedFever2(){
        String[] input = new String[2];
        input[0] = "H";
        input[1] = "An,I";
        hospital.doYourJob(input);
        Assert.assertEquals("Fever:1, Healthy:0, Diabetes:0, Tuberculosis:0, Dead:0", hospital.getOutPutString());

    }

    /**
     * not factoring in the flying Spaghetti Monster
     */
    @Test
    public void testHospitalHomeopathy(){
        String[] input = new String[1];
        input[0] = "D,D,D,D,D,D,D";

        hospital.doYourJob(input);
        Assert.assertEquals("Fever:0, Healthy:0, Diabetes:0, Tuberculosis:0, Dead:7", hospital.getOutPutString());

    }

    /**
     * not factoring in the flying Spaghetti Monster
     */
    @Test
    public void testWrongDrug(){
        String[] input = new String[2];
        input[0] = "D,D,D,D,D,D,D";
        input[1] = "As,An";
        hospital.doYourJob(input);
        Assert.assertEquals("Fever:0, Healthy:0, Diabetes:0, Tuberculosis:0, Dead:7", hospital.getOutPutString());

    }

    /**
     * not factoring in the flying Spaghetti Monster
     */
    @Test
    public void testWrongDrug2(){
        String[] input = new String[2];
        input[0] = "D,D,D,D,D,D,D";
        input[1] = "P,An";
        hospital.doYourJob(input);
        Assert.assertEquals("Fever:0, Healthy:0, Diabetes:0, Tuberculosis:0, Dead:7", hospital.getOutPutString());

    }


    @Test(expected = IllegalArgumentException.class)
    public void testWrongInput(){
        String[] input = new String[2];
        input[0] = "B";
        input[1] = "As,An";
        hospital.doYourJob(input);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNoFirstInput(){
        String[] input = new String[2];
        input[0] = "";
        input[1] = "As,An";
        hospital.doYourJob(input);
    }

    @Test
    public void testFlyingSpaghettiMonster(){
        int holyCounter = 0;
        Hospital divineHospital;

        for (int i = 0; i < 10000; i++){
            divineHospital = new Hospital();
            String[] input = new String[1];
            input[0] = "D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D" +
                    ",D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D" +
                    ",D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D" +
                    ",D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D" +
                    ",D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D" +
                    ",D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D" +
                    ",D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D" +
                    ",D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D" +
                    ",D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D" +
                    ",D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D" +
                    ",D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D" +
                    ",D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D" +
                    ",D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D" +
                    ",D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D" +
                    ",D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D" +
                    ",D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D" +
                    ",D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D" +
                    ",D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D" +
                    ",D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D" +
                    ",D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D" +
                    ",D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D" +
                    ",D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D" +
                    ",D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D" +
                    ",D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D" +
                    ",D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D" +
                    ",D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D" +
                    ",D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D" +
                    ",D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D" +
                    ",D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D" +
                    ",D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D" +
                    ",D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D" +
                    ",D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D" +
                    ",D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D" +
                    ",D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D" +
                    ",D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D" +
                    ",D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D" +
                    ",D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D" +
                    ",D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D" +
                    ",D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D" +
                    ",D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D" +
                    ",D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D" +
                    ",D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D" +
                    ",D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D" +
                    ",D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D" +
                    ",D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D" +
                    ",D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D" +
                    ",D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D" +
                    ",D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D" +
                    ",D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D" +
                    ",D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D" +
                    ",D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D" +
                    ",D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D,D" +
                    ",D,D,D,D,D,D,D,D,D,D,D,D,D";
            divineHospital.doYourJob(input);
            holyCounter += divineHospital.getResults().get(State.Healthy);
        }

        Assert.assertEquals(10, holyCounter, 5);

    }



}