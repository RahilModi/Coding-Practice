package com.programming.leetcode.Medium;

public class SumRootToLeafNumbers {

    int ans = 0;
    public int sumNumbers(TreeNode root) {
        numberHelper(root, new StringBuilder());
        return ans;
    }

    public void numberHelper(TreeNode node, StringBuilder sb){
        if(node == null) return;
        if(node.left == null && node.right == null){
            sb.append(node.val);
            ans += Integer.parseInt(sb.toString());
            return;
        }
        sb.append(node.val);
        if (node.left!=null) {
            numberHelper(node.left, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
        if(node.right != null) {
            numberHelper(node.right, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    //Much Better...
    public int total = 0;
    public int sumNumbersV1(TreeNode root) {
        helper(root, 0);
        return total;
    }
    private void helper(TreeNode root, int sum){
        if (root == null) return;
        sum = sum * 10 + root.val;
        if (root.left == null && root.right == null){
            total += sum;
            return;
        }
        helper(root.left, sum);
        helper(root.right, sum);

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(new SumRootToLeafNumbers().sumNumbers(root));
    }
}
