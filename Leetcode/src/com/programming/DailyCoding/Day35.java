package com.programming.DailyCoding;

public class Day35 {

    public char[] sortByRGB(char[] input){
        int ptrR = 0;
        int ptrB = input.length-1;
        for(int i = 0; i <input.length && i <= ptrB; i++){
            char c = input[i];
            if(c == 'R'){
                while (ptrR < input.length && input[ptrR] == 'R') ptrR++;
                if(ptrR < i) {
                    if (input[ptrR] == 'G')
                        swap(input, i, ptrR);
                    else {
                        swap(input, i, ptrR);
                        swap(input, i, ptrB);
                        ptrB--;
                    }
                    ptrR++;
                }

            } else if(c == 'B'){
                while (ptrB >= 0 && input[ptrB] == 'B'){ptrB--;}
                if(i < ptrB) {
                    if (input[ptrB] == 'G')
                        swap(input, i, ptrB);
                    else {
                        swap(input, i, ptrB);
                        swap(input, i, ptrR);
                        ptrR++;
                    }
                    ptrB--;
                }
            }
        }
        return input;
    }



    private void swap(char[] chars, int i ,int j){
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    public static void main(String[] args) {
        Day35 obj = new Day35();
        System.out.println(obj.sortByRGB(new char[]{'G','B','R','R','B','R','G'}));
        System.out.println(obj.sortByRGB(new char[]{'G','G','R','R','R','G'}));
        System.out.println(obj.sortByRGB(new char[]{'B','B','R','R','R','G'}));
        System.out.println(obj.sortByRGB(new char[]{'B','B','B','B','R','G'}));
        System.out.println(obj.sortByRGB(new char[]{'B','B','B','B','R','R'}));
        System.out.println(obj.sortByRGB(new char[]{'B','B','B','B','B','B'}));

        System.out.println(obj.sortByRGB(new char[]{'B','R','B','G','R','B'}));
        System.out.println(obj.sortByRGB(new char[]{'R','B','B','G','R','R', 'G','B'}));
        System.out.println(obj.sortByRGB(new char[]{'G','G','G','G','G','R','R'}));
    }
}
