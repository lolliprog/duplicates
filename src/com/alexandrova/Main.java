package com.alexandrova;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        String inputFile = args[0];
        String outputFile = args[1];
        if (isEmpty(inputFile) || isEmpty(outputFile)) {
            System.out.println("Incorrect parameters!");
            System.out.println("USAGE: java -jar duplicates.jar [input_file_path] [output_file_path]");
        }
        new Duplicates().start(inputFile, outputFile);
    }

    private static boolean isEmpty(String path) {
        return path == null || path.isEmpty();
    }
}
