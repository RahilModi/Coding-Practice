package com.programming.leetcode.Medium;

import java.util.Arrays;
import java.util.Random;

public class TestCode {
    private static String name = "static inner";
    private String innerName = " inner  ";
    static class testNested{
       public void printName(){
           System.out.println(name);
       }
    }

    class inner{
        public void printName(){
            System.out.println(innerName);
        }
    }

    int[] getDims(){return new int[new Random().nextInt(10)];}

    double findMin(int[] dims){
        return new Random().nextDouble();
    }
    double minVal = Double.MIN_VALUE;
    public double findMin(){
        int[] dims = getDims();
        //getMin(0, dims, new int[dims.length]);
        return minVal;
    }

    void getMin(int crtVal, int crtIndex, int[] dims, int[] crtParams){
        if(crtIndex == dims.length) {
            System.out.println(Arrays.toString(crtParams));
//            double crtMin = findMin(crtParams);
//            minVal = Math.max(crtMin, minVal);
            return;
        }
//        for(int i = 0; i < dims[crtIndex]; i++){
//            crtParams[i] = i;
//            getMin(crtIndex+1, dims, crtParams);
//        }

        for(int i = crtIndex ;i < dims.length; i++){
            while (crtVal < dims[i]){
                crtParams[i] = crtVal;
                getMin(crtVal, i+1, dims, crtParams);

                crtVal++;
            }
        }
    }


    public static void main(String[] args) {
        TestCode.testNested obj = new TestCode.testNested();
        obj.printName();
        TestCode obj1 = new TestCode();
        obj1.getMin(0,0, new int[]{2,3}, new int[]{0,0});

    }


}
