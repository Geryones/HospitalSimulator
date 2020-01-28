package com.hospitalSimulater.app.drugs;

import com.hospitalSimulater.app.patients.State;

public abstract class AbstractDrug implements Drug {
    abstract public State treat(State state);
}
