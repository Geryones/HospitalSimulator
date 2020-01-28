package com.hospitalSimulater.app.drugs;

import com.hospitalSimulater.app.patients.State;

public interface Drug {
    public State treat(State state);
}
