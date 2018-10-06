package com.programming.leetcode.Easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BuddyString {

    public boolean buddyStrings(String A, String B) {
        if(A.length() !=B.length()) return false;
        if(A.equals(B)){
            Set<Character> temp = new HashSet<>();
            for(char c: A.toCharArray()) temp.add(c);
            return temp.size() < A.length();
        }
        boolean bSwaped = false;
        int prevMisPlacedCharPos = -1;
        boolean bMisPlacedfound = false;
        String temp = A;
        for(int i = 0; i < A.length(); i++){
            if(A.charAt(i)==B.charAt(i)) {
                continue;
            }else if(!bSwaped){
                if(!bMisPlacedfound) {
                    bMisPlacedfound = true;
                    prevMisPlacedCharPos = i;
                }else{
                    bSwaped = true;
                    temp = swapedCharacters(A, prevMisPlacedCharPos, i);
                }
            }else{
                return false;
            }
        }
        return temp.equals(B);

    }

    private String swapedCharacters(String input, int pos1, int pos2){
        char[] temp = input.toCharArray();
        char ch = temp[pos1];
        temp[pos1] = temp[pos2];
        temp[pos2] = ch;
        return new String(temp);
    }

    public boolean buddyStringsV2(String A, String B) {
        if(A.length() !=B.length()) return false;
        if(A.equals(B)){
            Set<Character> temp = new HashSet<>();
            for(char c: A.toCharArray()) temp.add(c);
            return temp.size() < A.length();
        }
        List<Integer> diff = new ArrayList<>();
        for(int i = 0; i < A.length() ; i++){
            if(A.charAt(i) != B.charAt(i)){
                diff.add(i);
            }
        }
        return diff.size() == 2 && A.charAt(diff.get(0)) == B.charAt(diff.get(1)) && A.charAt(diff.get(1)) == B.charAt(diff.get(0));

    }


    public static void main(String[] args) {
        System.out.println(new BuddyString().buddyStrings("ab","ba"));
    }


}
