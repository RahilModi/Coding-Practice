package com.programming.leetcode.Medium;

public class CountUniqueDigits {

    /***
     * f(n) => f(2) => 9 * 9
     * f(n) => f(3) => f(2) * 8 => 9 * 9 * 8
     * f(n) => f(4) => 9 * 9 * 8 * 7
     * f(n) => f(5) => 9 * 9 * 8 * 7 * 6
     */


    public int countNumbersWithUniqueDigits(int n) {
        if(n==0)return 1;
        int count = 10, availableNumber = 9, uniqueDigits = 9;
        while(n > 1 && availableNumber > 0){
            uniqueDigits *= availableNumber;
            count += uniqueDigits;
            availableNumber--;
            n--;
        }
        return count;
    }

    public int countNumbersWithUniqueDigits_Using_BackTracking(int n) {
        if(n > 10) countNumbersWithUniqueDigits_Using_BackTracking( 10);
        int count = 1;
        long max = (long) Math.pow(10,n);

        boolean[] digitsUsed = new boolean[10];
        for(int i = 1; i< 10; i++){
            digitsUsed[i] = true;
            count += uniqueCountUtil(i, max, digitsUsed);
            digitsUsed[i] = false;
        }

        return count;
    }

    public int uniqueCountUtil(int cur, long max, boolean[] seen){
        int count = 0;
        if(cur < max){
            count += 1;
        }
        else{
            return count;
        }
        for(int i = 0; i < 10; i++){
            if(!seen[i]) {
                seen[i] = true;
                int new_num = cur * 10 + i;
                count += uniqueCountUtil(new_num,max,seen);
                seen[i] = false;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        CountUniqueDigits obj = new CountUniqueDigits();
        System.out.println(obj.countNumbersWithUniqueDigits(2));
        System.out.println(obj.countNumbersWithUniqueDigits_Using_BackTracking(2));
    }
}
