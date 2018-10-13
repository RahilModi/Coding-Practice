package com.programming.leetcode.Easy;

public class FindSmallestGreaterThanTarget {

    public char nextGreatestLetter(char[] letters, char target) {
        int left = 0;
        int right = letters.length;
        while(left < right){
            int mid = left + (right-left)/2;
            if(letters[mid] <= target) left = mid+1;
            else right = mid;
        }
        return letters[left % letters.length];
    }

    public char nextGreatestLetterV2(char[] letters, char target) {
        boolean[] visited = new boolean[letters.length];
        for(char c: letters) visited[c-'a'] = true;

        while(true){
            target++;
            if(target > 'z') target = 'a';
            if(visited[target-'a']) return target;
        }
    }

    public char nextGreatestLetterv3(char[] letters, char target) {
        for(char c : letters) if(c > target) return c;

        return letters[0];
    }

    public static void main(String[] args) {
        System.out.println(new FindSmallestGreaterThanTarget().nextGreatestLetter(new char[]{'c','f','j'},'c'));
    }
}
