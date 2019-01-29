package com.programming.leetcode.Easy;

import java.util.*;
import java.util.stream.Collectors;

public class PowerfulIntegers {

    public List<Integer> powerfulIntegers(int x, int y, int bound) {

        Set<Integer> res = new HashSet<>();
        for(int i = 0; i < 18 && Math.pow(x,i) <= bound; i++){
            for(int j = 0; j < 18 && Math.pow(y,j) <= bound; j++){
                int sum = (int) (Math.pow(x,i) + Math.pow(y,j));
                if(sum <= bound) res.add(sum);
            }
        }
        return new ArrayList<>(res);
    }

}
