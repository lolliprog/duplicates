package com.alexandrova;

import com.sun.istack.internal.NotNull;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Lenovo on 27.09.2016.
 */
public class Duplicates {
    private Set<String> findDuplicates(@NotNull List<String> entry) {
        Set<String> uniques = new LinkedHashSet<>();
        String temp = "";
        int counter = 0;
        for (String line : entry) {
            if (uniques.add(line)) {
                uniques.remove(temp);
                uniques.add(temp + "[" + ++counter + "]");
                temp = line;
                counter = 0;
            } else {
                counter++;
            }
        }
        return uniques;
    }

    void start(@NotNull String inputFilePath, @NotNull String outputFilePath) throws IOException {
        final File inputFile = new File(inputFilePath);
        final File outputFile = new File(outputFilePath);
        final List<String> lines = Files.readAllLines(inputFile.toPath(), Charset.forName("UTF-8"));
        Collections.sort(lines);
        final Set<String> duplicates = findDuplicates(lines);
        Files.write(outputFile.toPath(), duplicates, Charset.forName("UTF-8"), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
    }
}
