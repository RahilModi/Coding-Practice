package com.programming.leetcode.Medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/binary-trees-with-factors/discuss/126277/Concise-Java-solution-using-HashMap-with-detailed-explanation.-Easily-understand!!!
public class BinaryTreesWithFactors {

    /**sort the array
     * and use HashMap to record each Integer, and the number of trees with that Integer as root
     * (1) each integer A[i] will always have one tree with only itself
     * (2) if A[i] has divisor (a) in the map, and if A[i]/a also in the map
     *     then a can be the root of its left subtree, and A[i]/a can be the root of its right subtree;
     *     the number of such tree is map.get(a) * map.get(A[i]/a)
     * (3) sum over the map
     */
    public int numFactoredBinaryTrees(int[] A) {

        Arrays.sort(A);
        Map<Integer, Long> map = new HashMap<>();
        long count = 1l, mod = (long)1e9+7;
        map.put(A[0], count);
        for(int i = 1; i < A.length; i++){
            count = 1;
            for(int j = 0; j < i; j++){
                if(A[i] % A[j] == 0 && map.containsKey(A[i]/A[j])){
                    count += map.get(A[j]) * map.get(A[i]/A[j]);
                }
            }
            map.put(A[i],count);
        }

        long res = 0l;
        for(long v : map.values()) res = (res+v)%mod;
        return (int) res;
    }

    public static void main(String[] args) {
        BinaryTreesWithFactors obj = new BinaryTreesWithFactors();
        System.out.println(obj.numFactoredBinaryTrees(new int[]{2,4}));
    }

}
