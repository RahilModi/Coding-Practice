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

    public static void main(String[] args) {
        ConvertoBaseNegative2 obj = new ConvertoBaseNegative2();
        System.out.println(obj.baseNeg2(3));
        System.out.println(obj.base2(3));
    }
}
