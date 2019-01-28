package com.programming.leetcode.Easy;

public class ShortestWordDistance {

    public int shortestDistance(String[] words, String word1, String word2) {
        int p1 = -1, p2 = -1, ans = Integer.MAX_VALUE;
        int index = 0;
        for(String word : words){
            boolean isChanged = false;
            if(word.equals(word1)){
                p1 = index;
                isChanged = true;
            }
            if(word.equals(word2)){
                p2 = index;
                isChanged = true;
            }
            if(p1 != -1 && p2 != -1 && isChanged)
                ans = Math.min(ans, Math.abs(p1-p2));
            index++;
        }
        return ans;
    }

    public static void main(String[] args) {
        ShortestWordDistance obj = new ShortestWordDistance();
        String dict[] = {"practice", "makes", "perfect", "coding", "makes"};
        System.out.println(obj.shortestDistance(dict,"practice","coding"));
        System.out.println(obj.shortestDistance(dict,"practice","makes"));
        System.out.println(obj.shortestDistance(dict,"coding","makes"));
    }
}
