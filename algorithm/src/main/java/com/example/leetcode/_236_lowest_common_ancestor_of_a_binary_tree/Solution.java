package com.example.leetcode._236_lowest_common_ancestor_of_a_binary_tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Stack<TreeNode> pStack = new Stack<>();
        Stack<TreeNode> qStack = new Stack<>();
        // 生成路径
        getNodePath(root, p, pStack);
        getNodePath(root, q, qStack);
        // 生成root到target路径
        List<TreeNode> pList = buildPathList(pStack);
        List<TreeNode> qList = buildPathList(qStack);
        // 查找公共节点
        TreeNode commonNode = findCommonNode(pList, qList);
        return commonNode;
    }

    public static TreeNode findCommonNode(List<TreeNode> pList, List<TreeNode> qList) {
        TreeNode commonNode = null;
        if (pList.isEmpty() || qList.isEmpty()) {
            return commonNode;
        }
        int index = 0;
        int pSize = pList.size();
        int qSize = qList.size();
        while (index < pSize
                && index < qSize) {
            if (pList.get(index).equals(qList.get(index))) {
                commonNode = pList.get(index);
                index++;
            } else {
                break;
            }
        }
        return commonNode;
    }

    public List<TreeNode> buildPathList(Stack<TreeNode> stack) {
        List<TreeNode> list = new ArrayList<>();
        if (stack.isEmpty()) {
            return list;
        }
        int size = stack.size();
        TreeNode[] treeNodes = new TreeNode[size];
        for (int i = size - 1; i >= 0; i--) {
            treeNodes[i] = stack.pop();
        }
        list = Arrays.asList(treeNodes);
        return list;
    }

    /**
     * 获取root到target节点的路径
     *
     * @param root   根节点
     * @param target 目标节点
     * @param stack  栈
     * @return
     */
    public boolean getNodePath(TreeNode root, TreeNode target, Stack<TreeNode> stack) {
        if (root == null || target == null) {
            return false;
        }
        // 先将节点加入栈
        stack.push(root);
        // 找到目标节点，返回true
        if (root == target) {
            return true;
        }
        // 未找到，递归判断左子树
        boolean found = false;
        if (!found && root.left != null) {
            found = getNodePath(root.left, target, stack);
        }
        // 未找到，递归判断右子树
        if (!found && root.right != null) {
            found = getNodePath(root.right, target, stack);
        }
        // 仍未找到target，弹出当前节点
        if (!found) {
            stack.pop();
        }
        return found;
    }

    /**
     * 判断root是否是target节点的祖先
     *
     * @param root   根节点
     * @param target 目标节点
     * @return
     */
    public static boolean checkNodeExists(TreeNode root, TreeNode target) {
        if (root == null || target == null) {
            return false;
        }
        if (root == target) {
            return true;
        }
        boolean found = false;
        if (root.left != null) {
            found = checkNodeExists(root.left, target);
        }
        if (!found && root.right != null) {
            found = checkNodeExists(root.right, target);
        }
        return found;
    }

    public static void main(String[] args) {
        List<TreeNode> pList = new ArrayList<>();
        List<TreeNode> qList = new ArrayList<>();

        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);

        pList.add(node1);
        pList.add(node2);
        pList.add(node3);
        pList.add(node4);

        qList.add(node1);
        qList.add(node2);
        qList.add(node3);

        TreeNode commonNode = findCommonNode(pList, qList);
        System.out.println("commonNode.val=" + commonNode.val);

    }
}