package com.programming.leetcode.Hard;

import java.util.*;

public class UniqueLettersString {

    public int uniqueLetterString(String S) {
        long mod = (long) 1e9+7;
        int ans = S.length();
        for(int i = 0; i < S.length(); i++){
            boolean[] letters = new boolean[26];
            int j = i+1;
            int uniqueInSub = 1;
            letters[S.charAt(i)-'A'] = true;
            boolean[] seen = new boolean[26];
            while (j < S.length()){
                if(!letters[S.charAt(j)-'A']){
                    uniqueInSub+=1;
                    letters[S.charAt(j)-'A']=true;
                }else{
                    if(!seen[S.charAt(j)-'A']) {
                        uniqueInSub -= 1;
                    }
                    seen[S.charAt(j) - 'A'] = true;
                }
                ans += uniqueInSub;
                ans %= mod;
                j++;
            }
        }
        return ans;
    }

    public int uniqueLetterStringV1(String S) {
        Map<Character, List<Integer>> index = new HashMap();
        for (int i = 0; i < S.length(); ++i) {
            char c = S.charAt(i);
            index.computeIfAbsent(c, x-> new ArrayList<Integer>()).add(i);
        }

        long ans = 0;
        for (List<Integer> A: index.values()) {
            for (int i = 0; i < A.size(); ++i) {
                long prev = i > 0 ? A.get(i-1) : -1;
                long next = i < A.size() - 1 ? A.get(i+1) : S.length();
                ans += (A.get(i) - prev) * (next - A.get(i));
            }
        }

        return (int) ans % 1_000_000_007;
    }

    public static void main(String[] args) {
        UniqueLettersString obj = new UniqueLettersString();
        System.out.println(obj.uniqueLetterStringV1("ABAB"));
        System.out.println(obj.uniqueLetterString("ABAB"));
    }

}
