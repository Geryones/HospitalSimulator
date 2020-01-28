package com.hospitalSimulator.app.drugs;

import com.hospitalSimulator.app.drugs.mix.InsulinAntibiotic;
import com.hospitalSimulator.app.drugs.mix.ParacetamolAspirin;

import java.util.HashSet;


public class DrugFactory {

    /**
     * Returns a new Drug object
     * @param drugType String
     * @return Null if the input was invalid or a new DrugObject
     */
    private Drug getDrug(String drugType){
        if (drugType == null || drugType.equals("")){
            return null;
        }
        if (drugType.equals("As")){
            return new Aspirin();
        }else if (drugType.equals("An")){
            return new Antibiotic();
        }else if (drugType.equals("I")){
            return new Insulin();
        }else if (drugType.equals("P")){
            return new Paracetamol();
        }else if (drugType.equals("IAn")){
            return new InsulinAntibiotic();
        }else if (drugType.equals("PAs")){
            return new ParacetamolAspirin();
        }else if (drugType.equals("God")){
            return new FlyingFlyingSpaghettiMonster();
        }

        //new Drug types are added here

        return null;
    }

    /**
     * Returns a Set of Drugs, Mixtures will be created
     * @param prescription Set of Drugs as String
     * @return Set of Drug, null if input is invalid
     */
    public HashSet<Drug> getMixtures(HashSet<String> prescription){
        HashSet<Drug> mixedDrugs = new HashSet<>();
        if (prescription.isEmpty()){
            return null;
        }
        //check if there are any drugs that mix together
        if (prescription.contains("P") && prescription.contains("As")){
            prescription.remove("P");
            prescription.remove("As");
            prescription.add("PAs");
        }
        if (prescription.contains("I") && prescription.contains("An")){
            prescription.remove("I");
            prescription.remove("An");
            prescription.add("IAn");
        }

        //add new mixtures here

        //create drugs from prescription
        for (String drug : prescription) {
            mixedDrugs.add(getDrug(drug));
        }
        return mixedDrugs;
    }
}
