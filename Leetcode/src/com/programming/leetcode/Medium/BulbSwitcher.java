package com.programming.leetcode.Medium;

public class BulbSwitcher {

    //A bulb will be on if it has been toggled odd number of times.
    //so only square number has odd number of divisiors like 36 => 1,2,3,4,6,9,12,18,36  like 12 => 1, 2, 3, 4, 6, 12

    public int numberOfOnBulbs(int n){
        return (int) Math.sqrt(n);
    }
}
