package com.hospitalSimulator.app.drugs;

import com.hospitalSimulator.app.patients.State;

public abstract class AbstractDrug implements Drug {
    abstract public State treat(State state);
}
