package com.hospitalSimulator.app.drugs.supplier;

import com.hospitalSimulator.app.drugs.Antibiotic;
import com.hospitalSimulator.app.drugs.Drug;

import java.util.function.Supplier;

public class AntibioticSupplier implements Supplier<Drug> {
    @Override
    public Drug get() {
        return new Antibiotic();
    }
}
