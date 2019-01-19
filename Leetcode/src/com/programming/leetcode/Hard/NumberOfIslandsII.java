package com.programming.leetcode.Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A 2d grid map of m rows and n columns is initially filled with water. We may perform an addLand operation which turns the water at position (row, col) into a land. Given a list of positions to operate, count the number of islands after each addLand operation. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 * Example:
 * Given m = 3, n = 3, positions = [[0,0], [0,1], [1,2], [2,1]].
 * Initially, the 2d grid grid is filled with water. (Assume 0 represents water and 1 represents land).
 * 0 0 0
 * 0 0 0
 * 0 0 0
 * Operation #1: addLand(0, 0) turns the water at grid[0][0] into a land.
 * 1 0 0
 * 0 0 0   Number of islands = 1
 * 0 0 0
 * Operation #2: addLand(0, 1) turns the water at grid[0][1] into a land.
 * 1 1 0
 * 0 0 0   Number of islands = 1
 * 0 0 0
 * Operation #3: addLand(1, 2) turns the water at grid[1][2] into a land.
 * 1 1 0
 * 0 0 1   Number of islands = 2
 * 0 0 0
 * Operation #4: addLand(2, 1) turns the water at grid[2][1] into a land.
 * 1 1 0
 * 0 0 1   Number of islands = 3
 * 0 1 0
 * We return the result as an array: [1, 1, 2, 3]
 * Challenge:
 * Can you do it in time complexity O(k log mn), where k is the length of the positions?
 */
public class NumberOfIslandsII {

    int[][] directions = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> res = new ArrayList<>();
        int[] nums = new int[m*n];
        int count = 0;
        Arrays.fill(nums, -1);
        for(int[] pos : positions){
            int crt_pos = pos[0] * n + pos[1];
            nums[crt_pos] = crt_pos;
            count++;
            for(int[] dir: directions){
                int x = pos[0]+dir[0];
                int y = pos[1]+dir[1];
                int new_pos = x*n+ y;

                if(x < 0 || x >= m || y < 0 || y >= n || nums[new_pos] == -1) continue;
                int crt_pos_parent = find(nums,crt_pos);
                int new_pos_parent = find(nums, new_pos);
                if(crt_pos_parent != new_pos_parent) {
                    nums[new_pos_parent] = crt_pos_parent;
                    count--;
                }
            }
            res.add(count);
        }
        return res;
    }

    private int find(int [] nums, int i){
        if(i == nums[i]) return i;
        nums[i] = find(nums, nums[i]);
        return nums[i];
    }


    public static void main(String[] args) {
        List<Integer> res = new NumberOfIslandsII().numIslands2(3,3, new int[][]{{0,0}, {0,1}, {1,2}, {2,1}});
        for(int i : res) System.out.println(i);
    }

}
