package com.programming.leetcode.Medium;

import java.util.HashSet;
import java.util.Set;

public class NumofFriendRequests {

    /*
    Some people will make friend requests. The list of their ages is given and ages[i] is the age of the ith person.

    Person A will NOT friend request person B (B != A) if any of the following conditions are true:

    age[B] <= 0.5 * age[A] + 7
    age[B] > age[A]
    age[B] > 100 && age[A] < 100
    Otherwise, A will friend request B.

    Note that if A requests B, B does not necessarily request A.  Also, people will not friend request themselves.

    How many total friend requests are made?
     */
    public int numFriendRequests(int[] A) {
        int[] ages = new int[121];
        for(int a : A) ages[a]++;
        int res = 0;
        for(int i = 0; i < ages.length; i++){
            if(ages[i] > 0){
                for(int j = 0; j < ages.length; j++){
                    if(ages[j] > 0 && isValidRequest(i,j))
                        res += ages[i] * (ages[j] - (i == j ? 1 : 0));
                }
            }
        }
        return res;
    }

    private boolean isValidRequest(int a, int b){
        return !((b <= 0.5*a+7) || b > a || b >100 && a <100);
    }

    public static void main(String[] args) {
        NumofFriendRequests obj = new NumofFriendRequests();
        System.out.println(obj.numFriendRequests(new int[]{16,17,18}));
    }
}
