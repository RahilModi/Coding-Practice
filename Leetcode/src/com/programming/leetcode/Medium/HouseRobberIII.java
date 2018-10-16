package com.programming.leetcode.Medium;

import java.util.HashMap;
import java.util.Map;

public class HouseRobberIII {

    public int rob(TreeNode root) {

        if(root == null) return 0;

        int val = 0;

        if(root.left != null){
            val += rob(root.left.left) + rob(root.left.right);
        }

        if(root.right != null){
            val += rob(root.right.left) + rob(root.right.right);
        }

        return Math.max(val + root.val, rob(root.left)+rob(root.right));

    }


    public int robV2(TreeNode root) {

        return robV2Helper(root, new HashMap<>());

    }

    public int robV2Helper(TreeNode root, Map<TreeNode,Integer> visited){
        if(root == null) return 0;

        if(visited.containsKey(root))return visited.get(root);

        int val = 0;

        if(root.left != null){
            val += robV2Helper(root.left.left,visited) + robV2Helper(root.left.right,visited);
        }

        if(root.right != null){
            val += robV2Helper(root.right.left,visited) + robV2Helper(root.right.right,visited);
        }

        val = Math.max(val + root.val, robV2Helper(root.left,visited)+robV2Helper(root.right,visited));
        visited.put(root, val);
        return val;
    }


    public int robV3(TreeNode root) {

        int[] res = robV3Helper(root);
        return Math.max(res[0],res[1]);

    }

    public int[] robV3Helper(TreeNode root){
        if(root == null) return new int[2];

        int left[] = robV3Helper(root.left);
        int right[] = robV3Helper(root.right);
        int res[] = new int[2];

        res[0] = Math.max(left[0],left[1]) + Math.max(right[0],right[1]);
        res[1] = root.val + left[0] + right[0];

        return res;
    }


}
