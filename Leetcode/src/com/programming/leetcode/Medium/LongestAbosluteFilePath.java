package com.programming.leetcode.Medium;

import java.util.Stack;

public class LongestAbosluteFilePath {

    public int lengthLongestPath(String input) {
        if(input == null || input.isEmpty()) return 0;
        if(!input.contains(".")) return 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int maxLen, crtLen;
        maxLen = crtLen = 0;
        for(String crt : input.split("\n")){
            int inx = crt.lastIndexOf("\t")+1;
            while (inx+1 < stack.size())stack.pop();
            crtLen = stack.peek()+crt.length()-inx+1;
            stack.push(crtLen);
            if(crt.contains("."))maxLen = Math.max(maxLen, crtLen-1);
        }
        return maxLen;
    }

    public int lengthLongestPathV1(String input) {
        if(input == null || input.isEmpty()) return 0;
        if(!input.contains(".")) return 0;
        String[] paths = input.split("\n");
        int[] stack = new int[paths.length+1];
        int maxLen, crtLen;
        maxLen = crtLen = 0;
        for(String crt : paths){
            int depth = crt.lastIndexOf("\t")+1;
            crtLen = stack[depth+1] = stack[depth]+crt.length()-depth+1;
            if(crt.contains("."))maxLen = Math.max(maxLen, crtLen-1);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        LongestAbosluteFilePath obj = new LongestAbosluteFilePath();
        System.out.println(obj.lengthLongestPath("dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"));
    }


}
