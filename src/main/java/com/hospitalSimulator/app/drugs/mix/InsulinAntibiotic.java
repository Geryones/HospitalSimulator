package com.hospitalSimulator.app.drugs.mix;

import com.hospitalSimulator.app.drugs.AbstractDrug;
import com.hospitalSimulator.app.drugs.Drug;
import com.hospitalSimulator.app.patients.State;

/**
 * Drug Cocktail of Insulin and Antibiotics
 */
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
