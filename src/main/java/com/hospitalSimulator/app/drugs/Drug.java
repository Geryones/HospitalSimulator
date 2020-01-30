package com.hospitalSimulator.app.drugs;

import com.hospitalSimulator.app.patients.State;

/**
 * A drug cures diseases
 * If used in the wrong situation in can cause severe damage to the patient
 * If you mix drugs, it can cause side effects
 */
public interface Drug {
    /**
     * Use the drug
     * @param state state of the patient before treatment
     * @return State of patient after treatment
     */
    public State treat(State state);
}
