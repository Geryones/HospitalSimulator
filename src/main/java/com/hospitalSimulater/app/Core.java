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
            String rawPatientStates = args[0].trim();
            String rawPrescription = args[1].trim();

            String[] states = rawPatientStates.split(",");
            String[] prescriptionArray = rawPrescription.split(",");
            HashSet<String> prescription = new HashSet<String>(Arrays.asList(prescriptionArray));

            for (String s : states){
                    patientsStates.add(State.valueOf(s));
            }

            drugs = drugFactory.getMixtures(prescription);














        }else System.out.println("Input required: 1. String, comma separated States, [2. String, comma separated drugs]");


    }
}
