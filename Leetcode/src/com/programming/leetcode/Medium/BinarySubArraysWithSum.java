package com.programming.leetcode.Medium;

public class BinarySubArraysWithSum {

    public int numSubarraysWithSum(int[] A, int S) {

        int[] prefixSum = new int[A.length+1];
        prefixSum[0] =1;
        int crtSum = 0, res = 0;
        for(int i : A){
            crtSum += i;
            if(crtSum >= S){
                res+= prefixSum[crtSum-S];
            }
            prefixSum[crtSum]++;
        }
        return res;
    }

    /*
    Three Pointer approach based on LEETCODE Solution...
    For each j, let's try to count the number of i's that have the subarray [i, j] equal to S.

    It is easy to see these i's form an interval [i_lo, i_hi], and each of i_lo, i_hi are increasing with respect to j. So we can use a "two pointer" style approach.

    Algorithm

    For each j (in increasing order), let's maintain 4 variables:

    sum_lo : the sum of subarray [i_lo, j]
    sum_hi : the sum of subarray [i_hi, j]
    i_lo : the smallest i so that sum_lo <= S
    i_hi : the largest i so that sum_hi <= S
    Then, (provided that sum_lo == S), the number of subarrays ending in j is i_hi - i_lo + 1.

    As an example, with A = [1,0,0,1,0,1] and S = 2, when j = 5, we want i_lo = 1 and i_hi = 3.
     */
    public int numSubArraysWithSumV1(int[] A, int S){
        int iLo, iHi,sumLo, sumHi, ans;
        iLo = iHi = sumLo = sumHi = ans = 0;
        for(int j = 0; j < A.length; j++){
            sumLo += A[j];
            while (iLo < j && sumLo > S) sumLo -= A[iLo++];
            sumHi += A[j];
            while (iHi < j && (sumHi > S || sumHi == S && A[iHi]==0)) sumHi -= A[iHi++];
            if(sumLo == S) ans += iHi - iLo + 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        BinarySubArraysWithSum obj = new BinarySubArraysWithSum();
        System.out.println(obj.numSubarraysWithSum(new int[]{0,1,0,1,0,1},2));
        System.out.println(obj.numSubArraysWithSumV1(new int[]{0,1,0,1,0,1},2));
    }

}
