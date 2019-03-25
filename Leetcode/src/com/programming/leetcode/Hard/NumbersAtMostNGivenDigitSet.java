package com.programming.leetcode.Hard;

public class NumbersAtMostNGivenDigitSet {

    public int atMostNGivenDigitSet(String[] D, int N) {

        String target = String.valueOf(N);
        int len = (N+"").length();
        int count = 0;
        int numDigits = D.length;
        for(int i = 1 ; i < len; i++){
            count += Math.pow(numDigits, i);
        }

        for(int i = 0; i < len; i++){
            boolean hasSameDigit = false;
            for(String d : D) {
                if (d.charAt(0) < target.charAt(i)) count += Math.pow(numDigits, len - i - 1);
                else if(d.charAt(0) == target.charAt(i)){
                    hasSameDigit = true;
                    if(i==target.length()-1)  count+=1;
                }
            }
            if(!hasSameDigit) return count;
        }

        return count;

    }

    public static void main(String[] args) {
        NumbersAtMostNGivenDigitSet obj = new NumbersAtMostNGivenDigitSet();
        System.out.println(obj.atMostNGivenDigitSet(new String[]{"1","3","5","7"},100));
    }


}
