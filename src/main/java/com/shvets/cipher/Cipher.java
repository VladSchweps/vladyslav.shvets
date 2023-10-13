package com.shvets.cipher;

import com.shvets.FileService;

import java.nio.file.Path;

public class Cipher {
    private final FileService fileService = new FileService();

    private static final int ALPHABET_LENGTH = 26;

    public void encrypted(Path filePath, int key, String anotation) {
        String text = fileService.readFile(filePath);
        StringBuilder encryptedText = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char currentChar = text.charAt(i);
            if (Character.isLetter(currentChar)) {
                //Вибираємо базове кодування, з великої або з малої літери
                char base = Character.isLowerCase(currentChar) ? 'a' : 'A';
                /*Додаємо закодований символ з врахуванням зміщення,
                якщо є вихід за розмір англійького алфавіту*/
                encryptedText.append((char) (((currentChar - base + key)
                        % ALPHABET_LENGTH + ALPHABET_LENGTH)
                        % ALPHABET_LENGTH + base));
            } else {
                encryptedText.append(currentChar);
            }
        }
        fileService.writeToFile(fileService.addFileNameAnnotation(filePath, anotation)
                , encryptedText.toString());
    }

    public void decrypted(Path filePath, int key, String anotation) {
        encrypted(filePath, -key, anotation);
    }

    public String encrypted(String text, int key) {
        StringBuilder encryptedText = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char currentChar = text.charAt(i);
            if (Character.isLetter(currentChar)) {
                //Вибираємо базове кодування, з великої або з малої літери
                char base = Character.isLowerCase(currentChar) ? 'a' : 'A';
                /*Додаємо закодований символ з врахуванням зміщення,
                якщо є вихід за розмір англійького алфавіту*/
                encryptedText.append((char) (((currentChar - base + key)
                        % ALPHABET_LENGTH + ALPHABET_LENGTH)
                        % ALPHABET_LENGTH + base));
            } else {
                encryptedText.append(currentChar);
            }

        }
        return encryptedText.toString();
    }
}
