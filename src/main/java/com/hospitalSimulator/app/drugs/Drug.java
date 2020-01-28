package com.hospitalSimulator.app.drugs;

import com.hospitalSimulator.app.patients.State;

public interface Drug {
    public State treat(State state);
}
