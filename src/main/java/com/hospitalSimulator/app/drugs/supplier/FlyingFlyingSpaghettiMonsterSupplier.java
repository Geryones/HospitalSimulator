package com.hospitalSimulator.app.drugs.supplier;

import com.hospitalSimulator.app.drugs.Drug;
import com.hospitalSimulator.app.drugs.FlyingFlyingSpaghettiMonster;

import java.util.function.Supplier;

public class FlyingFlyingSpaghettiMonsterSupplier implements Supplier<Drug> {
    @Override
    public Drug get() {
        return new FlyingFlyingSpaghettiMonster();
    }
}
