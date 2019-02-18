package com.programming.leetcode.Medium;

import java.util.HashMap;
import java.util.Map;


//To win you need two coupons of the same value.... cost for one coupon is 1...
//so find smallest cost to win..you can buy tickets in consecutive manner only...

public class SmallestCouponCostToWin {

    public int twoSameCoupons(int [] coupons){
        int smallestCost = coupons.length + 1;
        Map<Integer, Integer> res = new HashMap<>();
        int crtIndex = 0;
        for(int c: coupons){
            if(res.containsKey(c)){
                smallestCost = Math.min(crtIndex - res.get(c) + 1, smallestCost);
                res.put(c, crtIndex);
            }else{
                res.put(c,crtIndex);
            }
            crtIndex++;
        }
        return smallestCost <= coupons.length ? smallestCost : -1;
    }

    public static void main(String[] args) {
        SmallestCouponCostToWin obj = new SmallestCouponCostToWin();
        System.out.println(obj.twoSameCoupons(new int[]{3,6,1,3}));
        System.out.println(obj.twoSameCoupons(new int[]{5,3,4,2,3,4,5,7}));
    }
}
