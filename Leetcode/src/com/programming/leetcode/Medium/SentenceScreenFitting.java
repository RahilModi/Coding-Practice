package com.programming.leetcode.Medium;

public class SentenceScreenFitting {

    public int wordsTyping(String[] sentence, int rows, int cols) {
        String s = String.join(" ",sentence)+" ";
        int len = s.length(), start = 0;
        if(len-rows > rows*cols) return 0;
        for(int i = 0; i < rows; i++){
            start += cols;
            if(s.charAt(start % len) == ' '){
                start++;
            }else{
                while (start > 0 && s.charAt((start-1)%len) != ' '){
                    start--;
                }
            }
        }
        return start/len;
    }

    public static void main(String[] args) {
        SentenceScreenFitting obj = new SentenceScreenFitting();
        System.out.println(obj.wordsTyping(new String[]{"hello","world"},4,9));
    }

}
