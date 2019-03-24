package com.programming.leetcode.Medium;

import java.util.*;

public class BullsCows {

    public String getHint(String secret, String guess) {
        Map<Character, Stack<Integer>> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        int numBulls = 0, numCows = 0;
        for(int i = 0; i < secret.length(); i++) {
            if(secret.charAt(i) == guess.charAt(i)) numBulls++;
            else
            map.computeIfAbsent(secret.charAt(i), k -> new Stack<>()).push(i);
        }

        for(int i = 0; i < guess.length(); i++){
            if(guess.charAt(i) != secret.charAt(i)){
                char c = guess.charAt(i);
                if(map.containsKey(c)){
                    numCows++;
                    map.get(c).pop();
                    if(map.get(c).isEmpty()) map.remove(c);
                }
            }
        }
        return sb.append(numBulls).append('A').append(numCows).append('B').toString();
    }

    public String getHintV1(String secret, String guess) {
        int numbulls, numcows;
        numbulls = numcows = 0;
        int[] count = new int[10];
        for(int i = 0; i < secret.length(); i++) {
            if(secret.charAt(i) == guess.charAt(i)) numbulls++;
            else{
                if(count[secret.charAt(i)-'0'] < 0) numcows++;
                if(count[guess.charAt(i)-'0'] > 0) numcows++;
                count[secret.charAt(i)-'0']++;
                count[guess.charAt(i)-'0']--;
            }
        }
        return numbulls+"A"+numcows+"B";
    }


    public static void main(String[] args) {
        BullsCows obj = new BullsCows();
        System.out.println(obj.getHintV1("1123","0111"));
        System.out.println(obj.getHint("1123","0111"));
    }

}
