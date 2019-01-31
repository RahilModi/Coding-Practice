package com.programming.leetcode.Medium;

public class MaximumProductWordLength {

    public int maxProduct(String[] words) {
        if(words == null || words.length == 0) return 0;
        int[] val = new int[words.length];
        for(int i = 0; i< words.length; i++){
            for(int j = 0; j < words[i].length(); j++) {
                val[i] |= (1 << (words[i].charAt(j) - 'a'));
            }
        }

        int max_product = 0;
        for(int i = 0; i < words.length; i++){
            for(int j = i + 1; j < words.length; j++){
                if((val[i] & val[j]) == 0 && words[i].length() * words[j].length() > max_product){
                    max_product = (words[i].length() * words[j].length());
                }
            }
        }

        return max_product;
    }

    public static void main(String[] args) {
        MaximumProductWordLength obj = new MaximumProductWordLength();
        System.out.println(obj.maxProduct(new String[]{"abcw","baz","foo","bar","xtfn","abcdef"}));
    }
}
