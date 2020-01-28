package com.hospitalSimulator.app.drugs;

import com.hospitalSimulator.app.patients.State;

public class Antibiotic extends AbstractDrug implements Drug {
    public State treat(State state) {
        if (state.equals(State.Tuberculosis)){
            return State.Healthy;
        }
        return state;
    }
}
