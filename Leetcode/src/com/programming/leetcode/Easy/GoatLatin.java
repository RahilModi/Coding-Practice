package com.programming.leetcode.Easy;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class GoatLatin {

    static final Set<Character> vowels = new HashSet<>();

    {
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');
    }

    public String toGoatLatin(String S) {

        StringBuilder resultStr = new StringBuilder();
        int index = 1;
        String appendLatin = "a", appendMa = "ma";
        for(String word : S.split(" ")){

            StringBuilder strBld = new StringBuilder();
            Character firstCharacter = word.charAt(0);
            if(vowels.contains(firstCharacter)){
                strBld.append(word);
                strBld.append(appendMa);
            }else{
                strBld.append(word.substring(1) + firstCharacter);
                strBld.append(appendMa);
            }
            strBld.append(String.join("", Collections.nCopies(index++,appendLatin)));
            resultStr.append(strBld+" ");
        }
        return resultStr.toString().trim();
    }

    public static void main(String[] args) {
        System.out.println(new GoatLatin().toGoatLatin("I speak Goat Latin"));
    }
}
