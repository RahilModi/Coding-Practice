package com.programming.leetcode.Medium;

import java.util.HashMap;
import java.util.Map;

public class FractionToRecurringDecimal {

    public String fractionToDecimal(int numerator, int denominator) {
        if(numerator == 0) return "0";
        StringBuilder sb = new StringBuilder();
        sb.append(((numerator > 0) ^ (denominator > 0)) ? "-" : "");
        Long num = Math.abs((long) numerator);
        Long deno = Math.abs((long) denominator);
        sb.append(num/deno);
        if(num % deno == 0) return sb.toString();
        sb.append(".");
        num %= deno;
        Map<Long, Integer> map = new HashMap<>();
        map.put(num, sb.length());
        while (num != 0){
            num*=10;
            sb.append(num/deno);
            num %=deno;
            if(map.containsKey(num)){
                sb.insert(map.get(num),"(");
                sb.append(")");
                break;
            }else{
                map.put(num, sb.length());
            }
        }
        return sb.toString();

    }

    public static void main(String[] args) {
        FractionToRecurringDecimal obj = new FractionToRecurringDecimal();
        System.out.println(obj.fractionToDecimal(2,4));
        System.out.println(obj.fractionToDecimal(2,1));
        System.out.println(obj.fractionToDecimal(4,333));
        System.out.println(obj.fractionToDecimal(11,3));
    }


}
