package com.programming.leetcode.Easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class NArrayPostOrder {
    static class Node {
        public int val;
        public List<NArrayPostOrder.Node> children;

        public Node() {}

        public Node(int _val,List<NArrayPostOrder.Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public List<Integer> postorder(NArrayPostOrder.Node root) {

        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        Stack<NArrayPostOrder.Node> stack = new Stack<>();
        Stack<NArrayPostOrder.Node> stack1 = new Stack<>();
        stack.push(root);
        while(!stack.empty()){
            NArrayPostOrder.Node n = stack.pop();
            int childrenSize = n.children.size();
            for(int i = 0 ; i < childrenSize; i++ ){
                stack.push(n.children.get(i));
            }
            stack1.push(n);
        }
        while(!stack1.empty()) result.add(stack1.pop().val);

        return result;
    }

    public List<Integer> postorderV4(NArrayPostOrder.Node root) {

        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        Stack<NArrayPostOrder.Node> stack = new Stack<>();
        stack.push(root);
        while(!stack.empty()){
            NArrayPostOrder.Node n = stack.pop();
            int childrenSize = n.children.size();
            result.add(n.val);
            for(Node child: n.children){
                stack.push(child);
            }
        }
        Collections.reverse(result);
        return result;
    }

    List<Integer> res = new ArrayList<>();
    public List<Integer> postorderV2(NArrayPostOrder.Node root) {

        if(root == null) return res;

        for(NArrayPostOrder.Node n: root.children){
            postorderV2(n);
        }
        res.add(root.val);

        return res;
    }

    public List<Integer> postorderV3(NArrayPostOrder.Node root){
        return travarsalHelper(root, new ArrayList<>());
    }

    private List<Integer> travarsalHelper(NArrayPostOrder.Node root, List<Integer> res){
        if(root == null) return res;


        for(NArrayPostOrder.Node n : root.children){
            travarsalHelper(n, res);
        }
        res.add(root.val);
        return res;
    }



    public static void main(String[] args) {
        NArrayPostOrder.Node n = new NArrayPostOrder.Node();
        n.val = 1;
        List<NArrayPostOrder.Node> childrens = new ArrayList<>();
        NArrayPostOrder.Node n1 = new NArrayPostOrder.Node();
        n1.val = 3;
        NArrayPostOrder.Node n2 = new NArrayPostOrder.Node();
        n2.val = 2;
        NArrayPostOrder.Node n3 = new NArrayPostOrder.Node();
        n3.val = 4;
        NArrayPostOrder.Node n4 = new NArrayPostOrder.Node();
        n4.val = 5;
        NArrayPostOrder.Node n5 = new NArrayPostOrder.Node();
        n5.val = 6;
        childrens.add(n1);
        childrens.add(n2);
        childrens.add(n3);

        List<NArrayPostOrder.Node> childrens1 = new ArrayList<>();
        childrens1.add(n4);
        List<NArrayPostOrder.Node> childrens2 = new ArrayList<>();
        childrens2.add(n5);

        n1.children = childrens1;
        n2.children = childrens2;

        n.children = childrens;
        n3.children = new ArrayList<>();
        n4.children = new ArrayList<>();
        n5.children = new ArrayList<>();

        for(int i : new NArrayPostOrder().postorder(n)){
            System.out.print(i+", ");
        }
        System.out.println();

        for(int i : new NArrayPostOrder().postorderV2(n)){
            System.out.print(i+", ");
        }
        System.out.println();

        for(int i : new NArrayPostOrder().postorderV3(n)){
            System.out.print(i+", ");
        }
        System.out.println();

        for(int i : new NArrayPostOrder().postorderV4(n)){
            System.out.print(i+", ");
        }
    }
}
