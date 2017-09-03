package com.bw.concordance;

import org.junit.Test;

import java.util.Arrays;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * @author Anatoly Chernysh
 */
public class ConcordanceTest {

    public static final String TEXT = "Given an arbitrary text document written in English, write a program that will generate a " +
            "concordance, i.e. an alphabetical list of all word occurrences, labeled with word frequencies. " +
            "Bonus: label each word with the sentence numbers in which each occurrence appeared.";

    public static final WordFrequency[] EXPECTED_WORD_FREQUENCIES_FOR_TEXT = new WordFrequency[34];

    static {
        EXPECTED_WORD_FREQUENCIES_FOR_TEXT[0] = new WordFrequency("a", 2, Arrays.asList(1, 1));
        EXPECTED_WORD_FREQUENCIES_FOR_TEXT[1] = new WordFrequency("all", 1, Arrays.asList(1));
        EXPECTED_WORD_FREQUENCIES_FOR_TEXT[2] = new WordFrequency("alphabetical", 1, Arrays.asList(1));
        EXPECTED_WORD_FREQUENCIES_FOR_TEXT[3] = new WordFrequency("an", 2, Arrays.asList(1, 1));
        EXPECTED_WORD_FREQUENCIES_FOR_TEXT[4] = new WordFrequency("appeared", 1, Arrays.asList(2));
        EXPECTED_WORD_FREQUENCIES_FOR_TEXT[5] = new WordFrequency("arbitrary", 1, Arrays.asList(1));
        EXPECTED_WORD_FREQUENCIES_FOR_TEXT[6] = new WordFrequency("bonus", 1, Arrays.asList(2));
        EXPECTED_WORD_FREQUENCIES_FOR_TEXT[7] = new WordFrequency("concordance", 1, Arrays.asList(1));
        EXPECTED_WORD_FREQUENCIES_FOR_TEXT[8] = new WordFrequency("document", 1, Arrays.asList(1));
        EXPECTED_WORD_FREQUENCIES_FOR_TEXT[9] = new WordFrequency("each", 2, Arrays.asList(2, 2));
        EXPECTED_WORD_FREQUENCIES_FOR_TEXT[10] = new WordFrequency("english", 1, Arrays.asList(1));
        EXPECTED_WORD_FREQUENCIES_FOR_TEXT[11] = new WordFrequency("frequencies", 1, Arrays.asList(1));
        EXPECTED_WORD_FREQUENCIES_FOR_TEXT[12] = new WordFrequency("generate", 1, Arrays.asList(1));
        EXPECTED_WORD_FREQUENCIES_FOR_TEXT[13] = new WordFrequency("given", 1, Arrays.asList(1));
        EXPECTED_WORD_FREQUENCIES_FOR_TEXT[14] = new WordFrequency("i.e.", 1, Arrays.asList(1));
        EXPECTED_WORD_FREQUENCIES_FOR_TEXT[15] = new WordFrequency("in", 2, Arrays.asList(1, 2));
        EXPECTED_WORD_FREQUENCIES_FOR_TEXT[16] = new WordFrequency("label", 1, Arrays.asList(2));
        EXPECTED_WORD_FREQUENCIES_FOR_TEXT[17] = new WordFrequency("labeled", 1, Arrays.asList(1));
        EXPECTED_WORD_FREQUENCIES_FOR_TEXT[18] = new WordFrequency("list", 1, Arrays.asList(1));
        EXPECTED_WORD_FREQUENCIES_FOR_TEXT[19] = new WordFrequency("numbers", 1, Arrays.asList(2));
        EXPECTED_WORD_FREQUENCIES_FOR_TEXT[20] = new WordFrequency("occurrence", 1, Arrays.asList(2));
        EXPECTED_WORD_FREQUENCIES_FOR_TEXT[21] = new WordFrequency("occurrences", 1, Arrays.asList(1));
        EXPECTED_WORD_FREQUENCIES_FOR_TEXT[22] = new WordFrequency("of", 1, Arrays.asList(1));
        EXPECTED_WORD_FREQUENCIES_FOR_TEXT[23] = new WordFrequency("program", 1, Arrays.asList(1));
        EXPECTED_WORD_FREQUENCIES_FOR_TEXT[24] = new WordFrequency("sentence", 1, Arrays.asList(2));
        EXPECTED_WORD_FREQUENCIES_FOR_TEXT[25] = new WordFrequency("text", 1, Arrays.asList(1));
        EXPECTED_WORD_FREQUENCIES_FOR_TEXT[26] = new WordFrequency("that", 1, Arrays.asList(1));
        EXPECTED_WORD_FREQUENCIES_FOR_TEXT[27] = new WordFrequency("the", 1, Arrays.asList(2));
        EXPECTED_WORD_FREQUENCIES_FOR_TEXT[28] = new WordFrequency("which", 1, Arrays.asList(2));
        EXPECTED_WORD_FREQUENCIES_FOR_TEXT[29] = new WordFrequency("will", 1, Arrays.asList(1));
        EXPECTED_WORD_FREQUENCIES_FOR_TEXT[30] = new WordFrequency("with", 2, Arrays.asList(1, 2));
        EXPECTED_WORD_FREQUENCIES_FOR_TEXT[31] = new WordFrequency("word", 3, Arrays.asList(1, 1, 2));
        EXPECTED_WORD_FREQUENCIES_FOR_TEXT[32] = new WordFrequency("write", 1, Arrays.asList(1));
        EXPECTED_WORD_FREQUENCIES_FOR_TEXT[33] = new WordFrequency("written", 1, Arrays.asList(1));
    }

    public static final String TEXT_1 = "Get Grammar Girl's take on i.e. versus e.g. Learn what i.e. and e.g. are Latin for and how to use them correctly.";

    public static final WordFrequency[] EXPECTED_WORD_FREQUENCIES_FOR_TEXT_1 = new WordFrequency[19];

    static {
        EXPECTED_WORD_FREQUENCIES_FOR_TEXT_1[0] = new WordFrequency("and", 2, Arrays.asList(2, 2));
        EXPECTED_WORD_FREQUENCIES_FOR_TEXT_1[1] = new WordFrequency("are", 1, Arrays.asList(2));
        EXPECTED_WORD_FREQUENCIES_FOR_TEXT_1[2] = new WordFrequency("correctly", 1, Arrays.asList(2));
        EXPECTED_WORD_FREQUENCIES_FOR_TEXT_1[3] = new WordFrequency("e.g.", 2, Arrays.asList(1, 2));
        EXPECTED_WORD_FREQUENCIES_FOR_TEXT_1[4] = new WordFrequency("for", 1, Arrays.asList(2));
        EXPECTED_WORD_FREQUENCIES_FOR_TEXT_1[5] = new WordFrequency("get", 1, Arrays.asList(1));
        EXPECTED_WORD_FREQUENCIES_FOR_TEXT_1[6] = new WordFrequency("girls", 1, Arrays.asList(1));
        EXPECTED_WORD_FREQUENCIES_FOR_TEXT_1[7] = new WordFrequency("grammar", 1, Arrays.asList(1));
        EXPECTED_WORD_FREQUENCIES_FOR_TEXT_1[8] = new WordFrequency("how", 1, Arrays.asList(2));
        EXPECTED_WORD_FREQUENCIES_FOR_TEXT_1[9] = new WordFrequency("i.e.", 2, Arrays.asList(1, 2));
        EXPECTED_WORD_FREQUENCIES_FOR_TEXT_1[10] = new WordFrequency("latin", 1, Arrays.asList(2));
        EXPECTED_WORD_FREQUENCIES_FOR_TEXT_1[11] = new WordFrequency("learn", 1, Arrays.asList(2));
        EXPECTED_WORD_FREQUENCIES_FOR_TEXT_1[12] = new WordFrequency("on", 1, Arrays.asList(1));
        EXPECTED_WORD_FREQUENCIES_FOR_TEXT_1[13] = new WordFrequency("take", 1, Arrays.asList(1));
        EXPECTED_WORD_FREQUENCIES_FOR_TEXT_1[14] = new WordFrequency("them", 1, Arrays.asList(2));
        EXPECTED_WORD_FREQUENCIES_FOR_TEXT_1[15] = new WordFrequency("to", 1, Arrays.asList(2));
        EXPECTED_WORD_FREQUENCIES_FOR_TEXT_1[16] = new WordFrequency("use", 1, Arrays.asList(2));
        EXPECTED_WORD_FREQUENCIES_FOR_TEXT_1[17] = new WordFrequency("versus", 1, Arrays.asList(1));
        EXPECTED_WORD_FREQUENCIES_FOR_TEXT_1[18] = new WordFrequency("what", 1, Arrays.asList(2));
    }

    @Test
    public void normalText() {
        Concordance concordance = new Concordance(TEXT);
        concordance.generateConcordance();
        Map<String, WordFrequency> wordFrequencies = concordance.getWordFrequencies();

        assertEquals("Size of word frequency map is not correct", EXPECTED_WORD_FREQUENCIES_FOR_TEXT.length, wordFrequencies.size());

        int i = 0;
        for (Map.Entry<String, WordFrequency> entry : wordFrequencies.entrySet()) {
            assertEquals("Word frequency is not correct", EXPECTED_WORD_FREQUENCIES_FOR_TEXT[i++], entry.getValue());
        }
    }

    @Test
    public void emptyText() {
        Concordance concordance = new Concordance("");
        concordance.generateConcordance();
        Map<String, WordFrequency> wordFrequencies = concordance.getWordFrequencies();
        assertEquals("Size of word frequency map is not correct", 0, wordFrequencies.size());
    }

    @Test
    public void abbreviationsAtTheEndOfSentence() {
        Concordance concordance = new Concordance(TEXT_1);
        concordance.generateConcordance();
        Map<String, WordFrequency> wordFrequencies = concordance.getWordFrequencies();

        assertEquals("Size of word frequency map is not correct", EXPECTED_WORD_FREQUENCIES_FOR_TEXT_1.length, wordFrequencies.size());

        int i = 0;
        for (Map.Entry<String, WordFrequency> entry : wordFrequencies.entrySet()) {
            assertEquals("Word frequency is not correct", EXPECTED_WORD_FREQUENCIES_FOR_TEXT_1[i++], entry.getValue());
        }
    }
}
