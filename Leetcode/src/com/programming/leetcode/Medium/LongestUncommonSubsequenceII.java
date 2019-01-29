package com.programming.leetcode.Medium;

import java.util.Arrays;
import java.util.Comparator;

public class LongestUncommonSubsequenceII {

    public int findLUSlength(String[] strs) {
        Arrays.sort(strs, (a,b)->a.length() != b.length() ? a.length() - b.length() : a.compareTo(b));
        for(int i = strs.length-1; i >= 0; i--){
            if(i==0 || !strs[i].equals(strs[i-1])){
                int j = i + 1;
                for(;j<strs.length;j++)
                    if(isSubSequence(strs[i],strs[j]))
                        break;
                if(j == strs.length)
                    return strs[i].length();
            }
        }
        return -1;
    }

    public boolean isSubSequence(String a, String b){
        if(a.equals(b)) return true;
        int j = 0;
        for(int i = 0; i < b.length() && j < a.length(); i++)
            if(a.charAt(j)==b.charAt(i))
                j++;
        return j==a.length();
    }

    public static void main(String[] args) {
        LongestUncommonSubsequenceII obj = new LongestUncommonSubsequenceII();
        String[] arr = new String[]{"aaa","aaa","aa"};
        System.out.println(obj.findLUSlength(arr));
    }

}
