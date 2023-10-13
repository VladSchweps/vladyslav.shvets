package com.shvets.cipher;


import com.shvets.Commands;
import com.shvets.FileService;

import java.nio.file.Path;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BruteForce {

    private static final int  ALPHABET_LENGTH = 26;

    private final Cipher cipher = new Cipher();
    private final FileService fileService = new FileService();

    public void attacks(Path filePath) {
        String text = fileService.readFile(filePath);
        for (int i = 0; i <= ALPHABET_LENGTH; i++) {
            String encrs = cipher.encrypted(text, i);
            if (!hasConsonantWords(encrs)) {
                int key = ALPHABET_LENGTH - i;
                cipher.decrypted(filePath, key, String.valueOf(Commands.BRUTE_FORCE));
            }
        }

    }

    //Перевіряємо чи є слова в яких одні приголосні, якщо є то шифр не розгаданий
    public static boolean hasConsonantWords(String text) {
        Pattern pattern = Pattern.compile("\\b[bcdfghjklmnpqrstvwxz]+\\b", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            String word = matcher.group();
            if (allConsonants(word)) {
                return true;
            }
        }
        return false;
    }

    public static boolean allConsonants(String word) {
        String vowels = "aeiou";
        word = word.toLowerCase();
        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            if (vowels.indexOf(letter) != -1) {
                return false;
            }
        }
        return true;
    }
}
