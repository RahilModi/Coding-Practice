package com.programming.GeeksForGeeks.Array;

import java.util.Arrays;

public class RotateArray {

    //Using an extra array
    public void rotateArrayV1(int [] arr, int d){
        int[] temp = new int[d];
        for(int i = 0; i < d; i++) temp[i] = arr[i];
        int index = d;
        for(; index < arr.length; index++) arr[index-d] = arr[index];
        index = arr.length - d;
        for(int i = 0; i < temp.length; i++ ) arr[index + i] = temp[i];

    }

    //Using left rotate by one repeating d times;
    public void rotateArrayV2(int[] arr, int d){
        for(int k = 0; k < d; k++){
            leftRotateByOne(arr);
        }
    }

    private void leftRotateByOne(int[] arr){
        int temp;
        temp =arr[0];
        for(int j = 0; j < arr.length - 1; j++ ){
            arr[j] = arr[j+1];
        }
        arr[arr.length-1] = temp;
        return;
    }

    private int GCD(int a, int b){
        if(b == 0)
            return a;
        else
            return GCD(b, a % b);
    }

    //Using GCD we can rotate a set of number to d pos left
    public void rotateArrayV3(int[] arr, int d){

        int gcd = GCD(arr.length, d);

        for(int i = 0; i < gcd; i++){
            int j =i, temp =arr[i], k;
            while(true){
                k = j +d;
                if( k >= arr.length) k -= arr.length;
                if(k == i) break;
                arr[j] = arr[k];
                j = k;
            }
            arr[j] = temp;
        }
    }

    //Calculate its position after d left rotation using  newIndex = (crtIndex - (numRotation % arr.length ) + arr.length) % arr.length;
    public void rotateArrayV4(int[] arr, int d){
        int crtIndex = 0, newIndex = 0, backVal = arr[crtIndex], newVal = arr[crtIndex],i = 0;
        while(i < arr.length){
            crtIndex = newIndex;
            newIndex = (crtIndex - (d % arr.length ) + arr.length) % arr.length;
            backVal = arr[newIndex];
            arr[newIndex] = newVal;
            newVal = backVal;
            i++;
        }
    }

    private void printAnArray(int[] arr){
        Arrays.stream(arr).forEach(a -> System.out.print(a+", "));
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7};
        int numRotation = 2;

        if(numRotation > arr.length) numRotation = arr.length % numRotation;

        RotateArray obj = new RotateArray();
        obj.rotateArrayV1(arr, numRotation);
        obj.printAnArray(arr);
        obj.rotateArrayV2(arr, numRotation);
        obj.printAnArray(arr);
        obj.rotateArrayV3(arr, numRotation);
        obj.printAnArray(arr);
        obj.rotateArrayV4(arr, numRotation);
        obj.printAnArray(arr);

    }






}
