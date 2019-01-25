package com.programming.leetcode.Medium;

public class PhoneDirectory {

    int[] recycle;
    boolean[] book;
    int index=0, next = 0;
    int max_size;

    public PhoneDirectory(int max_size) {
        this.max_size = max_size;
        book = new boolean[max_size];
        recycle = new int[max_size];
    }

    int get(){

        if(next == max_size && index <= 0) return  -1;
        if(index > 0){
            int t = recycle[--index];
            book[t] = true;
            return t;
        }
        book[next] = true;
        return next++;
    }

    boolean check(int num){
        return num >= 0 && num < max_size && !book[num];
    }

    void release(int num){
        if(num >= 0 && num < max_size && book[num]){
            recycle[index] = num;
            index++;
            book[num] = false;
        }
    }


    public static void main(String[] args) {
        PhoneDirectory phoneDirectory = new PhoneDirectory(3);
        System.out.println(phoneDirectory.get());
        System.out.println(phoneDirectory.get());
        System.out.println(phoneDirectory.check(2));
        System.out.println(phoneDirectory.get());
        System.out.println(phoneDirectory.check(2));
        phoneDirectory.release(1);
        System.out.println(phoneDirectory.get());
    }
}
