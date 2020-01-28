package com.hospitalSimulater.app;
import com.hospitalSimulater.app.drugs.Drug;
import com.hospitalSimulater.app.drugs.DrugFactory;
import com.hospitalSimulater.app.patients.Patient;
import com.hospitalSimulater.app.patients.State;

import java.util.*;
import java.util.stream.Collectors;


public class Hospital {
    private static List<Patient> patients = new ArrayList<Patient>();
    private static HashSet<Drug> drugs = new HashSet<Drug>();
    private static DrugFactory drugFactory = new DrugFactory();
    private static HashMap<State, Integer> results = new HashMap<State, Integer>();

    public static void main(String[] args) {





        if (args != null){
            parsePrescription(args[1]);
            parsePatients(args[0]);
            curePatients(patients);
            collectData(patients);
            printData(results);

        }else System.out.println("Input required: 1. String, comma separated States, [2. String, comma separated drugs]");


    }

    static void parsePatients(String rawPatientStates){

        String[] states = rawPatientStates.trim().split(",");
        for (String s : states){
            patients.add(new Patient(State.fromString(s.toUpperCase().trim()), drugs));
        }
    }

    static void parsePrescription(String rawPrescription){
        if (rawPrescription.equals(null)){
            return;
        }
        String[] prescriptionArray = rawPrescription.trim().split(",");
        HashSet<String> prescriptions = new HashSet<String>(Arrays.asList(prescriptionArray));
        drugs = drugFactory.getMixtures(prescriptions);
    }

    static void curePatients(List<Patient> patients) {
        for (Patient p : patients){
            p.takeMyDrugs();
        }
    }

    static void collectData(List<Patient> patients){
        initResults();
        for (Patient p : patients){
            int count = results.get(p.getState());
            results.put(p.getState(), count+1 );
        }
    }

    static void initResults(){
       State[] states = State.class.getEnumConstants();

       for (State s : states){
           results.put(s, 0);
       }
    }

    static void printData(HashMap<State, Integer> results){

       String result = results.entrySet().stream().map((entry) ->
              entry.getKey() + ":" + entry.getValue() + ",")
              .collect(Collectors.joining(" "));

        result = result.substring(0, result.length() - 1);

        System.out.println(result);
    }




}
