package com.programming.leetcode.Hard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


//https://leetcode.com/problems/sum-of-distances-in-tree/discuss/130583/C%2B%2BJavaPython-Pre-order-and-Post-order-DFS-O(N)
public class SumOfDistanceInTree {

    List<Set<Integer>> tree;
    int[] count, res;
    int totalNodes;
    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        totalNodes = N;
        tree = new ArrayList<>();
        for(int i = 0; i <N; i++) tree.add(new HashSet<>());
        for(int[] edge : edges){
            tree.get(edge[0]).add(edge[1]);
            tree.get(edge[1]).add(edge[0]);
        }
        count = new int[N];
        res = new int[N];
        postOrderTraversal(0,-1);
        preOrderTraversal(0,-1);

        return res;
    }

    //Post order traversal
    //count[root] = sum(count[i]) + 1
    //res[root] = sum(res[i]) + sum(count[i])
    private void postOrderTraversal(int root, int pre){
        for(int child : tree.get(root)){
            if(child == pre) continue;
            postOrderTraversal(child, root);
            count[root] += count[child];
            res[root] += res[child] + count[child];
        }
        count[root]++;
    }

    //preorder traversal;
    // N-count[i] nodes comes further than root. and count[i] nodes comes closer res[i] = res[parent] - count[i] + N - count[i] ==>
    //res[child] = res[root] + N - 2 * count[root]
    private void preOrderTraversal(int root, int pre){

        for(int child : tree.get(root)){
            if(child == pre) continue;
            res[child] = res[root] - count[child] + totalNodes - count[child];
            preOrderTraversal(child, root);
        }

    }

}
