package com.programming.leetcode.Easy;

import java.util.Arrays;
import java.util.Random;

/****
 * The API: int read4(char *buf) reads 4 characters at a time from a file.
 * The return value is the actual number of characters read. For example, it returns 3 if there is only 3 characters left in the file.
 * By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.
 * Note:
 * The read function will only be called once for each test case.
 */

class Reader4{
    String temp = "abcdefghijklm";
    static int crt_read = 0;
    int read4(char[] buff){
        int length = Math.min(4, temp.length()-crt_read);
        System.arraycopy(temp.toCharArray(),crt_read,buff,0,length);
        crt_read+=length;
        return length;
    }
}
public class ReadNCharactersUsingRead4 extends Reader4{
    char[] tempBuff = new char[4];
    public int read(char[] buf, int n) {
        boolean eof = false;
        int count = 0;
        int readBytes = 0;
        while(!eof && readBytes < n){
            count = read4(tempBuff);
            if(count<4) eof = true;
            count = Math.min(count, n-readBytes);
            System.arraycopy(tempBuff,0,buf,readBytes,count);
            readBytes += count;
        }
        return readBytes;
    }

    public static void main(String[] args) {
        ReadNCharactersUsingRead4 test = new ReadNCharactersUsingRead4();
        char[] t = new char[10];
        System.out.println(test.read(t,9));
        System.out.println(Arrays.toString(t));

    }
}
