package com.hospitalSimulator.app.drugs;

import com.hospitalSimulator.app.drugs.supplier.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.function.Supplier;


public class DynamicDrugFactory implements DrugFactory {

    public static final Map<String, Supplier<? extends Drug>> registeredSuppliers = new HashMap<>();

    static{
        registeredSuppliers.put("As", new AspirinSupplier());
        registeredSuppliers.put("An", new AntibioticSupplier());
        registeredSuppliers.put("I", new InsulinSupplier());
        registeredSuppliers.put("P", new ParacetamolSupplier());
        registeredSuppliers.put("IAn", new InsulinAntibioticSupplier());
        registeredSuppliers.put("PAs", new ParacetamolAspirinSupplier());
        registeredSuppliers.put("God", new FlyingFlyingSpaghettiMonsterSupplier());
    }

    public static void registerSupplier(String type, Supplier<? extends Drug> supplier){
        registeredSuppliers.put(type, supplier);
    }

    public static Drug getDrug(String type){
        Supplier<? extends Drug> supplier = registeredSuppliers.get(type);
        return supplier != null ? supplier.get() : null;
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
        for (String type : prescription) {
            mixedDrugs.add(getDrug(type));
        }
        return mixedDrugs;
    }
}
