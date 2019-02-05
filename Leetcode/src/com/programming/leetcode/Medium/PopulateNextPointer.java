package com.programming.leetcode.Medium;


import java.util.ArrayDeque;
import java.util.Queue;

class TreeLinkNode {
      int val;
      TreeLinkNode left, right, next;
      TreeLinkNode(int x) { val = x; }
}
public class PopulateNextPointer {

    public void connect(TreeLinkNode root) {
        if(root == null) return;
        Queue<TreeLinkNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int crt_queue_size = queue.size();
            TreeLinkNode temp = null;
            for(int i = 0; i < crt_queue_size; i++) {
                temp = queue.poll();
                temp.next = queue.peek();
                if (temp.left != null) {
                    queue.add(temp);
                }
                if (temp.right != null) {
                    queue.add(temp);
                }
            }
        }
        return;
    }

    public void connect_recursive(TreeLinkNode root) {
        if(root == null) return;
        TreeLinkNode crt = root;
        while (crt != null && crt.left != null){
            TreeLinkNode crt_node = crt.left;
            while (crt !=null){
                crt.left.next =crt.right;
                if(crt.next != null) crt.right.next = crt.next.left;
                crt = crt.next;
            }
            crt = crt_node;
        }
        return;
    }


}
