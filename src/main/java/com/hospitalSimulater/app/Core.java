package com.hospitalSimulater.app;



import com.hospitalSimulater.app.patients.State;

import java.util.List;

public class Core {
    public static List<State> patientsStates;

    public static void main(String[] args) {

        if (args != null){
            String rawPatientStates = args[0].trim();
            String rawDrugs = args[1].trim();

            String[] states = rawPatientStates.split(",");
            String[] drugs = rawDrugs.split(",");

            for (String s : states){
                
            }



        }else System.out.println("Input required: 1. String, comma separated States, [2. String, comma separated drugs]");


    }
}
