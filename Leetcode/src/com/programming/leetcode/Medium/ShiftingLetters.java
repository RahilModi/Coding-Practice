package com.programming.leetcode.Medium;

public class ShiftingLetters {

    public String shiftingLetters(String S, int[] shifts) {
        if(S == null || S.isEmpty()) return S;
        long[] moves = new long[shifts.length];
        moves[moves.length-1] = shifts[shifts.length-1]%26;
        for(int i = shifts.length-2; i >=0 ;i--){
            moves[i] = (moves[i+1] + shifts[i])%26;
        }
        char[] ch = new char[S.length()];
        for(int i = 0; i < moves.length; i++){
            ch[i] = (char)((S.charAt(i)-'a' + (int)moves[i])%26+'a');
        }
        return String.valueOf(ch);
    }

    //Same approach with better implementation...
    public String shiftingLettersV1(String S, int[] shifts) {
        char[] arr = S.toCharArray();
        int shift = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            shift = (shift + shifts[i]) % 26;
            arr[i] = (char)((arr[i] - 'a' + shift) % 26 + 'a');
        }
        return new String(arr);
    }

    public static void main(String[] args) {
        ShiftingLetters obj = new ShiftingLetters();
        System.out.println(obj.shiftingLetters("ruu",new int[]{26,9,17}));
        System.out.println(obj.shiftingLetters("abc",new int[]{3,5,9}));
    }
}
