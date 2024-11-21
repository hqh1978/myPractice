
package org.example.myPractice.tree;

import java.util.LinkedList;
import java.util.Queue;

public class TreeBuild {
    public static void main(String[] args) {
        TreeNode root = buildTree2();
        preOrderTraversal(root);
    }

    public static TreeNode buildTree2(){
        return buildTreeHelper(1, 5); // 示例：创建树的值从1到5
    }

    // 辅助方法递归构建树
    private static TreeNode buildTreeHelper(int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(mid);
        node.left = buildTreeHelper(start, mid - 1);
        node.right = buildTreeHelper(mid + 1, end);
        return node;
    }

    //根节点 -> 左子树 -> 右子树。
    public static void preOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        // 访问根节点
        System.out.print(root.val + " ");
        // 遍历左子树
        preOrderTraversal(root.left);
        // 遍历右子树
        preOrderTraversal(root.right);
    }


}

