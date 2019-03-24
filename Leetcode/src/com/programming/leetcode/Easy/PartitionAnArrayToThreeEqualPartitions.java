package com.programming.leetcode.Easy;

public class PartitionAnArrayToThreeEqualPartitions {

    public boolean canThreePartsEqualSum(int[] A) {
        int totalSum = 0;
        for(int n : A) totalSum += n;
        if(totalSum%3 != 0) return false;
        int target = totalSum/3, crtPart, part1, part2, part3;
        crtPart = part1 = part2 = part3 = 0;
        for(int n : A){
            if(crtPart == 0) {
                part1+=n;
                if(part1 == target) crtPart++;
            }
            else if(crtPart == 1) {
                part2+=n;
                if(part2 == target) crtPart++;
            }
            else{
                part3 += n;
            }
        }
        return part1==part2 && part2 == part3;
    }

    //betterVersion
    public boolean canThreePartsEqualSumV1(int[] A) {
        int totalSum = 0;
        for(int n : A) totalSum += n;
        if(totalSum%3 != 0) return false;
        int target = totalSum/3, totalParts = 0, crtSum = 0;
        for(int n : A){
            crtSum += n;
            if (crtSum == target) {totalParts++; crtSum = 0;}
        }
        return totalParts>=3;
    }

    public static void main(String[] args) {
        PartitionAnArrayToThreeEqualPartitions obj = new PartitionAnArrayToThreeEqualPartitions();
        System.out.println(obj.canThreePartsEqualSum(new int[]{0,2,1,-6,6,-7,9,1,2,0,1}));
        System.out.println(obj.canThreePartsEqualSum(new int[]{0,2,1,-6,6,7,9,-1,2,0,1}));
    }

}
