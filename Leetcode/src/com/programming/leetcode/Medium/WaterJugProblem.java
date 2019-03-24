package com.programming.leetcode.Medium;

public class WaterJugProblem {

    public boolean canMeasureWater(int x, int y, int z) {
        if( x+y < z ) return false;
        if( x == z || y == z || x + y == z) return true;
        return z % GCD(x,y) == 0;
    }

    private int GCD(int x, int y){
        return x == 0 ? y : GCD(y % x, x);
    }

}
