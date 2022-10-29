package com.example.filechecker.modules;

import org.springframework.stereotype.Component;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;

@Component
public class DirectoriesModule implements IModule {
    @Override
    public boolean fileExtension(String extension) {
        return extension.equals("directory");
    }

    private List<String> functions = Arrays.asList(
            "1. Output the list of files",
            "2. Output the size of all files",
            "3. Output the count of files and directories"
    );

    @Override
    public void printFunctions() {
        for(var function : functions) {
            System.out.println(function);
        }
    }

    @Override
    public void executeCommand(IModule module, int nextInt, File file) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

    }
}
