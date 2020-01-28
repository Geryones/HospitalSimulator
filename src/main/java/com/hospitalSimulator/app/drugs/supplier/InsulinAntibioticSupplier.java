package com.hospitalSimulator.app.drugs.supplier;

import com.hospitalSimulator.app.drugs.Drug;
import com.hospitalSimulator.app.drugs.mix.InsulinAntibiotic;

import java.util.function.Supplier;

public class InsulinAntibioticSupplier implements Supplier<Drug> {
    @Override
    public Drug get() {
        return new InsulinAntibiotic();
    }
}
