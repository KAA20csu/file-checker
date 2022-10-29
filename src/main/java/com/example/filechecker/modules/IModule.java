package com.example.filechecker.modules;

import java.io.File;
import java.lang.reflect.InvocationTargetException;

public interface IModule {
    boolean fileExtension(String extension);
    void printFunctions();
    void executeCommand(IModule module, int nextInt, File file) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException;
}
