package com.hospitalSimulator.app;
import com.hospitalSimulator.app.drugs.Drug;
import com.hospitalSimulator.app.drugs.DynamicDrugFactory;
import com.hospitalSimulator.app.patients.Patient;
import com.hospitalSimulator.app.patients.State;

import java.util.*;
import java.util.stream.Collectors;


import static java.util.Map.Entry.comparingByKey;

/**
 * Simulates the Hospital
 */
public class Hospital {
    private  ArrayList<Patient> patients = new ArrayList<Patient>();
    private  HashSet<Drug> drugs = new HashSet<Drug>();
    private DynamicDrugFactory dynamicDrugFactory = new DynamicDrugFactory();
    private HashMap<State, Integer> results = new HashMap<State, Integer>();
    private String outPutString;

    /**
     * Triggers the treatment and evaluation of all patients and their drugs
     * @param args String[0] the state of patients and String[1] the drugs
     */
    void doYourJob(String[] args) {
        if (args != null){
            if (args.length >= 2){
                parsePrescription(args[1]);
            }
            parsePatients(args[0]);
            curePatients(patients);
            collectData(patients);
            concatData(results);
            System.out.println(outPutString);

        }else System.out.println("Input required: 1. String, comma separated States, [2. String, comma separated drugs]");
    }

    /**
     * Parse input String of patient states
     * @param rawPatientStates String with patient states
     */
    private void parsePatients(String rawPatientStates){

        String[] states = rawPatientStates.trim().split(",");
        for (String s : states){
            this.patients.add(new Patient(State.fromString(s.toUpperCase().trim()), drugs));
        }

    }

    /**
     * Parse input String of drugs
     * @param rawPrescription
     */
    private void parsePrescription(String rawPrescription){
        if (rawPrescription.equals("")){
            return;
        }
        String[] prescriptionArray = rawPrescription.trim().split(",");
        HashSet<String> prescriptions = new HashSet<String>(Arrays.asList(prescriptionArray));
        this.drugs = dynamicDrugFactory.getMixtures(prescriptions);

    }

    /**
     * All patients take their drugs
     * @param patients List of patients
     */
    private void curePatients(List<Patient> patients) {
        patients.forEach(Patient::takeMyDrugs);
    }

    /**
     * Collect the date of all patients
     * @param patients List of all patients
     */
    private void collectData(List<Patient> patients){
        initResults(this.results);
        for (Patient p : patients){
            int count = results.get(p.getState());
            this.results.put(p.getState(), count+1 );
        }

    }

    /**
     * Initialize the results
     * @param results HashMap<State, Integer> to initialize
     * @return Initialized HashMap
     */
    private HashMap<State, Integer> initResults(HashMap<State, Integer> results){
       State[] states = State.class.getEnumConstants();

       for (State s : states){
           results.put(s, 0);
       }
       return  results;
    }

    /**
     * Concatenates the results
     * @param results The result HashMap
     */
    private void concatData(HashMap<State, Integer> results){

       String result = results.entrySet().stream().sorted(comparingByKey()).map((entry) ->
              entry.getKey() + ":" + entry.getValue() + ",")
              .collect(Collectors.joining(" "));
        this.outPutString = result.substring(0, result.length() - 1);
    }


    public ArrayList<Patient> getPatients() {
        return patients;
    }

    public void setPatients(ArrayList<Patient> patients) {
        this.patients = patients;
    }

    public HashSet<Drug> getDrugs() {
        return drugs;
    }

    public void setDrugs(HashSet<Drug> drugs) {
        this.drugs = drugs;
    }


    public HashMap<State, Integer> getResults() {
        return results;
    }

    public String getOutPutString() {
        return outPutString;
    }
}
