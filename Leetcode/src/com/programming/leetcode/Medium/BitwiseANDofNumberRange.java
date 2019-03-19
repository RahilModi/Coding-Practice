package com.programming.leetcode.Medium;

public class BitwiseANDofNumberRange {

    public int rangeBitwiseAnd(int m, int n) {
        int res = m;
        for(int i = m+1; i <=n && i > 0 && res > 0; i++){
            res &= i;
        }
        return res;
    }

    public int rangeBitwiseAndV1(int m, int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            int p = 1 << i;
            if (n/p == m/p && (n/p)%2 == 1 ) {
                result = result | p;
            }
        }
        return result;
    }

    public int rangeBitwiseAndV2(int m, int n) {
        if(m == 0) return 0;
        int moveFactor = 1;
        while (m!=n){
            m >>=1;
            n >>=1;
            moveFactor <<= 1;
        }
        return m*moveFactor;
    }

    public static void main(String[] args) {
        BitwiseANDofNumberRange obj = new BitwiseANDofNumberRange();
        System.out.println(obj.rangeBitwiseAndV2(5,7));
        System.out.println(obj.rangeBitwiseAnd(2147483646,2147483647));
    }
}
