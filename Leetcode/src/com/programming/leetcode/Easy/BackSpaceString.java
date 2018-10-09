package com.programming.leetcode.Easy;

import java.util.Stack;

public class BackSpaceString {

    public boolean backspaceCompare(String S, String T) {

        if(S == null && T == null) return true;
        if(S == null || T == null) return false;
        if(S.isEmpty() && T.isEmpty()) return true;

        Stack<Character> stackOfS = new Stack<>();
        for(Character ch: S.toCharArray()){
            if(ch =='#'){
                if(stackOfS.empty()) continue;
                stackOfS.pop();
            }
            else stackOfS.push(ch);
        }
        Stack<Character> stackOfT = new Stack<>();
        for(Character ch: T.toCharArray()){
            if(ch =='#') {
                if(stackOfT.empty()) continue;
                stackOfT.pop();
            }
            else stackOfT.push(ch);
        }

        if(stackOfS.size() != stackOfT.size()) return false;
        else{
            while(!stackOfS.empty() && !stackOfT.empty()){
                if(stackOfS.pop() != stackOfT.pop()) return false;
            }
        }

        return true;

    }

    public boolean backspaceCompareV2(String S, String T) {

        if(S == null && T == null) return true;
        if(S == null || T == null) return false;
        if(S.isEmpty() && T.isEmpty()) return true;

        int ptr1 = 0;
        char[] s_array = new char[S.length()];
        for(int i=0; i < S.length(); i++){
            if(S.charAt(i)!='#'){
                s_array[ptr1++] = S.charAt(i);
            }
            else{
                if(i==0 || ptr1 == 0) continue;
                else{
                    s_array[--ptr1] = ' ';
                    if(ptr1 < 0) ptr1 =0;
                }
            }
        }

        String S1 = new StringBuilder().append(s_array).toString().trim();

        char[] t_array = new char[T.length()];
        ptr1 =0;
        for(int i=0; i < T.length(); i++){
            if(T.charAt(i)!='#'){
                t_array[ptr1++] = T.charAt(i);
            }
            else{
                if(i==0 || ptr1 == 0) continue;
                else{
                    t_array[--ptr1] = ' ';
                    if(ptr1 < 0) ptr1 =0;
                }
            }
        }

        String T1 = new StringBuilder().append(t_array).toString().trim();
        return S1.equals(T1);
    }

    public boolean backspaceCompareV3(String S, String T) {

        if(S == null && T == null) return true;
        if(S == null || T == null) return false;
        if(S.isEmpty() && T.isEmpty()) return true;

        int i = S.length() -1, j = T.length()-1;
        int count_in_S=0, count_in_T=0;
        while(i >=0 && j >= 0){
            while(i >=0 && ((S.charAt(i)=='#') || count_in_S > 0)){
                if(S.charAt(i)=='#'){
                    count_in_S++;
                }
                else{
                    count_in_S--;
                }
                i--;
            }
            while(j >=0 && ((T.charAt(j)=='#') || count_in_T > 0)){
                if(S.charAt(j)=='#'){
                    count_in_T++;
                }else{
                    count_in_T--;
                }
                j--;
            }
            if(i<0 && j<0) return  i==j;
            if(S.charAt(i--) != T.charAt(j--)) return false;
        }
        return i==j;
    }

    public boolean backspaceCompareV4(String S, String T) {

        if(S == null && T == null) return true;
        if(S == null || T == null) return false;
        if(S.isEmpty() && T.isEmpty()) return true;

        int i = S.length() - 1, j = T.length() - 1;
        while (true) {
            for (int back = 0; i >= 0 && (back > 0 || S.charAt(i) == '#'); --i)
                back += S.charAt(i) == '#' ? 1 : -1;
            for (int back = 0; j >= 0 && (back > 0 || T.charAt(j) == '#'); --j)
                back += T.charAt(j) == '#' ? 1 : -1;
            if (i >= 0 && j >= 0 && S.charAt(i) == T.charAt(j)) {
                i--; j--;
            } else
                return i == -1 && j == -1;
        }
    }



    public static void main(String[] args) {
        System.out.println(new BackSpaceString().backspaceCompare("a#c", "b"));
        System.out.println(new BackSpaceString().backspaceCompare("a##c", "#a#c"));
        System.out.println(new BackSpaceString().backspaceCompareV2("#a##c","b"));
        System.out.println(new BackSpaceString().backspaceCompareV2("a#c", "b"));
        System.out.println(new BackSpaceString().backspaceCompareV2("a##c", "#a#c"));
        System.out.println(new BackSpaceString().backspaceCompareV3("a#c", "b"));
        System.out.println(new BackSpaceString().backspaceCompareV3("a##c", "#a#c"));
        System.out.println(new BackSpaceString().backspaceCompareV4("a#c", "b"));
        System.out.println(new BackSpaceString().backspaceCompareV4("a##c", "#a#c"));
        System.out.println(new BackSpaceString().backspaceCompareV4("a##c", "aa#c"));
    }

}
