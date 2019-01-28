package com.programming.leetcode.Medium;

/***
 * This is a follow up of Shortest Word Distance. The only difference is now word1 could be the same as word2.
 * Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.
 * word1 and word2 may be the same and they represent two individual words in the list.
 * For example,
 * Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
 * Given word1 = "makes", word2 = "coding", return 1. Given word1 = "makes", word2 = "makes", return 3.
 * Note:
 * You may assume word1 and word2 are both in the list.
 */
public class ShortestWordDistanceIII {

    public int shortestWordDistance(String[] words, String word1, String word2) {
        if(word1.equals(word2)){
            return distanceBetweenTwoSameWord(words, word1);
        }else{
            return distanceBetweenTwoDifferentWords(words,word1,word2);
        }
    }

    int distanceBetweenTwoSameWord(String[] words, String word1){
        int p1 = -1, i = 0;
        for(; i < words.length ; i++){
            if(words[i].equals(word1)){
                if(p1 == -1) p1 = i;
                else break;
            }
        }
        return i - p1;
    }

    int distanceBetweenTwoDifferentWords(String[] words, String word1, String word2){
        int p1 = -1, p2 = -1, min_dis = Integer.MAX_VALUE;
        boolean bNewPosFound;
        for(int i = 0 ; i < words.length ; i++){
            bNewPosFound = false;
            if(words[i].equals(word1)){
                p1 = i;
                bNewPosFound = true;
            }
            if(words[i].equals(word2)){
                p2 = i;
                bNewPosFound = true;
            }
            if(bNewPosFound && p1 != -1 && p2 != -1){
                min_dis = Math.min(Math.abs(p1-p2),min_dis);
            }

        }
        return min_dis;
    }
}
