package com.programming.leetcode.Easy;

import java.util.Arrays;
import java.util.stream.IntStream;

public class SumofEvenNumbersAfterQueries {

    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int EvenSum = IntStream.of(A).filter(i -> (i % 2) ==0).sum();
        int [] res = new int[queries.length];
        int index =0;
        for(int[] query : queries){
            int num = A[query[1]];
            if(num % 2 == 0) {
                EvenSum -= num;
            }
            num += query[0];
            A[query[1]] = num;
            if(num % 2 == 0){
                EvenSum += num;
            }
            res[index++] = EvenSum;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] A = {1,2,3,4};
        int[][] queries = new int[][]{{1,0},{-3,1},{-4,0},{2,3}};
        SumofEvenNumbersAfterQueries obj =new SumofEvenNumbersAfterQueries();
        System.out.println(Arrays.toString(obj.sumEvenAfterQueries(A,queries)));
    }
}
