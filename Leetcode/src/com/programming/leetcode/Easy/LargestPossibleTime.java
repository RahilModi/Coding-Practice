package com.programming.leetcode.Easy;

public class LargestPossibleTime {

    public String largestTimeFromDigits(int[] A) {
        String ans = "";
        for(int i = 0; i < 4; i++){
            for(int  j = 0; j < 4; j++){
                for(int k = 0; k < 4; k++){
                    if(i == j || j == k || i == k) continue;
                    String h = A[i]+""+A[j], m = A[k]+""+A[6-i-j-k], t = h+":"+m;
                    if(h.compareTo("24")<0 &&
                        m.compareTo("60") <0 &&
                        ans.compareTo(t)<0) ans = t;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        LargestPossibleTime obj = new LargestPossibleTime();
        System.out.println(obj.largestTimeFromDigits(new int[]{1,4,3,2}));
    }
}
