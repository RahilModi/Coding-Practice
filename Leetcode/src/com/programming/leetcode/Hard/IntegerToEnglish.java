package com.programming.leetcode.Hard;

import com.programming.leetcode.Medium.IntToRoman;

import java.util.*;

public class IntegerToEnglish {

    int[] vals = {1000000000,1000000,1000,100,90,80,70,60,50,40,30,20,19,18,17,16,15,14,13,12,11,10,9,8,7,6,5,4,3,2,1,0};
    String[] words = { "Billion", "Million", "Thousand", "Hundred", "Ninety", "Eighty", "Seventy", "Sixty","Fifty","Forty","Thirty","Twenty","Nineteen",
            "Eighteen","Seventeen","Sixteen","Fifteen","Fourteen","Thirteen","Twelve","Eleven","Ten","Nine","Eight","Seven","Six","Five","Four","Three","Two","One","Zero"};

    Map<Integer,String> numWordMapping = new HashMap<>();
    int[] input = new int[vals.length];

    public void populateMap(){
        for(int i =0; i < vals.length; i++){
            numWordMapping.put(vals[i],words[i]);
        }
        System.arraycopy(vals,0, input, 0,vals.length);
        Arrays.sort(input);
    }

    public String numberToWords(int num) {
        populateMap();
        StringBuilder sb = new StringBuilder();
        List<String> words = new ArrayList<>();
        if(numWordMapping.containsKey(num) && num < 100) return numWordMapping.get(num);

        for(int i =0; i< vals.length && num > 0; i++){
            if(num >= vals[i]){
                if(num/vals[i] == 1 && vals[i] >= 100) words.add("One");
                else if(num/vals[i] != 1){
                    divisorUtil(num / vals[i], words, num/vals[i]);
                }
                words.add(numWordMapping.get(vals[i]));
                num %= vals[i];
            }
        }

        for(int i = 0; i < words.size(); i++){
            sb.append(words.get(i));
            if(i < words.size()-1){
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    public void divisorUtil(int num, List<String> resList, int origVal){
        if(num == origVal && String.valueOf(origVal).charAt(0)=='1') {
            resList.add("One");
        }else if(num==1) {
            return;
        }
        if(numWordMapping.containsKey(num)) resList.add(numWordMapping.get(num));
        else {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < vals.length; i++) {
                if (num >= vals[i] && vals[i] != 0) {
                    divisorUtil(num / vals[i], resList, origVal);
                    resList.add(numWordMapping.get(vals[i]));
                    num %= vals[i];
                }
            }
        }
    }

    //Well written
    public String numberToWordsV1(int n) {
        if(n == 0) return "Zero";

        int[] nums = {1000000000,1000000, 1000, 100, 90, 80, 70, 60, 50, 40, 30, 20, 19, 18, 17,16,15,14,13,12,11,10,9,8,7,6,5,4,3,2,1};
        String[] words = {"Billion", "Million", "Thousand", "Hundred", "Ninety", "Eighty", "Seventy", "Sixty", "Fifty", "Forty", "Thirty", "Twenty", "Nineteen", "Eighteen", "Seventeen", "Sixteen", "Fifteen", "Fourteen", "Thirteen", "Twelve", "Eleven", "Ten", "Nine", "Eight", "Seven", "Six", "Five", "Four", "Three", "Two", "One"};

        for(int i = 0; i < nums.length; i++){
            if(nums[i] <= n) {
                int p = n / nums[i]; // Prefix
                int q = n % nums[i]; // Suffix
                if (p > 0)
                    return ((n >= 100 ? numberToWordsV1(p) : "")
                            + " " + words[i] + " " +
                            (q > 0 ? numberToWordsV1(q) : "")).trim();
            }
        }
        return "";
    }

    public static void main(String[] args) {
        IntegerToEnglish obj = new IntegerToEnglish();
        System.out.println(obj.numberToWords(100000));
        System.out.println(obj.numberToWords(76712));
        System.out.println(obj.numberToWords(1234567));
        System.out.println(obj.numberToWords(123));
        System.out.println(obj.numberToWords(1234567891));
        System.out.println(obj.numberToWords(0));
    }
}
