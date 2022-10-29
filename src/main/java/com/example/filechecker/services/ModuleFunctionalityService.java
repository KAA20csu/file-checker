package com.example.filechecker.services;

import com.example.filechecker.modules.IModule;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class ModuleFunctionalityService {
    public void getOperations(IModule module, File file) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        module.printFunctions();
        System.out.println("Please, enter the number of option, which you want to execute: ");
        Scanner sc = new Scanner(System.in);
        int opId = sc.nextInt();
        module.executeCommand(module, opId, file);
    }
}
