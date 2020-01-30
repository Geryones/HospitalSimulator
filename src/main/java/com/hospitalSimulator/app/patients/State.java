package com.hospitalSimulator.app.patients;

/**
 * State of a patient
 */
public enum State {
    Fever("F"),
    Healthy("H"),
    Diabetes("D"),
    Tuberculosis("T"),
    Dead("X");

    public String text;

    State(String text) {
        this.text = text;
    }

    public String getText(){
        return this.text;
    }

    /**
     * Create a new State from String
     * @param abbreviation abbreviation of the state
     * @return new State
     */
    public static State fromString(String abbreviation){
        for (State state : State.values()) {
            if (state.text.equalsIgnoreCase(abbreviation)){
                return state;
            }
        }
        throw new IllegalArgumentException("This state does not exist: " + abbreviation );
    }


}
