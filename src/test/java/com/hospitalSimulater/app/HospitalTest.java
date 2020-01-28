package com.hospitalSimulater.app;


import com.hospitalSimulater.app.drugs.Drug;
import com.hospitalSimulater.app.patients.Patient;
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

    @After
    public void breakDown(){}

    @Test
    public void TestInputStates(){
        String input = "D,D,F,H,T";
        hospital.parsePatients(input);
        Assert.assertEquals(5, hospital.getPatients().size());
    }

    @Test
    public void TestInputDrugs(){
        String input = "I,P";
        hospital.parsePrescription(input);
        Assert.assertEquals(2, hospital.getDrugs().size());
    }

    @Test
    public void TestInputSameDrugs(){
        String input = "I,I,I,I,P";
        hospital.parsePrescription(input);
        Assert.assertEquals(2, hospital.getDrugs().size());
    }

    @Test
    public void TestInputDrugsMix(){
        String input = "I,P,An,As";
        hospital.parsePrescription(input);
        Assert.assertEquals(2, hospital.getDrugs().size());
    }

    @Test
    public void TestHospital(){
        String[] input = new String[1];
        input[0] = "D,D";
        Core.main(input);
        Assert.assertEquals("Fever:0, Healthy:0, Diabetes:0, Tuberculosis:0, Dead:2", hospital.getOutPutString());

    }




}