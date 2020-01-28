package com.hospitalSimulater.app.drugs;

import com.hospitalSimulater.app.patients.State;


public class FlyingFlyingSpaghettiMonster extends AbstractDrug implements Drug {

    // He who boiled for our sins

    public State treat(State state) {
        int randomNum = 1 + (int)(Math.random() * ((1000000 - 1) +1));
        if (state.equals(State.Dead) && randomNum == 666) {
            return State.Healthy;
        }
        return state;
    }
}
