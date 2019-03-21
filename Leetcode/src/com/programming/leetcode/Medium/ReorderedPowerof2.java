package com.programming.leetcode.Medium;

import java.util.Arrays;

public class ReorderedPowerof2 {

    public boolean reorderedPowerOf2(int N) {
        long c = counter(N);
        for(int i = 0; i<32; i++){
            long val =counter(1<<i);
            if(val == c) return true;
        }
        return false;
    }

    private long counter(int N){
        long res = 0;
        for(; N >0; N/=10) res += Math.pow(10, N%10);
        return res;
    }

    public boolean reorderedPowerOf2V1(int N) {
        char[] a1 = (N+"").toCharArray();
        Arrays.sort(a1);
        String s1 = new String(a1);
        String s2="";
        for (int i = 0; i < 32; i++) {
            char[] a2 = ((1 << i)+"").toCharArray();
            Arrays.sort(a2);
            s2 = new String(a2);
            if (s1.equals(s2)) return true;
        }
        return false;
    }

    public boolean reorderedPowerOf2V2(int N) {
        char[] temp = (N+"").toCharArray();
        return helper(temp, 0, new boolean[temp.length]);
    }

    private boolean helper(char[] seq, int crtVal, boolean[] visited){
        if(crtVal!=0 && (crtVal+"").length() == seq.length){
            if(Integer.bitCount(crtVal)==1) return true;
            return false;
        }
        for(int i = 0; i < seq.length; i++){
            if(visited[i]) continue;
            visited[i] = true;
            if(helper(seq, crtVal*10+(seq[i]-'0'), visited)) return true;
            visited[i] = false;
        }
        return false;
    }

    public static void main(String[] args) {
        ReorderedPowerof2 obj = new ReorderedPowerof2();
        System.out.println(obj.reorderedPowerOf2(46));
        System.out.println(obj.reorderedPowerOf2V1(46));
        System.out.println(obj.reorderedPowerOf2V2(46));
    }



}
