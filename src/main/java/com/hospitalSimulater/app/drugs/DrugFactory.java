package com.hospitalSimulater.app.drugs;

public class DrugFactory {

    public Drug getDrug(String drugType){
        if (drugType == null || drugType.equals("")){
            return null;
        }
        if (drugType.equals("As")){
            return new Aspirin();
        }else if (drugType.equals("An")){
            return new Antibiotic();
        }else if (drugType.equals("I")){
            return new Insulin();
        }else if (drugType.equals("P")){
            return new Paracetamol();
        }

        //new Drug types are added here

        return null;
    }
}
