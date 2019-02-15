package com.programming.leetcode.Hard;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class RemoveDuplicatesLetter {

    public String removeDuplicateLetters(String s) {
        int[] frq = new int[26];
        for(char c:s.toCharArray()) frq[c-'a']++;
        Set<Character> seen = new HashSet<>();
        Stack<Character> characterStack = new Stack<>();
        for(char c: s.toCharArray()){
            int crtIndex = c-'a';
            frq[crtIndex]--;
            if(seen.contains(c)) continue;
            while(!characterStack.isEmpty() && c <characterStack.peek() && frq[characterStack.peek()-'a']>0){
                seen.remove(characterStack.pop());
            }
            characterStack.push(c);
            seen.add(c);
        }
        StringBuilder sb = new StringBuilder();
        while(!characterStack.isEmpty()) sb.append(characterStack.pop());
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        RemoveDuplicatesLetter obj = new RemoveDuplicatesLetter();
        System.out.println(obj.removeDuplicateLetters("cbacdcbc"));
    }

}
