package com.hospitalSimulator.app.drugs.supplier;

import com.hospitalSimulator.app.drugs.Drug;
import com.hospitalSimulator.app.drugs.mix.ParacetamolAspirin;

import java.util.function.Supplier;

public class ParacetamolAspirinSupplier implements Supplier<Drug>{
    @Override
    public Drug get() {
        return new ParacetamolAspirin();
    }
}
