package com.hospitalSimulator.app.drugs.supplier;

import com.hospitalSimulator.app.drugs.Drug;
import com.hospitalSimulator.app.drugs.Insulin;

import java.util.function.Supplier;

public class InsulinSupplier implements Supplier<Drug> {
    @Override
    public Drug get() {
        return new Insulin();
    }
}
