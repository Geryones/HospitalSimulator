package com.hospitalSimulator.app.drugs;

import java.util.HashSet;

public interface DrugFactory {
    HashSet<Drug> getMixtures(HashSet<String> prescription);
}
