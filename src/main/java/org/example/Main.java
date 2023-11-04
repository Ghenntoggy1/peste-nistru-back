package org.example;

import org.example.deepl.TranslatorClass;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication()
public class Main {
    public static void main(String[] args) throws Exception {
//        SpringApplication.run(Main.class, args);
        String lang = "ro";
        TranslatorClass translatorClass = new TranslatorClass();
        System.out.println(translatorClass.translateText("plb it seems like ours xd\n" +
                "moor!", lang));
    }
}