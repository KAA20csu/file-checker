package com.example.filechecker.modules;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class ImageFileModule implements IModule {
    @Override
    public boolean fileExtension(String extension) {
        return extension.equals("jpg") || extension.equals("png") || extension.equals("jpeg");
    }

    private List<String> functions = Arrays.asList(
            "1. Output the size of the image",
            "2. Output the metadata",
            "3. Output the orientation"
    );

    @Override
    public void printFunctions() {
        for(var function : functions) {
            System.out.println(function);
        }
    }
}
