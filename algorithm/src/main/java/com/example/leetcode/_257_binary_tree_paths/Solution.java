package com.example.leetcode._257_binary_tree_paths;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

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
    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        List<List<TreeNode>> lists = new ArrayList<>();
        List<TreeNode> list = new ArrayList<>();

        findTreePaths(root, lists, list);
        if (!lists.isEmpty()) {
            lists.forEach(item -> {
                result.add(buildPath(item));
            });
        }
        return result;
    }

    private static String buildPath(List<TreeNode> list) {
        String result = "";
        if (list.isEmpty()) {
            return result;
        }

        for (int i = 0; i < list.size(); i++) {
            if (i == list.size() - 1) {
                result += list.get(i).val;
            } else {
                result += list.get(i).val + "->";
            }
        }

        return result;
    }

    private static void findTreePaths(TreeNode root, List<List<TreeNode>> lists, List<TreeNode> list) {
        // root为null，返回
        if (root == null) {
            return;
        }
        // 添加节点
        list.add(root);
        // 左右节点为null，是叶子节点，添加list
        if (root.left == null
                && root.right == null) {
            lists.add(list);
            return;
        }
        // 递归左子树，注意new ArrayList<>，防止左子树添加到list中的节点影响右子树
        findTreePaths(root.left, lists, new ArrayList<>(list));
        // 递归右子树，注意new ArrayList<>
        findTreePaths(root.right, lists, new ArrayList<>(list));
    }

    public static void findPaths(TreeNode root, List<String> paths, String path) {
        if (root == null) {
            return;
        }
        // 添加节点
        path += root.val;
        // 叶子节点，添加路径
        if (root.left == null
                && root.right == null) {
            paths.add(path);
            return;
        }
        // 遍历左右子树，注意 path+"->"，新生成已有路径，左右子树不能影响
        findPaths(root.left, paths, path + "->");
        findPaths(root.right, paths, path + "->");
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);

        node1.left = node2;
        node1.right = node3;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;

        List<String> strings = binaryTreePaths(node1);
        System.out.println(JSON.toJSONString(strings));

        List<String> paths = new ArrayList<>();
        findPaths(node1, paths, "");
        System.out.println(JSON.toJSONString(paths));
    }
}
