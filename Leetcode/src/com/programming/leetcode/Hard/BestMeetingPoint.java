package com.programming.leetcode.Hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
A group of two or more people wants to meet and minimize the total travel distance. You are given a 2D grid of values 0 or 1, where each 1 marks the home of someone in the group. The distance is calculated using Manhattan Distance, where distance(p1, p2) = |p2.x - p1.x| + |p2.y - p1.y|.
For example, given three people living at (0,0), (0,4), and (2,2):
1 - 0 - 0 - 0 - 1
|   |   |   |   |
0 - 0 - 0 - 0 - 0
|   |   |   |   |
0 - 0 - 1 - 0 - 0
The point (0,2) is an ideal meeting point, as the total travel distance of 2+2+2=6 is minimal. So return 6.
Hint:
Try to solve it in one dimension first. How can this solution apply to the two dimension case?
 */
public class BestMeetingPoint {


    //O(nlogn)
    public int minTotalDistanceV1(int[][] grid) {
        List<Integer> xVals = new ArrayList<>();
        List<Integer> yVals = new ArrayList<>();
        for(int i = 0; i < grid.length; i++){
            for(int j =0; j < grid[0].length; j++){
                if(grid[i][j] == 1) {
                    xVals.add(i);
                    yVals.add(j);
                }
            }
        }

        Collections.sort(xVals);
        Collections.sort(xVals);
        int medianValX = xVals.get(xVals.size()>>1);
        int medianValY = yVals.get(yVals.size()>>1);

        int total = 0;
        for (int i = 0; i < xVals.size(); i++) {
            total += Math.abs(xVals.get(i) - medianValX) + Math.abs(yVals.get(i) - medianValY);
        }
        return total;
    }


    public int minTotalDistance(int[][] grid) {
        List<Integer> xVals = new ArrayList<>();
        List<Integer> yVals = new ArrayList<>();
        for(int i = 0; i < grid.length; i++){
            for(int j =0; j < grid[0].length; j++){
                if(grid[i][j] == 1) {
                    xVals.add(i);
                    yVals.add(j);
                }
            }
        }

        int medianValX = quickSelect(xVals, xVals.size()/2 + 1, 0,xVals.size()-1);
        int medianValY = quickSelect(yVals, yVals.size()/2 + 1, 0,yVals.size()-1);

        int total = 0;
        for (int i = 0; i < xVals.size(); i++) {
            total += Math.abs(xVals.get(i) - medianValX) + Math.abs(yVals.get(i) - medianValY);
        }
        return total;
    }

    private int partition(List<Integer> list, int l, int r)
    {
        int x = list.get(r), i = l;
        for (int j = l; j <= r - 1; j++) {
            if (list.get(j) <= x) {
                Collections.swap(list, i, r);
                i++;
            }
        }
        Collections.swap(list, i, r);
        return i;
    }

    public int minTotalDistanceV2(int[][] grid) {

        List<Integer> x = new ArrayList<>();
        List<Integer> y = new ArrayList<>();

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == 1){
                    x.add(i);
                    y.add(j);
                }
            }
        }

        return getMin(x) + getMin(y);

    }

    private int getMin(List<Integer> res){
        int i = 0, j = res.size()-1;
        int ret = 0;
        Collections.sort(res);

        while(i < j){
            ret += res.get(j--) - res.get(i++);
        }
        return ret;
    }

    //QuickSelect take O(n) to finding nth Pos in sorted array from the unsorted array
    private int quickSelect(List<Integer> list, int n, int low, int high){

        int index = partition(list, low, high);

        if (index - low == n - 1)
            return list.get(index);

        if (index - low > n - 1)
            return quickSelect(list, n, low, index - 1);

        return quickSelect(list, n - index + low- 1,index + 1, high);
    }


}
