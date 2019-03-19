package com.programming.leetcode.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BeautifulArrays {


    //https://leetcode.com/problems/beautiful-array/discuss/186679/C%2B%2BJavaPython-Odd-%2B-Even-Pattern-O(N)
    //For some fixed N, an array A is beautiful if it is a permutation of the integers 1, 2, ..., N, such that:
    //For every i < j, there is no k with i < k < j such that A[k] * 2 = A[i] + A[j].
    public int[] beautifulArray(int N) {
        List<Integer> res = new ArrayList<>();
        res.add(1);
        while (res.size() < N){
            List<Integer> temp = new ArrayList<>();
            for(int i : res) if(2*i-1 <= N)  temp.add(2*i-1);
            for(int i : res) if(2*i <= N) temp.add(2*i);
            res = temp;
        }
        return res.stream().mapToInt(i->i).toArray();
    }

    public int[] beautifulArrayV1(int N) {
        if (N == 1) {
            return new int[]{1};
        } else {
            int left[] = beautifulArrayV1(N / 2 + (N % 2));
            int right[] = beautifulArrayV1(N / 2);

            int ans[] = new int[N];
            int k = 0;
            for (int x: left)   ans[k++] = 2*x - 1;
            for (int x: right)  ans[k++] = 2*x;

            return ans;
        }
    }

    public static void main(String[] args) {
        BeautifulArrays obj = new BeautifulArrays();
        System.out.println(Arrays.toString(obj.beautifulArrayV1(5)));
        System.out.println(Arrays.toString(obj.beautifulArray(5)));
    }
}
