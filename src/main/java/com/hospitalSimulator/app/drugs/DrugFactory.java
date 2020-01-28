package com.hospitalSimulator.app.drugs;

import com.hospitalSimulator.app.drugs.supplier.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.function.Supplier;

public abstract class DrugFactory {

    public static final Map<String, Supplier<? extends Drug>> registeredSuppliers = new HashMap<>();

    // register your new Drugs here
    static{
        registeredSuppliers.put("As", new AspirinSupplier());
        registeredSuppliers.put("An", new AntibioticSupplier());
        registeredSuppliers.put("I", new InsulinSupplier());
        registeredSuppliers.put("P", new ParacetamolSupplier());
        registeredSuppliers.put("IAn", new InsulinAntibioticSupplier());
        registeredSuppliers.put("PAs", new ParacetamolAspirinSupplier());
        registeredSuppliers.put("God", new FlyingFlyingSpaghettiMonsterSupplier());
    }



    public static Drug getDrug(String type){
        Supplier<? extends Drug> supplier = registeredSuppliers.get(type);
        return supplier != null ? supplier.get() : null;
    }


    public abstract HashSet<Drug> getMixtures(HashSet<String> prescription);

    /**
     * Possible to add new Drugs
     * @param type String for the Drug code
     * @param supplier Supplier for the new Drug
     */
    static void registerSupplier(String type, Supplier<? extends Drug> supplier){
        registeredSuppliers.put(type, supplier);
    }


}
