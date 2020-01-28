package com.hospitalSimulator.app.drugs;
import java.util.HashSet;



public class DynamicDrugFactory extends DrugFactory {

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
        for (String type : prescription) {
            mixedDrugs.add(getDrug(type));
        }
        return mixedDrugs;
    }
}
