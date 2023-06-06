package com.anagramservice.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class AnagramStringServiceTest {

    @InjectMocks
    private AnagramStringService classUnderTest;

    @Test
    public void testIsAnagram() {
        String firstWord = "listen";
        String secondWord = "silent";

        String expectedResult = firstWord + " and " + secondWord + " are anagrams";
        String actualResult = classUnderTest.isAnagram(firstWord, secondWord);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testIsNotAnagram() {
        String firstWord = "hello";
        String secondWord = "world";

        String expectedResult = firstWord + " and " + secondWord + " are not anagrams";
        String actualResult = classUnderTest.isAnagram(firstWord, secondWord);

        assertEquals(expectedResult, actualResult);
    }
}