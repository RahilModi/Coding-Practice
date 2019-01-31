package com.programming.leetcode.Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DuplicatesInFileSystem {

    //Sample Entry in an array: "root/a 1.txt(abcd) 2.txt(efgh)"
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> pathMapping = new HashMap<>();
        for(String path: paths){
            String[] arr = path.split("\\s");
            if(arr.length > 1){
                String dirPath = arr[0];
                for(int i = 1; i < arr.length; i++){
                    String[] temp =  arr[i].split("\\(");
                    String text = temp[1].substring(0,temp[1].length()-1);
                    List<String> t = pathMapping.getOrDefault(text, new ArrayList<>());
                    t.add(dirPath+"/"+temp[0]);
                    pathMapping.put(text,t);
                }
            }
        }
        List<List<String>> res= new ArrayList<>();
        for(Map.Entry<String,List<String >> entry : pathMapping.entrySet()){
            if(entry.getValue().size() > 1){
                res.add(entry.getValue());
            }
        }
        return res;
    }

}
