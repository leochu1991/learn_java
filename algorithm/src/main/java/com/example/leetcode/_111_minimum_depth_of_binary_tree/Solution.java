package com.example.leetcode._111_minimum_depth_of_binary_tree;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public static int minDepth(TreeNode root) {
        // root=null，返回0
        if (root == null) {
            return 0;
        } else if (root.left == null && root.right == null) {
            // root左右节点为null，返回1
            return 1;
        } else if (root.left == null) {
            // 左节点为null，返回右节点最短距离
            return minDepth(root.right) + 1;
        } else if (root.right == null) {
            // 右节点为null，返回左节点最短距离
            return minDepth(root.left) + 1;
        } else {
            // 返回左右节点的最短距离
            return 1 + Math.min(minDepth(root.left), minDepth(root.right));
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode treeNode9 = new TreeNode(9);
        TreeNode treeNode20 = new TreeNode(20);
        TreeNode treeNode15 = new TreeNode(15);
        TreeNode treeNode7 = new TreeNode(7);
        root.left = treeNode9;
        root.right = treeNode20;
        treeNode20.left = treeNode15;
        treeNode20.right = treeNode7;

        System.out.println("minDepth:" + minDepth(root));
    }
}