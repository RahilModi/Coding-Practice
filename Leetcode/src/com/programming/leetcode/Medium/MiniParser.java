package com.programming.leetcode.Medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;



public class MiniParser {

     class NestedInteger {
        //      // Constructor initializes an empty nested list.
        public NestedInteger(){};
        //
//            // Constructor initializes a single integer.
        public NestedInteger(int value){};

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger(){return true;};

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger(){return new Random().nextInt(10000);};

        // Set this NestedInteger to hold a single integer.
        public void setInteger(int value) {};

        // Set this NestedInteger to hold a nested list and adds a nested integer to it.
        public void add(NestedInteger ni){};

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList(){return  new ArrayList<>();}
    };

    public NestedInteger deserialize(String s) {
         if(s.isEmpty()) return null;
         if(!s.startsWith("[")) return new NestedInteger(Integer.valueOf(s));
         int l = 0, r = 0;
         Stack<NestedInteger> stack = new Stack<>();
         NestedInteger crt = null;
         char ch;
         for(;r < s.length(); r++){
             ch = s.charAt(r);
             if(ch == '['){
                 if(crt != null){
                    stack.push(crt);
                 }
                 crt = new NestedInteger();
                 l = r+1;
             }else if(ch == ']'){
                 String num = s.substring(l,r);
                 if(!num.isEmpty()){
                     crt.add(new NestedInteger(Integer.valueOf(num)));
                 }
                 if(!stack.isEmpty()){
                     NestedInteger last = stack.pop();
                     last.add(crt);
                     crt = last;
                 }
                l = r+1;
             }else if(ch == ','){
                if(s.charAt(r-1) != ']'){
                    crt.add(new NestedInteger(Integer.valueOf(s.substring(l,r))));
                }
                 l = r+1;
             }
         }
         return crt;

    }
}
