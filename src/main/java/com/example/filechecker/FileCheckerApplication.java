package com.example.filechecker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class FileCheckerApplication {

    public static void main(String[] args) {
        SpringApplication.run(FileCheckerApplication.class, args);

        Scanner in = new Scanner(System.in);
        System.out.println("Please, enter file path: ");
        String path = in.nextLine();
    }

}
