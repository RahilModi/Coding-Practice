package com.programming.leetcode.Hard;


import java.util.Arrays;

class Reader4{
    String temp = "abcdefghijklmnopqrs";
    static int crt_read = 0;
    int read4(char[] buff){
        int length = Math.min(4, temp.length()-crt_read);
        System.arraycopy(temp.toCharArray(),crt_read,buff,0,length);
        crt_read+=length;
        return length;
    }
}

public class ReadNCharactersUsingRead4II extends Reader4 {
    int readPointer = 0, count = 0;
    char[] tempBuffer = new char[4];

    public int read(char[] buf, int n) {
        int index = 0;
        while(index < n ){
            if(readPointer == 0) {
                count = read4(tempBuffer);
            }
            if(count==0) break;
            while (index < n && readPointer < count){
                buf[index++] = tempBuffer[readPointer++];
            }
            if(readPointer == count) readPointer = 0;
        }
        return index;
    }

    public static void main(String[] args) {
        ReadNCharactersUsingRead4II obj = new ReadNCharactersUsingRead4II();
        char[] buffer = new char[12];
        System.out.println(obj.read(buffer, 2));
        System.out.println(Arrays.toString(buffer));
        System.out.println(obj.read(buffer, 5));
        System.out.println(Arrays.toString(buffer));
        System.out.println(obj.read(buffer, 3));
        System.out.println(Arrays.toString(buffer));
        System.out.println(obj.read(buffer,8));
        System.out.println(Arrays.toString(buffer));
    }
}
