package com.programming.leetcode.Easy;

import java.util.*;

public class LongestPalindrome {

    public int longestPalindrome(String s) {

        Map<Character, Integer> charCount = new HashMap<>();
        for(char ch : s.toCharArray()){
            charCount.put(ch, charCount.getOrDefault(ch ,0)+1);
        }
        int maxLength = 0;
        boolean bOddAdded = false;
        for(Character ch : charCount.keySet()){
           if(charCount.get(ch) % 2 == 0){
               maxLength += charCount.get(ch);
           }else {
               if(bOddAdded) {
                   maxLength += (charCount.get(ch) - 1);
               }else{
                   maxLength += charCount.get(ch);
                   bOddAdded = true;
               }
           }
        }

        return maxLength;

    }

    public int longestPalindromeAlternative(String s) {

        int[] charArray = new int[60];
        for(char ch : s.toCharArray()){
            charArray[ch-'A']++;
        }
        int maxLength = 0;
        boolean bOddAdded = false;
        for(int v : charArray){
            if(v % 2 == 0) maxLength += v;
            else{
                if(bOddAdded) maxLength += v - 1;
                else {
                    maxLength += v;
                    bOddAdded = true;
                }
            }
        }
        return maxLength;

    }

    public static void main(String[] args) {
        System.out.println(new LongestPalindrome().longestPalindrome("civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth"));

        System.out.println(new LongestPalindrome().longestPalindromeAlternative("civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth"));

    }


}
