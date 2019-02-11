package com.programming.leetcode.Medium;

public class PopulatingNextRightPointerInEachNodeII {

    public void connect(TreeLinkNode root) {
        if(root == null) return;
        TreeLinkNode crt = root;
        TreeLinkNode tmpChild = new TreeLinkNode(0);
        while (crt != null){
            TreeLinkNode crtChild = tmpChild;
            while(crt != null){
                if(crt.left != null){
                    crtChild.next = crt.left;
                    crtChild = crtChild.next;
                }
                if(crt.right != null){
                    crtChild.next = crt.right;
                    crtChild = crtChild.next;
                }
                crt = crt.next;
            }
            crt = tmpChild.next;
            tmpChild.next = null;
        }
    }

    public void connectV1(TreeLinkNode root) {
        if(root == null) return;
        TreeLinkNode crt = root;
        while (crt != null){
            TreeLinkNode crtChild = getChildNode(crt);
            while(crt != null){
                if(crt.left != null || crt.right != null) {
                    if (crt.left != null && crt.right != null) {
                        crt.left.next = crt.right;
                    }
                    if (crt.left != null && crt.right == null) {
                        crt.left.next = crt.next == null ? null : getNextNode(crt);
                    } else if (crt.next != null) {
                        crt.right.next = getNextNode(crt);
                    }
                }
                crt = crt.next;
            }
            crt = crtChild;
        }
    }

    private TreeLinkNode getChildNode(TreeLinkNode node){
        TreeLinkNode t = node;
        while (t != null){
            if(t.left == null && t.right == null){
                t = t.next;
            }else{
                t = t.left == null ? t.right : t.left;
                break;
            }
        }
        return t;
    }

    private TreeLinkNode getNextNode(TreeLinkNode node){
        TreeLinkNode t = node.next;
        while (t != null){
            if(t.left != null){
                t = t.left;
                break;
            }else if(t.right != null){
                t = t.right;
                break;
            }
            t = t.next;
        }
        return t;
    }

    public static void main(String[] args) {
        TreeLinkNode node = new TreeLinkNode(1);
        node.left = new TreeLinkNode(2);
        node.right = new TreeLinkNode(3);
        node.right.left = new TreeLinkNode(4);
        node.right.right = new TreeLinkNode(5);
        node.right.left.right = new TreeLinkNode(7);
        node.right.right.left = new TreeLinkNode(8);
        PopulatingNextRightPointerInEachNodeII obj = new PopulatingNextRightPointerInEachNodeII();
        obj.connectV1(node);
    }

}
