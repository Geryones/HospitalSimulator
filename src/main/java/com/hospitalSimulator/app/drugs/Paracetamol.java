package com.hospitalSimulator.app.drugs;

import com.hospitalSimulator.app.patients.State;

public class Paracetamol extends AbstractDrug implements Drug {
    public State treat(State state) {
        if (state.equals(State.Fever)){
            return State.Healthy;
        }
        return state;
    }
}

