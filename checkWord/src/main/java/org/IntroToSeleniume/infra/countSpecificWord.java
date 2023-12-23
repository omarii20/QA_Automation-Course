package org.IntroToSeleniume.infra;

public class countSpecificWord {
    public static int countWord(String text, String word) {
        String[] words = text.split("\\s+");

        int count = 0;
        for (String w : words) {
            if (w.contains(word)) {
                count++;
            }
        }
        System.out.println("The word " + word + " was founded," + count + " times.");
        return count;
    }

}