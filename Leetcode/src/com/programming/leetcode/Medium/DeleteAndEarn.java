package com.programming.leetcode.Medium;

public class DeleteAndEarn {

    //https://leetcode.com/problems/delete-and-earn/discuss/109895/JavaC%2B%2B-Clean-Code-with-Explanation
    public int deleteAndEarn(int[] nums) {

        int max = 0;
        for(int i : nums){
            max = Math.max(max, i);
        }
        int[] count = new int[max+1];

        for(int i : nums){
            count[i] += i;
        }
        int[] takeDP = new int[max+1];
        int[] skipDP = new int[max+1];

        for(int i = 0; i <= max; i++){
            takeDP[i] = (i > 0 ? skipDP[i-1] : 0 ) + count[i];
            skipDP[i] = i == 0 ? 0 : Math.max(takeDP[i-1],skipDP[i-1]);
        }

        return Math.max(takeDP[max],skipDP[max]);

        //Efficient with less space
//        int take, skip;
//        take = skip = 0;
//        for(int i = 0; i < max+1; i++){
//            int take_i = skip + count[i]; // take[i] = skip[i-1] + crt[i]
//            int skip_i = Math.max(skip, take); // skip[i] = Math.max(take[i-1],skip[i-1])
//            take = take_i;
//            skip = skip_i;
//        }

       // return Math.max(take, skip);


    }

    public static void main(String[] args) {
        DeleteAndEarn obj = new DeleteAndEarn();
        System.out.println(obj.deleteAndEarn(new int[]{3,4,2}));
    }

}
