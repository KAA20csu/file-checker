package com.example.filechecker.modules;

import org.springframework.stereotype.Component;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

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
    public void execute2(File file) throws FileNotFoundException {
        int totalCharacters = 0;
        Scanner scanner = new Scanner(file);
        Map<Character, ArrayList<Character>> dictionary = new HashMap<>();

        while (scanner.hasNext()) {
            char[] str = scanner.next().toLowerCase().toCharArray();
            for (char symbol : str) {
                if (!dictionary.containsKey(symbol))
                    dictionary.put(symbol, new ArrayList<>());
                ArrayList<Character> list = dictionary.get(symbol);
                list.add(symbol);
                totalCharacters++;
            }
        }

        System.out.println("Characters count - " + totalCharacters);

        for (ArrayList<Character> list : dictionary.values()) {
            int count = list.size();
            System.out.println("Count of each character - '" + list.get(0) + "': " + count);
        }
    }

    public void execute3(File file) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileInputStream(file));
        int count=0;
        while(sc.hasNext()){
            sc.next();
            count++;
        }
        System.out.println("Count of words: " + count);
    }
}
