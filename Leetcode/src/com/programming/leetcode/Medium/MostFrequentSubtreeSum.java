package com.programming.leetcode.Medium;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class MostFrequentSubtreeSum {

    private Map<Integer, Integer> sumFreq = new HashMap<>();
    private int max_freq = 0;
    public int[] findFrequentTreeSum(TreeNode root) {
        if(root == null) return new int[]{};
        subtreeHelper(root);
        List<Integer> res = new ArrayList<>();
        return sumFreq.keySet()
                .stream()
                .filter(k->sumFreq.get(k)==max_freq)
                .mapToInt(i->i)
                .toArray();
//        Map<Integer,Integer> resultSorted = sumFreq.entrySet()
//                .stream()
//                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
//                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldVal, newVal)->oldVal,LinkedHashMap::new));
//        int prevKey = Integer.MIN_VALUE;
//        for(int key : resultSorted.keySet()){
//            if(prevKey != Integer.MIN_VALUE && resultSorted.get(prevKey) !=resultSorted.get(key)){
//                break;
//            }
//            prevKey = key;
//            res.add(key);
//        }
//        return res.stream().mapToInt(i->i).toArray();
    }

    //postOrder Traversal
    public int subtreeHelper(TreeNode node){
        if(node == null) return 0;
        int leftTreeVal = subtreeHelper(node.left);
        int rightTreeVal = subtreeHelper(node.right);
        int crt_subtree_sum = node.val + leftTreeVal + rightTreeVal;
        int freq = sumFreq.getOrDefault(crt_subtree_sum,0)+1;
        sumFreq.put(crt_subtree_sum, freq);
        max_freq = Math.max(max_freq,freq);
        return crt_subtree_sum;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(-3);
        System.out.println(Arrays.toString(new MostFrequentSubtreeSum().findFrequentTreeSum(root)));
    }

}
