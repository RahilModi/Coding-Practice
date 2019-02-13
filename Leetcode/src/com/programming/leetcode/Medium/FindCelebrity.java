package com.programming.leetcode.Medium;

import java.util.Stack;

/****
 *
 * Suppose you are at a party with n people (labeled from 0 to n - 1) and among them, there may exist one celebrity. The definition of a celebrity is that all the other n - 1 people know him/her but he/she does not know any of them.
 * Now you want to find out who the celebrity is or verify that there is not one. The only thing you are allowed to do is to ask questions like: "Hi, A. Do you know B?" to get information of whether A knows B. You need to find out the celebrity (or verify there is not one) by asking as few questions as possible (in the asymptotic sense).
 * You are given a helper function bool knows(a, b) which tells you whether A knows B. Implement a function int findCelebrity(n), your function should minimize the number of calls to knows.
 * Note: There will be exactly one celebrity if he/she is in the party. Return the celebrity's label if there is a celebrity in the party. If there is no celebrity, return -1.
 */

/* The knows API is defined in the parent class Relation.
      ; */

class Relation{
    boolean knows(int a, int b){return  true;} //NOT IMPLEMENTED
}

public class FindCelebrity extends Relation {

    public int findCelebrity(int n) {
        Stack<Integer> stack = new Stack<>();
        for(int i =0; i < n; i++) stack.push(i);
        int a,b;
        a= b= 0;
        while(stack.size() > 1){
            a = stack.pop();
            b = stack.pop();

            if(knows(a,b)){
                stack.push(b); //AS a is not celebrity because he/she knows the B and celebrity does not know anyone
            }else{
                stack.push(a);
            }
        }

        int c = stack.pop();
        for(int i =0; i < n; i++){
            if(i==c) continue;
            if(knows(c,i) || !knows(i,c)) return -1;
        }
        return c;
    }

    public int findCelebrityV1(int n) {
        int start = 0, end = n-1;
        while(start<end){
            if(knows(start,end))
                start++;
            else end--;
        }
        for(int i=0;i<n;i++){
            if(i!=start && (knows(start,i) || !knows(i,start)))
                return -1;
        }
        return start;
    }

}
