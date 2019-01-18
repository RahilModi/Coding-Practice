package com.programming.leetcode.Medium;

import com.sun.tools.javac.jvm.Code;

import java.util.HashMap;
import java.util.Map;

public class CodeWriting {


    public String[] codeWriting(String[] input){
        Map<String, Integer> StringCount = new HashMap<>();
        StringBuilder strBld = new StringBuilder();
        String[] res = new String[input.length];
        int index = 0;
        for(String str: input){
            strBld.setLength(0);
            strBld.append(str);
            int count = 0, prevCount = 0;
            while(StringCount.containsKey(strBld.toString())){
                if(prevCount != 0)
                    StringCount.put(str,prevCount);
                StringBuilder temp = new StringBuilder();
                count = StringCount.get(str);
                count++;
                temp.append("(" + count + ")");
                strBld.setLength(0);
                strBld.append(str);
                strBld.append(temp);
                prevCount = count;
            }
            StringCount.put(str, count);
            StringCount.put(strBld.toString(), 0);
            res[index] = strBld.toString();
            index++;
        }
        return res;
    }

    public static void main(String[] args) {
        for(String s: new CodeWriting().codeWriting(new String[]{"doc","doc","image","doc(1)","doc"})){
            System.out.print(s+", ");
        }
        System.out.println();
        for(String s: new CodeWriting().codeWriting(new String[]{"a(1)",
                "a(6)",
                "a",
                "a",
                "a",
                "a",
                "a",
                "a",
                "a",
                "a",
                "a",
                "a"})){
            System.out.print(s+", ");
        };
    }

}
