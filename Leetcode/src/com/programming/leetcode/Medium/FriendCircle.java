package com.programming.leetcode.Medium;

import java.util.HashSet;
import java.util.Set;

public class FriendCircle {

    public int findCircleNum(int[][] M) {

        Set<Integer> visited = new HashSet<>();
        int circles = 0;
        for(int i = 0; i < M.length; i++){
            if(!visited.contains(i)){
                helper(M, visited, i);
                circles++;
            }
        }
        return circles;
    }

    public void helper(int[][] M, Set<Integer> seen, int crt_pos){
        seen.add(crt_pos);
        for(int i = 0; i < M[crt_pos].length; i++){
            if(M[crt_pos][i]==1 && !seen.contains(i)){
                helper(M, seen, i);
            }
        }
    }

    //Union Find Solution:
    static class UnionFind {
        private int count = 0;
        private int[] parent, rank;

        public UnionFind(int n) {
            count = n;
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int p) {
            while (p != parent[p]) {
                parent[p] = parent[parent[p]];    // path compression by halving
                p = parent[p];
            }
            return p;
        }

        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) return;
            if (rank[rootQ] > rank[rootP]) {
                parent[rootP] = rootQ;
            }
            else {
                parent[rootQ] = rootP;
                if (rank[rootP] == rank[rootQ]) {
                    rank[rootP]++;
                }
            }
            count--;
        }

        public int count() {
            return count;
        }
    }

    public int findCircleNumUsingUnionFind(int[][] M) {
        int n = M.length;
        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (M[i][j] == 1) uf.union(i, j);
            }
        }
        return uf.count();
    }

    public static void main(String[] args) {
        FriendCircle obj = new FriendCircle();
        System.out.println(obj.findCircleNumUsingUnionFind(new int[][]{{1,0,0,1},{0,1,1,0},{0,1,1,1},{1,0,1,1}}));

        System.out.println(obj.findCircleNum(new int[][]{{1,0,0,1},{0,1,1,0},{0,1,1,1},{1,0,1,1}}));
    }

}
