package com.programming.leetcode.Easy;

public class NumberOfSegmentsInString {

    public int countSegments(String s) {
        boolean bLetterFound=false;
        int counter = 0;
        for(char c: s.trim().toCharArray()){
            if(c==' ' && bLetterFound){
                counter++;
                bLetterFound = false;
            }else if(c != ' '){
                bLetterFound = true;
            }
        }
        if(bLetterFound) counter++;
        return counter;
    }

    public static void main(String[] args) {
        NumberOfSegmentsInString obj = new NumberOfSegmentsInString();
        System.out.println(obj.countSegments("Hello, my name is John"));
    }

}
