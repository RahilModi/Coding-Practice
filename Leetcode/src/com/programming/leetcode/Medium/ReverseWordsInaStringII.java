package com.programming.leetcode.Medium;

import java.util.Arrays;

/***
 * Given an input string, reverse the string word by word. A word is defined as a sequence of non-space characters.
 * The input string does not contain leading or trailing spaces and the words are always separated by a single space.
 * For example,
 * Given s = "the sky is blue",
 * return "blue is sky the".
 * Could you do it in-place without allocating extra space?
 * Related problem: Rotate Array
 */
public class ReverseWordsInaStringII {
    public void reverseWords(char[] chars) {
        reverse(chars,0, chars.length-1);
        int n = chars.length-1;
        int j = n;
        for(int i = 0; i <= n; i = j+1){
            j = i;
            while(j<=n && chars[j] != ' '){
                j++;
            }
            reverse(chars,i, j-1);
        }
        System.out.println(Arrays.toString(chars));
    }

    public void reverse(char[] input, int start, int end){
        while(start<=end){
            char temp = input[start];
            input[start]=input[end];
            input[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        ReverseWordsInaStringII obj = new ReverseWordsInaStringII();
        obj.reverseWords("the sky is blue".toCharArray());
    }
}
