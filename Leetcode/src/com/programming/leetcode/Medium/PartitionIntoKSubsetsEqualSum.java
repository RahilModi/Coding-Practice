package com.programming.leetcode.Medium;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PartitionIntoKSubsetsEqualSum {


    //Not correct solution missing some edge cases..
    int globalK, globalTarget;
    public boolean canPartitionKSubsets(int[] nums, int k) {
        globalK = 0;
        int total = 0;
        Map<Integer, Integer> map =new HashMap<>();
        for(int i : nums){
            total += i;
            map.put(i, map.getOrDefault(i,0)+1);
        }
        if(total % k != 0) return false;
        int target = total/k;
        globalTarget = target;
        Arrays.sort(nums);
        int row = nums.length - 1;
        if (nums[row] > target) return false;
        return helper(map,target,k, new HashSet<>());
    }

    public boolean helper(Map<Integer, Integer> map, int target, int k, Set<Integer> visited){
        if(target==0 || map.containsKey(target) && map.get(target)>0){
            if(target!=0) map.put(target, map.get(target)-1);
            globalK++;
            visited.clear();
            if(k == globalK) return true;
            else target = globalTarget;
        }
        for(int key : map.keySet()){
            if(!visited.contains(key) && key < target && map.get(key) > 0){
                map.put(key, map.get(key)-1);
                if(helper(map, target-key, k,visited)) return true;
                map.put(key, map.get(key)+1);
                visited.add(key);
            }
        }
        return false;
    }

    //https://leetcode.com/problems/partition-to-k-equal-sum-subsets/discuss/108730/JavaC%2B%2BStraightforward-dfs-solution
    public boolean canPartitionKSubsetsV1(int[] nums, int k) {
        int total = 0;
        for(int num:nums)total += num;
        if(k <= 0 || total % k != 0)return false;
        boolean[] visited = new boolean[nums.length];
        return canPartition(nums, visited, 0, k, 0, 0, total/k);
    }

    public boolean canPartition(int[] nums, boolean[] visited, int start_index, int k, int cur_sum, int cur_num, int target){
        if(k==1)return true;
        if(cur_sum == target && cur_num>0)return canPartition(nums, visited, 0, k-1, 0, 0, target);
        for(int i = start_index; i<nums.length; i++){
            if(!visited[i] && cur_sum + nums[i] <= target){
                visited[i] = true;
                if(canPartition(nums, visited, i+1, k, cur_sum + nums[i], cur_num++, target))return true;
                visited[i] = false;
            }
        }
        return false;
    }

    //Very classical question.
    //Ref: http://www.geeksforgeeks.org/partition-set-k-subsets-equal-sum/

    public boolean canPartitionKSubsetsV2(int[] A, int k) {
        if (k > A.length) return false;
        int sum = 0;
        for (int num : A) sum += num;
        if (sum % k != 0) return false;
        boolean[] visited = new boolean[A.length];
        Arrays.sort(A);
        return dfs(A, 0, A.length - 1, visited, sum / k, k);
    }

    public boolean dfs(int[] A, int sum, int st, boolean[] visited, int target, int round) {
        if (round == 0) return true;
        if (sum == target && dfs(A, 0, A.length - 1, visited, target, round - 1))
            return true;
        for (int i = st; i >= 0; --i) {
            if (!visited[i] && sum + A[i] <= target) {
                visited[i] = true;
                if (dfs(A, sum + A[i], i - 1, visited, target, round))
                    return true;
                visited[i] = false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        PartitionIntoKSubsetsEqualSum obj = new PartitionIntoKSubsetsEqualSum();
        System.out.println(obj.canPartitionKSubsetsV1(new int[]{129,17,74,57,1421,99,92,285,1276,218,1588,215,369,117,153,22},3));
        System.out.println(obj.canPartitionKSubsetsV1(new int[]{3522,181,521,515,304,123,2512,312,922,407,146,1932,4037,2646,3871,269},5));
        System.out.println(obj.canPartitionKSubsetsV1(new int[]{5,2,5,5,5,5,5,5,5,5,5,5,5,5,5,3},15));
        System.out.println(obj.canPartitionKSubsetsV1(new int[]{1,1,1,1,1,1}, 3));
        System.out.println(obj.canPartitionKSubsetsV1(new int[]{4, 3, 2, 3, 5, 2, 1}, 4));
    }
}
