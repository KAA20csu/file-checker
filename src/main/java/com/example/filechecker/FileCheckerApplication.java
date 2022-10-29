package com.example.filechecker;

import com.example.filechecker.modules.IModule;
import com.example.filechecker.services.ModuleFunctionalityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Scanner;

@SpringBootApplication
public class FileCheckerApplication {

    private static Collection<IModule> modules;
    private static File file;
    private static ModuleFunctionalityService service = new ModuleFunctionalityService();
    @Autowired
    public FileCheckerApplication(Collection<IModule> modules) { // инжектим все компоненты, реализующие IModule
        this.modules = modules;
    }
    public FileCheckerApplication(){}

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        SpringApplication.run(FileCheckerApplication.class, args);
        Scanner in = new Scanner(System.in);
        System.out.println("Please, enter file path: ");
        String path = in.nextLine();
        file = new File(path);
        for(IModule module : modules) {
            if(module.fileExtension(getFileExtension())) { // выбираем подходящий под расширение файла модуль
                service.getOperations(module, file); // отдаём список операций
            }
        }
    }

    private static String getFileExtension() {
        String fileName = file.getName();
        if (fileName.lastIndexOf(".") != -1)
            return fileName.substring(fileName.lastIndexOf(".") + 1);
        else if (file.isDirectory())
            return "directory";
        return "unknown";
    }

}
