package com.hospitalSimulator.app.drugs;

import com.hospitalSimulator.app.patients.State;


public class FlyingFlyingSpaghettiMonster extends AbstractDrug implements Drug {

    // He who boiled for our sins

    public State treat(State state) {
        int randomNum = 1 + (int)(Math.random() * ((1000000 - 1) +1));
        if (state.equals(State.Dead) && randomNum == 666) {
            System.out.println("He who boiled for our sins shows mercy! " +
                    "With his noodly powers a patient has been resurrected");
            return State.Healthy;
        }
        return state;
    }
}
