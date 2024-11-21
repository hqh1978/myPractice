package org.example.myPractice.tree;

class TreeNode2 {
    int value;
    TreeNode2 left, right;

    TreeNode2(int value) {
        this.value = value;
        left = right = null;
    }
}
public class MyTreeNew {

    public static void main(String[] args) {
        TreeNode2 root = new TreeNode2(1);
        root.left = new TreeNode2(2);
        root.right = new TreeNode2(3);
        root.left.left = new TreeNode2(4);
        root.left.right = new TreeNode2(5);

        System.out.print("前序遍历结果: ");
        preOrder(root);  // 调用前序遍历
    }
    public static void preOrder(TreeNode2 root) {
        if (root == null) {
            return;
        }
        System.out.print(root.value + " "); // 访问根节点
        preOrder(root.left);  // 遍历左子树
        preOrder(root.right); // 遍历右子树
    }
}
