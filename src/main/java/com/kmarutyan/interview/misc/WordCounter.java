package com.kmarutyan.interview.misc;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WordCounter {
    Map<String, Long> map = new HashMap<>();
    private String delimPattern = "\\s"; // white space

    public void countWords(String filePath){
        try {
            Files
                .lines(Paths.get(filePath))
                .flatMap(line -> Arrays.stream(line.split(delimPattern)))
                .forEach(word -> map.compute( word, (k, v) -> (v == null) ? 1l : v+1l) );

            map.forEach((word, count) -> System.out.println(String.format("%s %d", word, count)));

        }
        catch(Exception e){
            //rethrow as a unchecked/runtime exception (following scala convention)
            throw new RuntimeException(String.format("Error counting words: %s", e.getMessage()), e);
        }

    }

    public static void main(String... args){
        if(args.length  < 1){
            // @TODO print usage information
            System.out.println(String.format("Expecting at least one argument to script. Exiting...."));
            System.exit(1);
        }

        String file = args[0];
        WordCounter wc = new WordCounter();
        wc.countWords(file);

    }
}
