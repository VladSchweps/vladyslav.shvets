package com.shvets;

import com.shvets.cipher.BruteForce;
import com.shvets.cipher.Cipher;

import java.nio.file.Path;

public class Runner {
    Cipher cipher = new Cipher();
    BruteForce brute = new BruteForce();


    public void run(String command, Path filePath) {
        if (command.equalsIgnoreCase(String.valueOf(Commands.BRUTE_FORCE))) {
            brute.attacks(filePath);
        }
        else {
            System.out.println("Invalid data. Please write correct data");
        }

    }

    public void run(String command, Path filePath, int key) {
        if (command.equalsIgnoreCase(String.valueOf(Commands.ENCRYPTED))) {
            cipher.encrypted(filePath, key, String.valueOf(Commands.ENCRYPTED));
        } else if (command.equalsIgnoreCase(String.valueOf(Commands.DECRYPTED))) {
            cipher.decrypted(filePath, key, String.valueOf(Commands.DECRYPTED));
        }

    }
}
