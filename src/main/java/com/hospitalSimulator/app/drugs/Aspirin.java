package com.hospitalSimulator.app.drugs;

import com.hospitalSimulator.app.patients.State;

public class Aspirin extends AbstractDrug implements Drug {
     public State treat(State state) {
         if (state.equals(State.Fever)){
             return State.Healthy;
         }
        return state;
    }
}
