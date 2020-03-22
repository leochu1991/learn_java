package com.example.leetcode._230_kth_smallest_element_in_a_bst;

import java.util.Stack;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */

/**
 * 非递归中序遍历
 */
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        int res = 0, cnt = 0;
        Stack<TreeNode> stack = new Stack<>();

        while (root != null || !stack.isEmpty()) {
            // 先向左遍历，加入stack
            while (root != null) {
                stack.add(root);
                root = root.left;
            }
            // 统计次数
            cnt++;
            // stack不为空，弹出一个元素
            if (!stack.isEmpty()) {
                root = stack.pop();
                // cnt为第k个，返回该值，否则遍历右子树
                if (k == cnt) {
                    res = root.val;
                    break;
                } else {
                    root = root.right;
                }
            }
        }
        return res;
    }
}