package com.hospitalSimulater.app;



import com.hospitalSimulater.app.drugs.Drug;
import com.hospitalSimulater.app.drugs.DrugFactory;
import com.hospitalSimulater.app.patients.State;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;


public class Core {
    private static List<State> patientsStates;
    private static HashSet<Drug> drugs;
    static DrugFactory drugFactory = new DrugFactory();

    public static void main(String[] args) {

        if (args != null){
            parsePatients(args[0]);
            parsePrescription(args[1]);

        }else System.out.println("Input required: 1. String, comma separated States, [2. String, comma separated drugs]");


    }

    static void parsePatients(String rawPatientStates){
        String[] states = rawPatientStates.trim().split(",");
        for (String s : states){
            patientsStates.add(State.valueOf(s));
        }
    }

    static void parsePrescription(String rawPrescription){
        String[] prescriptionArray = rawPrescription.trim().split(",");
        HashSet<String> prescriptions = new HashSet<String>(Arrays.asList(prescriptionArray));
        drugs = drugFactory.getMixtures(prescriptions);
    }


}
