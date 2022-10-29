package com.example.filechecker.modules;

import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileNotFoundException;
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

    public int executeFirst(File file) {
        int lineCounter = 0;
        try {
            Scanner in = new Scanner(file);
            while(in.hasNextLine()) {
                lineCounter++;
            }

        } catch(FileNotFoundException ex) {
            System.out.println(ex);
        }
        return lineCounter;
    }
}
