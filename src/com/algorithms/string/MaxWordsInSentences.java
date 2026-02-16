package com.algorithms.string;

public class MaxWordsInSentences {
    public int mostWordsFound(String[] sentences) {
        int maxSum=0; int currentSum=0;
        for(int i=0;i<sentences.length;i++){
            String sentence =sentences[i];
            String arr[]= sentence.split(" ");
            for (int j=0;j<arr.length;j++) {
                currentSum++;
                if (currentSum >= maxSum) {
                    maxSum = currentSum;
                }
            }
            currentSum=0;
        }
        return maxSum;
    }
    public static void main(String args[]){
        MaxWordsInSentences solution = new MaxWordsInSentences();
        
        // Test case
        String[] sentences = {
            "alice and bob are playing",
            "this is a test sentence",
            "the quick brown fox jumps over the lazy dog"
        };
        
        int result = solution.mostWordsFound(sentences);
        System.out.println("Maximum words in a sentence: " + result);
    }
}
