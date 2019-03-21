package com.programming.leetcode.Hard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindClosestPalindrome {

    public String nearestPalindromic(String n) {
        Long val = Long.valueOf(n);
        if(val <=10 || (val%10 == 0) && (n.charAt(0) == '1' && Long.valueOf(n.substring(1))==0l)) return String.valueOf(val-1);
        if(val ==11 || (val%10 == 1) && (n.charAt(0) == '1' && n.charAt(n.length()-1) == '1' && Long.valueOf(n.substring(1,n.length()-1))==0l)) return String.valueOf(val-2);
        boolean bNotAllNine = false;
        for(char c : n.toCharArray()){
            if(c!='9') {
                bNotAllNine = true;
                break;
            }
        }
        if(!bNotAllNine && val >= 99) return String.valueOf(val+2);

        String palindromeRoot = n.substring(0,(n.length()+1)/2);
        long num = Long.parseLong(palindromeRoot);
        boolean isEvenLength = n.length()%2 ==0;
        Long equalVal = helper(num, isEvenLength);
        Long smallerVal = helper(num-1, isEvenLength);
        Long biggerVal = helper(num+1, isEvenLength);
        long distFromEqual = Math.abs(val - equalVal);
        long distFromSmaller = Math.abs(val - smallerVal);
        long distFromBigger = Math.abs(val - biggerVal);
        long ans = 0l;
        if(distFromEqual == 0) ans = Math.min(distFromBigger, distFromSmaller);
        else ans = Math.min(distFromEqual, Math.min(distFromBigger, distFromSmaller));
        if(distFromEqual == distFromSmaller && ans == distFromEqual) return String.valueOf(smallerVal);

        return ans == distFromEqual ? String.valueOf(equalVal) : ans == distFromSmaller ? String.valueOf(smallerVal) : String.valueOf(biggerVal);
    }

    private Long helper(long num, boolean isEvenLen){
        StringBuilder revesePart = new StringBuilder().append(num).reverse();
        String ans = "";
        if(isEvenLen){
            ans = num+revesePart.toString();
        }else{
            ans = num+revesePart.deleteCharAt(0).toString();
        }
        return Long.parseLong(ans);
    }

    public static void main(String[] args) {
        FindClosestPalindrome obj = new FindClosestPalindrome();
        System.out.println(obj.nearestPalindromic("1837722381"));
    }

}
