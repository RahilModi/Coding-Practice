package com.programming.GeeksForGeeks.SlidingWindowTechnique;

import java.util.List;

public class SubarraySumAtmostK {

    public int maxLength(List<Integer> a, int k)  {
        int sum = 0, count = 0, maxCnt = Integer.MIN_VALUE;
        for(int i = 0 ; i < a.size(); i++){
            int crt_elem = a.get(i);
            if((sum + crt_elem) <= k){
                sum += crt_elem;
                count++;
            }else if(sum != 0){
                sum += (crt_elem - a.get(i-count));
            }
            maxCnt = maxCnt < count ? count : maxCnt;
        }
        return maxCnt;
    }
}
