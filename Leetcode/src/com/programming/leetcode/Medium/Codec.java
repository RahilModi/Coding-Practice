package com.programming.leetcode.Medium;

import com.sun.tools.javac.jvm.Code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuffer sb = new StringBuffer();
        for(String input : strs){
            sb.append(input.length()).append("/").append(input);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> res =  new ArrayList<>();
        int i = 0;
        while (i < s.length()){
            int indexOfSeparator = s.indexOf("/",i);
            int len = Integer.valueOf(s.substring(i, indexOfSeparator));
            i = indexOfSeparator+len+1;
            res.add(s.substring(indexOfSeparator+1, i));
        }
        return res;
    }



    //separate words by " # " pattern if the "#" is present in the word replace it with "##"...
    public String encodeV1(List<String> strs) {
        return strs.stream()
                .map(s -> s.replace("#", "##") + " # ")
                .collect(Collectors.joining());
    }

    public List<String> decodeV1(String s) {
        List strs = Stream.of(s.split(" # ", -1))
                .map(t -> t.replace("##", "#"))
                .collect(Collectors.toList());
        strs.remove(strs.size() - 1);
        return strs;
    }

    public static void main(String[] args) {
        Codec obj =new Codec();
        String encoded = obj.encode(Arrays.asList("hello","world"));
        System.out.println(encoded);
        System.out.println(obj.decode(encoded));
    }

}
