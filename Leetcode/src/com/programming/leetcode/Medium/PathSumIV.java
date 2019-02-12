package com.programming.leetcode.Medium;

import java.util.HashMap;
import java.util.Map;

public class PathSumIV {

    //Alternative to below is generate tree using this and apply same dfs on tree to find the total sum;

    Map<Integer, Integer> vals = new HashMap<>();
    int ans = 0;
    public int pathSum(int[] nums) {
        for(int num : nums){
            vals.put(num/10, num%10);
        }

        if(vals.isEmpty()) return ans;
        dfsSum(nums[0]/10, 0);
        return ans;
    }

    public void dfsSum(int node, int sum){
        if(!vals.containsKey(node)) return;
        sum += vals.get(node);

        int depth = node/10;
        int pos = node%10;
        int leftChildPos = (depth+1)*10 + (2 * pos) - 1;
        int rightChildPos = leftChildPos+1;

        if(!vals.containsKey(leftChildPos) && !vals.containsKey(rightChildPos)){
            ans += sum;
        }
        else{
            dfsSum(leftChildPos, sum);
            dfsSum(rightChildPos, sum);
        }

    }

}
