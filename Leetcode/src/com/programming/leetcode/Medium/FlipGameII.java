package com.programming.leetcode.Medium;


//Time Complexity  O(n^n) => because recursive calls
//Roughly, the time is n*n*...n, which is O(n^n). The reason is each recursion takes O(n) and there are totally n recursions.
public class FlipGameII {

    boolean canWin(String s){
        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i) == '+' && s.charAt(i) == s.charAt(i-1) && !canWin(s.substring(0,i-1)+"--"+s.substring(i+1))){
                return true;
            }
        }
        return false;
    }


    //We use Backtracking to tackle
    public boolean canWinRecursive(String s) {
        if(s==null||s.length()==0){
            return false;
        }

        return canWinHelper(s.toCharArray());
    }

    boolean canWinHelper(char[] arr){
        for(int i=1; i<arr.length;i++){
            if(arr[i]=='+'&&arr[i-1]=='+'){
                arr[i]='-';
                arr[i-1]='-';
                boolean win = canWinHelper(arr);
                arr[i]='+';
                arr[i-1]='+';
                //if there is a flip which makes the other player lose, the first play wins
                if(!win){
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(new FlipGameII().canWin("++++"));
    }
}
