package com.hospitalSimulator.app;


import com.hospitalSimulator.app.patients.State;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

public class HospitalTest {
    Hospital hospital;


    @Before
    public void setUP(){
        hospital = new Hospital();
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