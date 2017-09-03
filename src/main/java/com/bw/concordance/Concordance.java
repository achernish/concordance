package com.bw.concordance;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.TreeMap;

/**
 * Generates concordance from given text document written in English.
 *
 * @author Anatoly Chernysh
 */
public class Concordance {

    /**
     * Stores word frequencies, where key is English word in lowercase,
     * value is related frequency in text and occurrences in sentences.
     */
    private Map<String, WordFrequency> wordFrequencies = new TreeMap<String, WordFrequency>();

    /**
     * Given text document.
     */
    private String text;

    /**
     * Current read index in text.
     */
    private Integer currentIndex;

    /**
     * Current read sentence in text.
     */
    private Integer currentSentence;

    public Concordance(String text) {
        this.text = text.trim();
        this.currentSentence = 1;
        this.currentIndex = 0;
    }

    public Map<String, WordFrequency> getWordFrequencies() {
        return wordFrequencies;
    }

    private boolean isEndOfWord(char ch) {
        return Character.isWhitespace(ch);
    }

    private boolean isEndOfSentence(char ch) {
        if (ch == '.' && currentIndex < text.length()) {
            char nextChar = text.charAt(currentIndex);
            if (Character.isWhitespace(nextChar) && (currentIndex + 1 < text.length()
                    && Character.isUpperCase(text.charAt(currentIndex + 1)))) {
                return true;
            }
        }

        return false;
    }

    private boolean isWordCharacter(char ch) {
        return (Character.isLetterOrDigit(ch) || (ch == '.' && currentIndex < text.length()));
    }

    private boolean isAbbreviationWithDots(String word) {
        // i.e., e.g., etc
        return (word.contains(".") && word.charAt(word.length() - 1) != '.');
    }

    private void updateWordFrequency(String word) {
        if (word.isEmpty()) {
            return;
        }

        word = word.toLowerCase();

        WordFrequency wordFrequency;
        if (wordFrequencies.containsKey(word)) {
            wordFrequency = wordFrequencies.get(word);
            wordFrequency.incrementCount();
            wordFrequency.addSentence(currentSentence);
        }
        else {
            wordFrequency = new WordFrequency(word, currentSentence);
            wordFrequencies.put(word, wordFrequency);
        }

    }


    public void generateConcordance() {
       StringBuilder currentWord = new StringBuilder();

        while (currentIndex < text.length()) {
            char ch = text.charAt(currentIndex++);

            if (isEndOfWord(ch)) {
                updateWordFrequency(currentWord.toString());
                currentWord.setLength(0);
            }
            if (isEndOfSentence(ch)) {
                if (isAbbreviationWithDots(currentWord.toString())) {
                    updateWordFrequency(currentWord.toString() + ".");
                }
                else {
                    updateWordFrequency(currentWord.toString());
                }

                currentWord.setLength(0);
                currentSentence++;
            }
            else if (isWordCharacter(ch)) {
                currentWord.append(ch);
            }
        }

        updateWordFrequency(currentWord.toString());
    }

    private String getNumberedLetters(int index) {
        StringBuilder numberedLetters = new StringBuilder();

        int remainder = index % 26;
        char letter = (char)((int)'a' + remainder);

        for (int i = index / 26;i >= 0;i--) {
            numberedLetters.append(letter);
        }
        return numberedLetters.toString();
    }

    public void printConcordance() {
        int i = 0;
        for (Map.Entry<String, WordFrequency> entry : wordFrequencies.entrySet()) {
            System.out.println(String.format("%-4s %s", getNumberedLetters(i++) + ".", entry.getValue().toString()));
        }
    }

    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            System.out.println("usage: Concordance 'path to txt file'");
        }
        else {
            String text = new String(Files.readAllBytes(Paths.get(args[0])), StandardCharsets.UTF_8);
            Concordance concordance = new Concordance(text);
            concordance.generateConcordance();
            concordance.printConcordance();
        }
    }
}