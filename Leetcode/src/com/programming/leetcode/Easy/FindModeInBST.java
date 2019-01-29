package com.programming.leetcode.Easy;

import java.util.*;

public class FindModeInBST {

    Map<Integer,Integer> modeMap = new HashMap<>();

    public int[] findMode(TreeNode root) {
        if(root == null) return new int[0];
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = root;
        int modeVal = Integer.MIN_VALUE;
        while(temp != null || !stack.isEmpty()){
            while (temp!=null){
                stack.push(temp);
                temp = temp.left;
            }
            temp =  stack.pop();
            int crtVal = modeMap.getOrDefault(temp.val,0)+1;
            if(modeVal < crtVal){
                modeVal = crtVal;
            }
            modeMap.put(temp.val, crtVal);
            temp = temp.right;
        }

        List<Integer> res = new ArrayList<>();
        for(int key : modeMap.keySet()){
            if(modeMap.get(key) == modeVal)
                res.add(key);
        }
        return res.stream().mapToInt(i->i).toArray();
    }

    Integer prev = null;
    int count = 1;
    int max = 0;
    public int[] findModeV1(TreeNode root) {
        if (root == null) return new int[0];

        List<Integer> list = new ArrayList<>();
        inOrderTraverseV1(root, list);

        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); ++i) res[i] = list.get(i);
        return res;
    }

    private void inOrderTraverseV1(TreeNode root, List<Integer> list) {
        if (root == null) return;
        inOrderTraverseV1(root.left, list);
        if (prev != null) {
            count = root.val == prev ? count+1 : 1;
        }
        if (count > max) {
            max = count;
            list.clear();
            list.add(root.val);
        } else if (count == max) {
            list.add(root.val);
        }
        prev = root.val;
        inOrderTraverseV1(root.right, list);
    }
}
