package com.programming.leetcode.Medium;

//https://leetcode.com/problems/prime-palindrome/discuss/146798/Search-Palindrome-with-Odd-Digits
public class SmallestPrimePalindrome {

    /*
    All palindrome with even digits is multiple of 11.
    So among them, 11 is the only one prime
    if (8 <= N <= 11) return 11
    O(10000) to check all numbers 1 - 10000.
    isPrime function is O(sqrt(x)) in worst case.
    But only sqrt(N) worst cases for 1 <= x <= N
    In general it's O(logx)
     */
    public int primePalindrome(int N) {
        if(N >= 8 && N<=11) return 11;
        for(int i = 1; i < 100000; i++){
            String s = i + new StringBuilder().append(i).reverse().deleteCharAt(0).toString();
            int val = Integer.parseInt(s);
            if(val >= N && isPrime(val)) return val;
        }
        return  -1;
    }

    //oddest prime is 2 so check separately and all other primes are odd numbers so check only them
    private boolean isPrime(int x){
        if(x <= 2 || x % 2  == 0) return x == 2;
        for(int i = 3 ; i * i <= x ; i+=2){
            if(x % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        SmallestPrimePalindrome obj = new SmallestPrimePalindrome();
        System.out.println(obj.primePalindrome(9));
    }

}
