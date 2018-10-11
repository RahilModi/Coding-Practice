package com.programming.leetcode.Easy;

public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0 )return  "";
        if(strs.length == 1) return strs[0];

        String prefix = strs[0];
        int i = 0;
        while(i < strs[0].length()){
            boolean bfound = true;
            for(int j = 1; j < strs.length && bfound; j++){
                if(strs[j].indexOf(prefix) != 0) {
                    bfound = false;
                }
            }
            if(bfound) break;
            prefix = prefix.substring(0,prefix.length() -1);
            i++;
        }

        return prefix;

    }

    public String longestCommonPrefixV2(String[] strs) {
        if(strs == null || strs.length == 0 )return  "";
        if(strs.length == 1) return strs[0];

        String prefix = strs[0];
        int i = 0;
        StringBuilder bld = new StringBuilder();
        while(i < strs[0].length()) {
            for (int j = 1; j < strs.length; j++) {
                if (i < strs[j].length() && prefix.charAt(i) != strs[j].charAt(i))
                     return bld.toString();
            }
            bld.append(strs[0].charAt(i));
            i++;
        }
        return bld.toString();

    }

    public static void main(String[] args) {
        System.out.println(new LongestCommonPrefix().longestCommonPrefixV2(new String[]{"flower","flow","flight"}));
    }

}
