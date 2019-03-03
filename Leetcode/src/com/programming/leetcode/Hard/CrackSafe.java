package com.programming.leetcode.Hard;

import java.util.HashSet;
import java.util.Set;

public class CrackSafe {


    //(k!^k^n-1)/k^n
    public String crackSafe(int n, int k) {
        StringBuilder sb = new StringBuilder();
        double total = Math.pow(k,n);
        int i = 0;
        while (i++<n)sb.append('0');
        Set<String> seen = new HashSet<>();
        seen.add(sb.toString());
        dfsHelper(sb, total,seen,n,k);
        return sb.toString();
    }

    public boolean dfsHelper(StringBuilder sb, double target, Set<String> seen, int n, int k){
        System.out.println(sb.toString());
        if(seen.size() == (int)target){
            return true;
        }
        String prev = sb.substring(sb.length()-n+1, sb.length());
        for(int i = 0; i < k; i++){
            String next = prev + ""+ i;
            if(!seen.contains(next)){
                seen.add(next);
                sb.append(i);
                if(dfsHelper(sb,target,seen,n,k)) return true;
                else{
                    seen.remove(next.trim());
                    sb.deleteCharAt(sb.length()-1);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        CrackSafe obj = new CrackSafe();
        System.out.println(obj.crackSafe(1,3));
    }
}
