package com.example.filechecker.modules;

import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.util.*;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;

@Component
public class ImageFileModule implements IModule {
    @Override
    public boolean fileExtension(String extension) {
        return extension.equals("jpg") || extension.equals("png") || extension.equals("jpeg");
    }

    private List<String> functions = Arrays.asList(
            "1. Output the resolution of the image",
            "2. Output the metadata",
            "3. Output the orientation"
    );

    @Override
    public void printFunctions() {
        for(var function : functions) {
            System.out.println(function);
        }
    }

    @Override
    public void executeCommand(IModule module, int nextInt, File file) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        ImageFileModule.class.getMethod("execute" + nextInt, File.class).invoke(this, file);
    }

    public void execute1(File file) throws IOException {
        BufferedImage image = ImageIO.read(file);
        int width = image.getWidth();
        int height = image.getHeight();
        System.out.println("Image resolution: " + width + "x" + height + "px");
    }
    public void execute2(File file) throws IOException, ImageProcessingException {
        Metadata metadata = ImageMetadataReader.readMetadata(file);

        System.out.println("EXIF information:");
        for (Directory directory : metadata.getDirectories()) {
            for (Tag tag : directory.getTags()) {
                System.out.println(tag);
            }
        }
    }

    public void execute3(File file) throws IOException {
        BufferedImage image = ImageIO.read(file);
        int width = image.getWidth();
        int height = image.getHeight();
        String orientation = "";
        if (width == height)
            orientation = "square";
        else
            orientation = width > height ? "landscape" : "portrait";
        System.out.println("Image orientation: " + orientation);
    }
}
