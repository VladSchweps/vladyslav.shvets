package com.shvets;

import java.nio.file.Path;
import java.nio.file.Paths;


public class Main {


    public static void main(String[] args) {
        String command = args[0];
        Path filePath = Paths.get(args[1]);
        Runner runner = new Runner();
        if (args.length == 2) {
            runner.run(command, filePath);
        } else if (args.length == 3) {
            int key = Integer.parseInt(args[2]);
            runner.run(command, filePath, key);
        } else {
            System.out.println("Problem with arguments, please write valid data");
            throw new IllegalArgumentException("Problem with arguments, please write valid data");
        }
    }
}

