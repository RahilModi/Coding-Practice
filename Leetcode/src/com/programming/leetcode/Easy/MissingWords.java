package com.programming.leetcode.Easy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//Expedia Problem :
//String input s: "I am using Hackerrank to improve programming"
//String subsequence t: " am Hackerrank improve"
public class MissingWords {

    public List<String> missingWords(String s, String t){
        String[] splitedS = s.split("\\s");
        String[] splitedT = t.split("\\s");
        for(int i = 0, j=0; i < splitedS.length; i++){
            if (j < splitedT.length && splitedS[i].equals(splitedT[j])){
                splitedS[i] = null;
                j++;
            }
        }
        return Arrays.stream(splitedS).filter(i -> i!=null).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        Integer i1= 256;
        Integer i2 =256;
        if(i1 == i2) System.out.println("equals..");
    }
}
