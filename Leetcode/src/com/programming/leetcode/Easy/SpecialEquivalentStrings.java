package com.programming.leetcode.Easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SpecialEquivalentStrings {

    public int numSpecialEquivGroups(String[] A) {
        if(A == null || A.length == 0) return 0;

        Set<String> resultGroup = new HashSet<>();
        StringBuilder strBld = new StringBuilder();
        for(String str : A){
            int[] odd = new int[26];
            int[] even = new int[26];
            for(int i = 0; i < str.length() ; i++){
                if((i%2) == 0) even[str.charAt(i)-'a']++;
                else odd[str.charAt(i)-'a']++;
            }

            strBld.append(Arrays.toString(odd)+","+Arrays.toString(even));
            resultGroup.add(strBld.toString());
            strBld.setLength(0);
        }
        return resultGroup.size();

    }

    public static void main(String[] args) {
        System.out.println(new SpecialEquivalentStrings().numSpecialEquivGroups(new String[]{"a","b","c","a","c","c"}));
        System.out.println(new SpecialEquivalentStrings().numSpecialEquivGroups(new String[]{"aa","bb","ab","ba"}));
        System.out.println(new SpecialEquivalentStrings().numSpecialEquivGroups(new String[]{"abc","acb","bac","bca","cab","cba"}));
        System.out.println(new SpecialEquivalentStrings().numSpecialEquivGroups(new String[]{"abcd","cdab","adcb","cbad"}));
    }

}
