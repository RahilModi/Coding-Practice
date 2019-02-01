package com.programming.leetcode.Medium;
import java.util.Stack;

public class EliminationGame {

    //O(logN) solution...
    public int lastRemaining(int n) {
        int remaining = n, head, step;
        head = step = 1;
        boolean leftMove = true;
        while(remaining > 1){
            if(leftMove || remaining % 2 == 1)
                head += step;
            remaining = remaining >> 1; // remaining /= 2;
            step = step << 1; //step *= 2;
            leftMove = !leftMove;
        }
        return head;
    }

    //Memory Limit Exceeds...
    public int lastRemainingV1(int n) {
        if(n==1)return 1;
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        for(int i = 2 ; i <= n; i+=2){
            s1.push(i);
        }
        while(s2.isEmpty() && s1.size()>1) {

            while (s2.isEmpty() || !s1.isEmpty()) {
                int popped = s1.pop();
                if (!s1.isEmpty()) {
                    s2.push(s1.pop());
                }
            }
            if(s1.isEmpty() && s2.size()==1) return s2.pop();
            while (s1.isEmpty() || !s2.isEmpty()) {
                int popped = s2.pop();
                if (!s2.isEmpty()) {
                    s1.push(s2.pop());
                }
            }
        }
        return s1.pop();
    }

    public static void main(String[] args) {
        EliminationGame eg = new EliminationGame();
        System.out.println(eg.lastRemaining(2));
    }
}
