package com.example.filechecker.modules;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class MusicFileModule implements IModule {
    @Override
    public boolean fileExtension(String extension) {
        return extension.equals("mp3");
    }

    private List<String> functions = Arrays.asList(
            "1. Ouput the title of track",
            "2. Ouput the duration of track",
            "3. Ouput the author of track"
    );

    @Override
    public void printFunctions() {
        for(var function : functions) {
            System.out.println(function);
        }
    }
}
