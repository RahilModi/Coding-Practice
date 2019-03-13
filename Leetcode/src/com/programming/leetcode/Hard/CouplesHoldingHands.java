package com.programming.leetcode.Hard;

public class CouplesHoldingHands {

    private class DSU{
        public int[] parents;
        public int count;
        DSU(int n){
            parents = new int[n];
            count = n;
            for(int i = 0; i < n; i++){
                parents[i] = i;
            }
        }

        private void union(int a, int b){
            int parentA = find(a);
            int parentB = find(b);
            if(parentA != parentB){
                parents[parentA] = parentB;
                count--;
            }
        }

        private int find(int a){
            if(a == parents[a]) return parents[a];
            parents[a] = find(parents[a]);
            return parents[a];
        }
    }

    public int minSwapsCouples(int[] row) {
        int n = row.length/2;
        DSU obj = new DSU(n);
        for(int i = 0; i < n; i++){
            obj.union(row[2*i]/2,row[2*i+1]/2);
        }
        return n-obj.count;
    }

    public static void main(String[] args) {
        CouplesHoldingHands obj = new CouplesHoldingHands();
        System.out.println(obj.minSwapsCouples(new int[]{0,2,1,3}));
    }

}
