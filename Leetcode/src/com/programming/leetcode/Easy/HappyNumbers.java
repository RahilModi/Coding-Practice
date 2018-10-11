package com.programming.leetcode.Easy;

import java.util.HashSet;
import java.util.Set;

public class HappyNumbers {

    public boolean isHappy(int n) {

        Set<Integer> numbers = new HashSet<>();
        int temp = n;
        while(numbers.add(temp)){
            temp =  squaredsumofeachdigit(temp);
            if(temp == 1) return true;
        }
        return false;

    }

    public boolean isHappyV2(int n) {

        int x = n, y = n;
        while(x > 1){
            x = squaredsumofeachdigit(x);
            y = squaredsumofeachdigit(squaredsumofeachdigit(y));
            if(x == 1 || y ==1) return true;
            if(x == y) return false;
        }
        return true;

    }



    private int squaredsumofeachdigit(int n){
        int sum = 0;
        while(n > 0){

            int i = n %10;
            sum += (i*i);
            n/=10;

        }

        return sum;
    }


}
