package com.programming.leetcode.Medium;

public class ConvertoBaseNegative2 {

    public String base2(int N) {
        StringBuilder sb = new StringBuilder();
        while (N!=0){
            sb.insert(0,N&1);
            N >>= 1;
        }
        return sb.toString();
    }

    public String baseNeg2(int N) {
        StringBuilder sb = new StringBuilder();
        while (N!=0){
            sb.insert(0,N&1);
            N = -(N>>1);
        }
        return sb.length() == 0? "0" : sb.toString();
    }

    //https://www.geeksforgeeks.org/convert-number-negative-base-representation/
    public String toNegativeBase(int n, int negBase)
    {
        //  If n is zero then in any base it will be 0 only
        if (n == 0)
            return "0";

        StringBuilder sb = new StringBuilder();
        while (n != 0)
        {
            // Get remainder by negative base, it can be
            // negative also
            int remainder = n % negBase;
            n /= negBase;

            // if remainder is negative, add abs(base) to
            // it and add 1 to n
            if (remainder < 0)
            {
                remainder += (-negBase);
                n += 1;
            }

            // convert remainder to string add into the result
            sb.insert(0,remainder);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        ConvertoBaseNegative2 obj = new ConvertoBaseNegative2();
        System.out.println(obj.baseNeg2(3));
        System.out.println(obj.base2(3));
        System.out.println(obj.toNegativeBase(3,-2));
    }
}
