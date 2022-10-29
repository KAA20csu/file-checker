package com.example.filechecker.services;

import com.example.filechecker.modules.IModule;

public class ModuleFunctionalityService {

    public void getOperations(IModule module) {
        module.printFunctions();
    }
}
