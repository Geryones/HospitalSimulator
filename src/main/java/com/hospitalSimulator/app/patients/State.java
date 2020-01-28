package com.hospitalSimulator.app.patients;

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

    public static State fromString(String text){
        for (State state : State.values()) {
            if (state.text.equalsIgnoreCase(text)){
                return state;
            }
        }
        throw new IllegalArgumentException("This state does not exist: " + text );
    }


}
