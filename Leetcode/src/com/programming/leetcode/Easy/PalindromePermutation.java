package com.programming.leetcode.Easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PalindromePermutation {

    public boolean canPermutePalindrome(String s) {

        Set<Character> set = new HashSet<>();
        for(char c : s.toCharArray()){
            if(!set.add(c)) set.remove(c);
        }
        return set.size()<=1;
    }

    public boolean canPermutePalindromeV1(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()) map.put(c, map.getOrDefault(c,0)+1);
        boolean isOdd = (s.length()&1) == 0 ? false : true;
        boolean singleOddPos = false;
        for(Character c : map.keySet()){
            if(!isOdd){
                if((map.get(c) % 2) == 1) return false;
            }else{
                if((map.get(c) % 2) == 1 && singleOddPos) return false;
                if((map.get(c) % 2) == 1) singleOddPos = true;
            }
        }
        return true;

    }

    public static void main(String[] args) {
        PalindromePermutation obj = new PalindromePermutation();
        System.out.println(obj.canPermutePalindrome("code"));
        System.out.println(obj.canPermutePalindrome("carerac"));
    }

}
