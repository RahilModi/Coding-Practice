package com.programming.leetcode.Medium;


//https://www.geeksforgeeks.org/russian-peasant-multiply-two-numbers-using-bitwise-operators/
public class BitwiseMultiplication {

    /*
    Let the two given numbers be 'a' and 'b'
    1) Initialize result 'res' as 0.
    2) Do following while 'b' is greater than 0
       a) If 'b' is odd, add 'a' to 'res'
       b) Double 'a' and halve 'b'
    3) Return 'res'.


    The value of a*b is same as (a*2)*(b/2) if b is even, otherwise the value is same as ((a*2)*(b/2) + a).
    In the while loop, we keep multiplying ‘a’ with 2 and keep dividing ‘b’ by 2. If ‘b’ becomes odd in loop, we add ‘a’ to ‘res’. When value of ‘b’ becomes 1, the value of ‘res’ + ‘a’, gives us the result.
     */

    public int multiplyTwoNumbersUsingBitWiseOperation(int a, int b){
        int res = 0;
        while (b > 0){
            if((b & 1) != 0) res += a;
            a <<= 1;
            b >>= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        BitwiseMultiplication obj = new BitwiseMultiplication();
        System.out.println(obj.multiplyTwoNumbersUsingBitWiseOperation(17,3));
    }
}
