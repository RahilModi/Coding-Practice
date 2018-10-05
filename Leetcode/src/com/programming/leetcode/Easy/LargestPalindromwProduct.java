package com.programming.leetcode.Easy;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LargestPalindromwProduct {

    private long getpalindrome(long num){
        return Long.parseLong(num + new StringBuilder().append(num).reverse().toString());
    }

    public int largestPalindrome(int n) {
        if(n==1) return 9;

        int upperBound = (int) Math.pow(10, n) -1 ;
        int lowerBound = (int) Math.pow(10, n -1) ;

        long maxNumber = (long)upperBound * (long)upperBound;

        int firstHalf = (int) (maxNumber / (long)Math.pow(10, n));

        boolean bFound = false;
        long palindrome = 0;

        while(!bFound) {

            palindrome = getpalindrome(firstHalf);

            for (long i = upperBound; i > lowerBound ; i--) {
                if( palindrome / i > maxNumber || i * i < palindrome ) {
                    break;
                }
                if( palindrome % i == 0 ){
                    bFound=true;
                    break;
                }
            }
            firstHalf--;
        }
        //System.out.println(palindrome);
        return (int) (palindrome % 1337);

    }

    public static void main(String[] args) {
        System.out.println(new LargestPalindromwProduct().largestPalindrome(5));
    }

}
