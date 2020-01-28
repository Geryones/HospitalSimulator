package com.hospitalSimulator.app.drugs;

import com.hospitalSimulator.app.patients.State;

public class Insulin extends AbstractDrug implements Drug {
    public State treat(State state) {
        return state;
    }
}
