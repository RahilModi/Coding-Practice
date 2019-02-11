package com.programming.leetcode.Medium;

import com.programming.leetcode.Hard.TrappingRainWater;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPostAndPre {

    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        Map<Integer, Integer> postMap = new HashMap<>();
        for(int i = 0; i < post.length; i++) {
            postMap.put(post[i],i);
        }
        return helper(pre, 0, pre.length-1, post,0,post.length-1, postMap);
    }

    public TreeNode helper(int[] pre, int preStart, int preEnd, int[] post, int postStart, int postEnd, Map<Integer,Integer> postCache){
        if(preStart > preEnd) return null;
        if (preStart == preEnd) return new TreeNode(pre[preStart]);
        TreeNode treeNode = new TreeNode(pre[preStart]);

        int leftTreeStart = preStart+1;
        int postOrderPos = postCache.get(pre[leftTreeStart]);
        int leftSubTreeEndInPre = leftTreeStart + postOrderPos - postStart;

        treeNode.left = helper(pre, leftTreeStart, leftSubTreeEndInPre, post, postStart, postOrderPos, postCache);
        treeNode.right = helper(pre, leftSubTreeEndInPre+1, preEnd, post, postOrderPos+1, postEnd-1, postCache);

        return treeNode;
    }


}
