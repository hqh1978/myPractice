
package org.example.myPractice.tree;
import java.util.Queue;
import java.util.LinkedList;

public class TreeTraversal {
    public static void main(String[] args) {
        // 构造示例树
        int[] array = {6, 2, 5, 4, 1};
        TreeNode root = null;
        for(int k:array){
            root = buildTree(root ,k);  //这里返回值必须要赋予root对象,// 确保 root 始终更新
        }
        System.out.println("树的深度是: "+getDepth(root));
        getDepth(root);
        System.out.println("Pre-Order Traversal:");
        preOrderTraversal(root);
        System.out.println("---");
        System.out.println("in-Order Traversal:");
        inOrderTraversal(root);

        System.out.println("---");
        System.out.println("post-Order Traversal:");
        postOrderTraversal(root);

        System.out.println("---");
        System.out.println("bfs-Traversal:");
        bfsTraversal(root);
        System.out.println("---");
    }
    public static TreeNode buildTree(TreeNode root, int val) {
        // 如果树为空，直接返回新节点
        if (root == null) {
            return new TreeNode(val);
        }
        // 比较当前节点值与插入值
        if (val < root.val) {
            // 插入到左子树
            //递归调用后必须要更新父节点的左子树,否则，父节点的子树指针（root.left 或 root.right）不会指向新的节点，因此树的结构无法正确更新。
            root.left = buildTree(root.left, val); //这里返回值必须要赋予root.left对象,// 确保 root.left 始终更新
        } else {
            // 插入到右子树
            //递归调用后必须要更新父节点的右子树
           root.right = buildTree(root.right, val);
        }

        return root;
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

    // 左子树 -> 根节点-> 右子树。
    public static void inOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.left);
        System.out.print(root.val + " ");
        inOrderTraversal(root.right);
    }
    // 左子树 -> 右子树->根节点
    public static void postOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.val + " ");
    }

    //左-右-根
    // 广度优先遍历
    public static void bfsTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            System.out.print(current.val + " ");

            // 添加左右子节点到队列中
            if (current.left != null) {
                queue.offer(current.left);
            }
            if (current.right != null) {
                queue.offer(current.right);
            }
        }
    }

    // 计算树的深度的递归方法
    public static int getDepth(TreeNode root) {
        if (root == null) {
            return 0; // 空树的深度是0
        }
        // 递归计算左子树和右子树的深度
        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);

        // 树的深度是左子树和右子树深度的较大值加1
        return Math.max(leftDepth, rightDepth) + 1;
    }
}

