package com.hospitalSimulator.app.drugs.mix;

import com.hospitalSimulator.app.drugs.AbstractDrug;
import com.hospitalSimulator.app.drugs.Drug;
import com.hospitalSimulator.app.patients.State;

/**
 * Drug Cocktail of Paracetamol and Aspirin
 */
public class ParacetamolAspirin extends AbstractDrug implements Drug {
    public State treat(State state) {
        return State.Dead;
    }
}
