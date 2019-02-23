package com.programming.leetcode.Hard;

import java.util.*;

public class FileSystem {

    class File{
        boolean isFile = false;
        Map<String, File> childrens = new HashMap<>();
        String content = "";
    }

    File root = null;
    public FileSystem() {
        this.root = new File();
    }

    public List<String> ls(String path) {
        String[] dirs = path.split("/");
        File node = root;
        String name = "";
        List<String> res = new ArrayList<>();
        for(String dir : dirs){
            if(dir.length() == 0) continue;
            if(!node.childrens.containsKey(dir)){
                return res;
            }
            node = node.childrens.get(dir);
            name = dir;
        }
        if(node.isFile) res.add(name);
        else {
            res.addAll(node.childrens.keySet());
            Collections.sort(res);
        }
        return res;
    }

    public void mkdir(String path) {
        getFileNode(path);
    }

    public File getFileNode(String path){
        String[] dirs = path.split("/");
        File node = root;
        for(String dir : dirs){
            if(dir.length() == 0) continue;
            if(!node.childrens.containsKey(dir))
                node.childrens.put(dir, new File());
            node = node.childrens.get(dir);
        }
        return node;
    }

    public void addContentToFile(String filePath, String content) {
        String[] dirs = filePath.split("/");
        File node = getFileNode(filePath);
        node.isFile = true;
        node.content += content;
    }

    public String readContentFromFile(String filePath) {
        return getFileNode(filePath).content;
    }

    public static void main(String[] args) {
        FileSystem obj = new FileSystem();
        obj.ls("/");
        obj.mkdir("/a/b/c");
    }

}
