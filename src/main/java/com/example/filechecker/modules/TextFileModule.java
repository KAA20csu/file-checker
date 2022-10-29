package com.example.filechecker.modules;

import org.springframework.stereotype.Component;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

@Component
public class TextFileModule implements IModule {

    public boolean fileExtension(String extension) {
        return extension.equals("txt");
    }
    private List<String> functions = Arrays.asList(
            "1. Count lines",
            "2. Output the frequency of occurrence of each character",
            "3. Count words"
    );

    @Override
    public void printFunctions() {
        for(var function : functions) {
            System.out.println(function);
        }
    }

    @Override
    public void executeCommand(IModule module, int nextInt, File file) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        TextFileModule.class.getMethod("execute" + nextInt, File.class).invoke(this, file);
    }

    public void execute1(File file) {
        int lineCounter = 0;
        try (var reader = new BufferedReader(new FileReader(file))) {
            while (reader.readLine() != null) {
                lineCounter++;
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(lineCounter);
    }
    public void execute2(File file) {

    }

    public void execute3(File file) {

    }
}
