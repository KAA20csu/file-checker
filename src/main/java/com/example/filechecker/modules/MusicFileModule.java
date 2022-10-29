package com.example.filechecker.modules;

import org.springframework.stereotype.Component;
import org.tritonus.share.sampled.file.TAudioFileFormat;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

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

    @Override
    public void executeCommand(IModule module, int nextInt, File file) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        MusicFileModule.class.getMethod("execute" + nextInt, File.class).invoke(this, file);
    }

    public void execute1(File file) throws IOException, UnsupportedAudioFileException {
        AudioFileFormat fileFormat = AudioSystem.getAudioFileFormat(file);
        if (fileFormat instanceof TAudioFileFormat) {
            Map<?, ?> properties = fileFormat.properties();
            String key = "title";
            String author = (String) properties.get(key);
            System.out.println("Title: " + author);
        }
    }
    public void execute2(File file) throws IOException, UnsupportedAudioFileException {
        AudioFileFormat fileFormat = AudioSystem.getAudioFileFormat(file);
        if (fileFormat instanceof TAudioFileFormat) {
            Map<?, ?> properties = fileFormat.properties();
            String key = "duration";
            Long microSec = (Long) properties.get(key);
            int sec = (int) (microSec / (1000 * 1000));
            System.out.println("Duration of the song: " + sec + " seconds");
        }
    }

    public void execute3(File file) throws IOException, UnsupportedAudioFileException {
        AudioFileFormat fileFormat = AudioSystem.getAudioFileFormat(file);
        if (fileFormat instanceof TAudioFileFormat) {
            Map<?, ?> properties = fileFormat.properties();
            String key = "author";
            String author = (String) properties.get(key);
            System.out.println("Author: " + author);
        }
    }
}
