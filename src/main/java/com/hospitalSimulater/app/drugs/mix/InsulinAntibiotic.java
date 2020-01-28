package com.hospitalSimulater.app.drugs.mix;

import com.hospitalSimulater.app.drugs.AbstractDrug;
import com.hospitalSimulater.app.drugs.Drug;
import com.hospitalSimulater.app.patients.State;

public class InsulinAntibiotic extends AbstractDrug implements Drug {
    public State treat(State state) {
        if (state.equals(State.Tuberculosis)){
            return State.Healthy;
        }

        if (state.equals(State.Healthy)){
            return State.Fever;
        }
        return state;
    }
}
