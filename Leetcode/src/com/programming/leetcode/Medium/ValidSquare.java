package com.programming.leetcode.Medium;

public class ValidSquare {

    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {

        int[] sidesLength = new int[6];
        sidesLength[0] = distanceBetweenTwoPoints(p1,p2);
        sidesLength[1] = distanceBetweenTwoPoints(p1,p3);
        sidesLength[2] = distanceBetweenTwoPoints(p1,p4);
        sidesLength[3] = distanceBetweenTwoPoints(p2,p3);
        sidesLength[4] = distanceBetweenTwoPoints(p2,p4);
        sidesLength[5] = distanceBetweenTwoPoints(p3,p4);

        int maxSide = Integer.MIN_VALUE;
        for(int i = 0 ; i <sidesLength.length ; i++){
            maxSide = Math.max(sidesLength[i],maxSide);
        }

        int counter = 0, nonLongestCount = 0, lengthOfSide=Integer.MIN_VALUE;
        for(int length : sidesLength){
            if(maxSide == length) counter++;
            else if(lengthOfSide != Integer.MIN_VALUE && length != lengthOfSide){
                return false;
            }else{
                lengthOfSide = length;
                nonLongestCount++;
            }
        }
        if(counter > 2 || nonLongestCount != 4) return false;

        return true;

    }

    private int distanceBetweenTwoPoints(int[] p1, int[] p2){
        return ((p1[0] - p2[0]) * (p1[0] - p2[0])) + ((p1[1] - p2[1]) * (p1[1] - p2[1]));
    }

    public static void main(String[] args) {
        System.out.println(new ValidSquare().validSquare(new int[]{0,0},new int[]{1,2},new int[]{1,0},new int[]{0,1}));
    }
}
