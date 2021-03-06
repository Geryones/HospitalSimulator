package com.hospitalSimulator.app.patients;

import com.hospitalSimulator.app.drugs.Drug;
import com.hospitalSimulator.app.drugs.FlyingFlyingSpaghettiMonster;
import com.hospitalSimulator.app.drugs.Insulin;
import com.hospitalSimulator.app.drugs.mix.InsulinAntibiotic;

import java.util.HashSet;

/**
 * Simulates a patient and his Drugs
 */
public class Patient {
    private State state;
    private boolean diabetesTreated = false;
    private HashSet<Drug> drugs;

    /**
     * Constructor
     * @param state state of the patient
     * @param drugs drugs the patient uses
     */
    public Patient(State state, HashSet<Drug> drugs) {
        this.state = state;
        this.drugs = drugs;
    }

    /**
     * Patient takes all his drugs
     */
    public void takeMyDrugs(){
        if (drugs != null) {

            for (Drug d : drugs) {
                if (state.equals(State.Dead)) {
                    break;
                }

                if (d instanceof Insulin || d instanceof InsulinAntibiotic) {
                    diabetesTreated = true;
                }
                state = d.treat(this.state);
            }
        }

        if (this.state.equals(State.Diabetes) && !diabetesTreated){
            this.state = State.Dead;
        }

        //Divine intervention comes at the end
        if (state.equals(State.Dead)){
           this.state =  new FlyingFlyingSpaghettiMonster().treat(state);
        }

    }

    public State getState() {
        return state;
    }
}
