package com.programming.leetcode.Hard;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static java.util.stream.Collectors.*;

//Task was to iterate list of urls, get the article data from the url (function was given)
//Then calculate word frequency across all the articles and print word and its count.
public class CodingTest {

    public Map<String,Long> testMap(String str){
        Map<String, Long> map =  new HashMap<>();
        map.put("Rahil",1L);
        map.put("Parth",2L);
        map.put("Chinmay",1L);
        map.put("Hello",1L);
        return map;
    }

    public static void main(String[] args) {
        CodingTest t = new CodingTest();
        Map<String, Long> res1 =Arrays.stream(new String[]{"data1","data2"})
                    .parallel()
                    .map(str->t.testMap(str))
                    .flatMap(m->m.entrySet().stream())
                    .collect(groupingBy(Map.Entry::getKey, summingLong(Map.Entry::getValue)));


        res1.entrySet().stream().forEach(e -> System.out.println(e.getKey() + "--" + e.getValue()));
    }
}
