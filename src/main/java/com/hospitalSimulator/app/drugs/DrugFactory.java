package com.hospitalSimulator.app.drugs;

import com.hospitalSimulator.app.drugs.supplier.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.function.Supplier;

/**
 * DrugFactory creates Drug-Objects
 */
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


    /**
     * Get a new Drug-Object
     * @param type Drug type
     * @return new Drug object
     */
    public static Drug getDrug(String type){
        Supplier<? extends Drug> supplier = registeredSuppliers.get(type);
        return supplier != null ? supplier.get() : null;
    }

    /**
     * Checks if there are mixtures
     * @param prescription Set with prescribed drugs
     * @return Set of Drug objects
     */
    public abstract HashSet<Drug> getMixtures(HashSet<String> prescription);

    /**
     * Possible to add new Drugs
     * @param type Drug type
     * @param supplier Supplier for the new Drug
     */
    static void registerSupplier(String type, Supplier<? extends Drug> supplier){
        registeredSuppliers.put(type, supplier);
    }


}
