package com.programming.leetcode.Medium;

import java.util.Stack;

public class SimplifyPath {

    public String simplifyPath(String path) {
        String[] hops = path.split("\\/");
        Stack<String> stack = new Stack<>();
        for(int i = 0; i < hops.length; i++){
            if(hops[i].equals("") || hops[i].equals(".")) continue;
            else if(hops[i].equals("..")) {
                if(!stack.isEmpty()) stack.pop();
            }
            else stack.push(hops[i]);
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()){
            sb.insert(0, stack.pop());
            sb.insert(0,"/");
        }
        return sb.length()==0 ? "/" : sb.toString();
    }

    public static void main(String[] args) {
        SimplifyPath obj = new SimplifyPath();
        System.out.println(obj.simplifyPath("/../"));
        System.out.println(obj.simplifyPath("/a/./b/../../c/"));
    }

}
