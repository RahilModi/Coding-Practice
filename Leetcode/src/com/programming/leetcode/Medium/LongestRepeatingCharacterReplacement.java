package com.programming.leetcode.Medium;

public class LongestRepeatingCharacterReplacement {

    public int characterReplacement(String s, int k) {
        int begin,end,maxFreq, maxLen;
        begin = end = maxFreq = maxLen = 0;
        int[] count = new int[26];
        while(end < s.length()){
            maxFreq = Math.max(maxFreq, ++count[s.charAt(end++)-'A']);
            while (end - begin - maxFreq > k) --count[s.charAt(begin++)-'A'];
            maxLen = Math.max(maxLen, end-begin);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        LongestRepeatingCharacterReplacement obj = new LongestRepeatingCharacterReplacement();
        System.out.println(obj.characterReplacement("ABAB",2));
    }

}
