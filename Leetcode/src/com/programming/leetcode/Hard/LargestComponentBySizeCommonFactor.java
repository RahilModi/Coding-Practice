package com.programming.leetcode.Hard;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/largest-component-size-by-common-factor/discuss/200959/Simplest-Solution-(Union-Find-only)-No-Prime-Calculation
public class LargestComponentBySizeCommonFactor {

    class DSU{

        int[] parents, size;
        int max;
        DSU(int N){
            parents = new int[N];
            size = new int[N];
            for(int i = 0; i < N; i++){
               parents[i] = i;
               size[i] = 1;
            }
            max = 1;
        }

        void union(int a, int b){
            int parentA = find(a);
            int parentB = find(b);
            if(parentA != parentB){
                parents[parentA] = parentB;
                size[parentB] += size[parentA];
                max = Math.max(max, size[parentB]);
            }

        }

        int find(int x){
            if(parents[x] == x) return x;
            return parents[x] = find(parents[x]);
        }

    }

    // Time complexity: O(N* sqrt(Max(A[i])))
    public int largestComponentSize(int[] A) {
        int N = A.length;
        DSU uf = new DSU(N);
        Map<Integer, Integer> map = new HashMap<>();
        int idx = 0;
        for(int n : A){
            for(int j = 2; j*j <= n; j++){
                //total 3 possible factors are n/j, n and j for respective cases add entry in map if not present or perform union operation between
                if(n % j == 0){
                    if(!map.containsKey(j))
                        map.put(j, idx); //till we don't find j as a factor in previous A[i]
                    else
                        uf.union(idx, map.get(j)); //this means any previous A[i] already had j as a factor
                    if(!map.containsKey(n/j))
                        map.put(n/j, idx); //n/j also could be factor
                    else
                        uf.union(idx,map.get(n/j));
                }
            }
            if(!map.containsKey(n))
                map.put(n,idx);  //n could also be factor
            else
                uf.union(idx,map.get(n));
            idx++;
        }
        return uf.max;
    }

    public static void main(String[] args) {
        LargestComponentBySizeCommonFactor obj = new LargestComponentBySizeCommonFactor();
        System.out.println(obj.largestComponentSize(new int[]{2,3,6,7,4,12,21,39}));
    }

}
