package com.anagramservice.service;

import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class AnagramStringService {

    public String isAnagram(String firstWord, String secondWord) {
        String firstWordWithoutSpaces = removeSpaces(firstWord);
        String secondWordWithoutSpaces = removeSpaces(secondWord);
        boolean status = checkAnagram(firstWordWithoutSpaces, secondWordWithoutSpaces);

        if (status) {
            return firstWordWithoutSpaces + " and " + secondWordWithoutSpaces + " are anagrams";
        } else {
            return firstWordWithoutSpaces + " and " + secondWordWithoutSpaces + " are not anagrams";
        }
    }

    private String removeSpaces(String word) {
        return word.replaceAll("\\s", "");
    }

    private boolean checkAnagram(String firstWordWithoutSpaces, String secondWordWithoutSpaces) {
        if (firstWordWithoutSpaces.length() != secondWordWithoutSpaces.length()) {
            return false;
        } else {
            char[] lettersOfWord1 = convertToLowercase(firstWordWithoutSpaces).toCharArray();
            char[] lettersOfWord2 = convertToLowercase(secondWordWithoutSpaces).toCharArray();
            Arrays.sort(lettersOfWord1);
            Arrays.sort(lettersOfWord2);
            return Arrays.equals(lettersOfWord1, lettersOfWord2);
        }
    }

    private String convertToLowercase(String word) {
        return word.toLowerCase();
    }
}

