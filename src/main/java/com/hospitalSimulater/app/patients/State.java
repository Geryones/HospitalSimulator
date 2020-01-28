package com.hospitalSimulater.app.patients;

public enum State {
    F("F"),
    H("H"),
    D("D"),
    T("T"),
    X("X");

    public String text;

    State(String text) {
        this.text = text;
    }

    public String getText(){
        return this.text;
    }


}
