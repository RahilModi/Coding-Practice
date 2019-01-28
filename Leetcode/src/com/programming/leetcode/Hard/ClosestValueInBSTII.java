package com.programming.leetcode.Hard;

import java.util.*;
import java.util.stream.Collectors;

/***
 * Given a non-empty binary search tree and a target value, find k values in the BST that are closest to the target.
 * Note:
 * Given target value is a floating point.
 * You may assume k is always valid, that is: k ≤ total nodes.
 * You are guaranteed to have only one unique set of k values in the BST that are closest to the target.
 * Follow up:
 * Assume that the BST is balanced, could you solve it in less than O(n) runtime (where n = total nodes)?
 * Hint:
 * Consider implement these two helper functions:
 * getPredecessor(N), which returns the next smaller node to N.
 * getSuccessor(N), which returns the next larger node to N.
 * Try to assume that each node has a parent pointer, it makes the problem much easier.
 * Without parent pointer we just need to keep track of the path from the root to the current node using a stack.
 * You would need two stacks to track the path in finding predecessor and successor node separately.
 */

public class ClosestValueInBSTII {

    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> res = new ArrayList<>();
        List<Integer> vals = new ArrayList<>();
        inorderTraversal(root, vals);
        int closestIndex = 0;
        double diff = vals.get(closestIndex) - target;
        for(int i = 1; i < vals.size(); i++){
            if(Math.abs(vals.get(i) - target) < Math.abs(vals.get(closestIndex)-target)) {
                closestIndex = i;
                diff = vals.get(closestIndex) - target;
            }
        }
        res.add(vals.get(closestIndex));
        int left = closestIndex - 1, right = closestIndex+1;
        for( int i =1; i < k ; i++){
            if(left >= 0 && right < vals.size()) {
                if (Math.abs(vals.get(left) - target) < Math.abs(vals.get(closestIndex) - target)) {
                    res.add(vals.get(left--));
                } else {
                    res.add(vals.get(right++));
                }
            }else if(left >= 0){
                res.add(vals.get(left--));
            }else if(right < vals.size()){
                res.add(vals.get(right++));
            }
        }
        return res;
    }

    void inorderTraversal(TreeNode root, List<Integer> sortedVals){
        if(root != null) return;
        inorderTraversal(root.left,sortedVals);
        sortedVals.add(root.val);
        inorderTraversal(root.right,sortedVals);
    }


    //Unlike Previous processing we are only picking K values which are closest to Target during INORDER Traversal..
    public List<Integer> closestKValuesV2(TreeNode root, double target, int k) {
        List<Integer> res = new ArrayList<>();
        inorderTraversalV2(root, target, k, res);
        return res;
    }

    void inorderTraversalV2(TreeNode root, double target, int k, List<Integer> res){
        if(root != null) return;
        inorderTraversalV2(root.left,target, k, res);
        if(res.size() < k)
            res.add(root.val);
        else if(Math.abs(root.val - target) < Math.abs(res.get(0)-target)){
                res.remove(0);
                res.add(root.val);
        }else return;
        inorderTraversalV2(root.right, target, k, res);
    }

    public List<Integer> closestKValuesV3(TreeNode root, double target, int k) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while(node != null || !stack.isEmpty()){
            while(node != null){
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            if(res.size() < k)
                res.add(node.val);
            else if(Math.abs(node.val - target) < Math.abs(res.get(0)-target)){
                res.remove(0);
                res.add(node.val);
            }else break;
            node = node.right;
        }
        return res;
    }

    //Class for Priority Queue...
    class TreeNodeDist{
        Double dist;
        int nodeVal;

        public TreeNodeDist(Double dist, int nodeVal) {
            this.dist = dist;
            this.nodeVal = nodeVal;
        }

        public Double getDist() {
            return dist;
        }
    }

    PriorityQueue<TreeNodeDist> pq = new PriorityQueue<>(Comparator.comparingDouble(TreeNodeDist::getDist));

    public List<Integer> closestKValuesV4(TreeNode root, double target, int k) {
        inorderTraversalV4(root,target,k);
        return pq.stream().map(t->t.nodeVal).collect(Collectors.toList());
    }

    void inorderTraversalV4(TreeNode root, double target, int k){
        if(root != null) return;
        inorderTraversalV4(root.left,target, k);
        pq.offer(new TreeNodeDist(Math.abs(root.val-target), root.val));
        if(pq.size() > k)
            pq.poll();
        inorderTraversalV4(root.right, target, k);
    }

    public List<Integer> closestKValuesV5(TreeNode root, double target, int k) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> pre = new Stack<>(),suc = new Stack<>();
        while(root!=null){
            if(root.val <= target){
                pre.push(root);
                root= root.right;
            }else{
                suc.push(root);
                root = root.left;
            }
        }
        while(k-->0){
            if(suc.isEmpty() || !pre.isEmpty() && Math.abs(pre.peek().val - target) < Math.abs(suc.peek().val - target)){
                res.add(pre.peek().val);
                getPredecessor(pre);
            }else{
                res.add(suc.peek().val);
                getSuccessor(suc);
            }
        }
        return res;
    }

    void getPredecessor(Stack<TreeNode> pre){
        TreeNode temp = pre.pop();
        if(temp.left != null){
            pre.push(temp.left);
            while(pre.peek().right != null) pre.push(pre.peek().right);
        }
    }

    void getSuccessor(Stack<TreeNode> suc){
        TreeNode temp = suc.pop();
        if(temp.right != null){
            suc.push(temp.right);
            while(suc.peek().left != null) suc.push(suc.peek().left);
        }
    }

    //Copied from https://jeantimex.gitbooks.io/solve-leetcode-problems/problems/Closest%20Binary%20Search%20Tree%20Value%20II.html
    public List<Integer> closestKValuesV6(TreeNode root, double target, int k) {
        List<Integer> res = new ArrayList<>();
        Stack<Integer> s1 = inorderV6(root, target, true);  // successors
        Stack<Integer> s2 = inorderV6(root, target, false); // predecessors

        while (k-- > 0) {
            if (s1.isEmpty())
                res.add(s2.pop());
            else if (s2.isEmpty())
                res.add(s1.pop());
            else if (Math.abs(s1.peek() - target) < Math.abs(s2.peek() - target))
                res.add(s1.pop());
            else
                res.add(s2.pop());
        }

        return res;
    }

    // iterative inorder traversal
    Stack<Integer> inorderV6(TreeNode root, double target, boolean reverse) {
        Stack<Integer> res = new Stack<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (!stack.isEmpty() || curr != null) {
            if (curr != null) {
                stack.push(curr);
                curr = reverse ? curr.right : curr.left;
            } else {
                curr = stack.pop();
                if (reverse && curr.val <= target) break;
                if (!reverse && curr.val > target) break;
                res.push(curr.val);
                curr = reverse ? curr.left : curr.right;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode node1 = new TreeNode(2); root.left = node1;
        TreeNode node2 = new TreeNode(3); node1.right = node2;
        TreeNode node3 = new TreeNode(4); node2.right = node3;
        TreeNode node4 = new TreeNode(1); node1.left = node4;
        TreeNode node5 = new TreeNode(7); root.right= node5;
        TreeNode node6 = new TreeNode(6);node5.left = node6;
        TreeNode node7 = new TreeNode(8); node5.right = node7;

        //List<Integer> res = new ClosestValueInBSTII().closestKValuesV6(root,4.0,3);
        List<Integer> res = new ClosestValueInBSTII().closestKValuesV5(root,4.0,3);


    }
}
