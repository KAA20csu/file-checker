package com.example.filechecker.modules;

import org.springframework.stereotype.Component;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

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
        DirectoriesModule.class.getMethod("execute" + nextInt, File.class).invoke(this, file);
    }

    public void execute1(File file) {
        StringBuilder fileNames = new StringBuilder();
        File[] files = file.listFiles();
        System.out.println("Files in " + file + ": \n");
        for (File curFile : files) {
            fileNames.append(curFile.getName()).append("\n");
        }
        System.out.println(fileNames);
    }
    public void execute2(File file) throws FileNotFoundException {
        double totalSize = 0;
        File[] files = file.listFiles();
        for (File curFile : files) {
            totalSize += curFile.length() / 1024;
        }
        System.out.println("Files' total size: " + String.format("%.2f", totalSize) + " KB");
    }

    public void execute3(File file) throws FileNotFoundException {
        File[] files = file.listFiles();
        System.out.println("Total count of files and subdirectories: " + files.length);
    }
}
