package com.hospitalSimulater.app.patients;

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


}
