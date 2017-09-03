package com.bw.concordance;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents word frequency in text.
 *
 * @author Anatoly Chernysh
 */
public class WordFrequency {

    /**
     * Representation of the word.
     */
    private String word;

    /**
     * Frequency of word in text.
     */
    private Integer count;

    /**
     * Sentence numbers in text where the word has appeared.
     */
    private List<Integer> sentences = new ArrayList<Integer>();

    public WordFrequency(String word, Integer sentence) {
        this.word = word;
        this.count = 1;
        this.sentences.add(sentence);
    }

    public WordFrequency(String word, Integer count, List<Integer> sentences) {
        this.word = word;
        this.count = count;
        this.sentences = sentences;
    }

    /**
     * Adds sentence number in which word has been appeared.
     * @param sentence - sentence number in text.
     */
    public void addSentence(Integer sentence) {
        this.sentences.add(sentence);
    }

    /**
     * Increment word frequency.
     */
    public void incrementCount() {
        this.count++;
    }

    public Integer getCount() {
        return count;
    }

    public String getWord() {
        return word;
    }

    public List<Integer> getSentences() {
        return sentences;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WordFrequency)) return false;

        WordFrequency that = (WordFrequency) o;

        if (!count.equals(that.count)) return false;
        if (!sentences.equals(that.sentences)) return false;
        if (!word.equals(that.word)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = word.hashCode();
        result = 31 * result + count.hashCode();
        result = 31 * result + sentences.hashCode();
        return result;
    }

    @Override
    public String toString() {
        String listFormattedSentence = this.sentences.toString();
        String formattedSentence = listFormattedSentence.substring(1, listFormattedSentence.length() - 1).replaceAll("\\s", "");
        return String.format(" %-25s %-25s", word, ("{" + count + ":" + formattedSentence + "}"));
    }
}
