package com.hospitalSimulator.app.drugs.supplier;

import com.hospitalSimulator.app.drugs.Aspirin;
import com.hospitalSimulator.app.drugs.Drug;

import java.util.function.Supplier;

public class AspirinSupplier implements Supplier<Drug> {
    @Override
    public Drug get() {
        return new Aspirin();
    }
}
