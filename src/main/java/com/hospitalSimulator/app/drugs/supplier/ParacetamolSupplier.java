package com.hospitalSimulator.app.drugs.supplier;

import com.hospitalSimulator.app.drugs.Drug;
import com.hospitalSimulator.app.drugs.Paracetamol;

import java.util.function.Supplier;

public class ParacetamolSupplier implements Supplier<Drug> {

    @Override
    public Drug get() {
        return new Paracetamol();
    }
}
