package domain.tree;

/**
 * Author:  andy.xwt
 * Date:    2019-03-05 16:20
 * Description:
 */

public class Tree {

    private TreeNode root;

    /**
     * 根据key查找数据
     */
    public TreeNode find(int key) {
        TreeNode current = root;
        while (current.val != key) {
            if (key < current.val) {//如果比当前节点小，则遍历当前节点的左节点
                current = current.left;
            } else {
                current = current.right;//反之遍历当前节点的右节点
            }
            if (current == null) {
                return null;
            }
        }
        return current;
    }

    /**
     * 添加数据
     */
    public void insert(int data) {
        TreeNode newNode = new TreeNode(data);
        if (root == null) {//如果当前根节点为null,则新添加的节点为根节点
            root = newNode;
        } else {
            TreeNode current = root;
            TreeNode parent;//记录遍历时的父节点，
            while (true) {
                parent = current;
                if (newNode.val < current.val) {
                    current = current.left;
                    //如果当前节点，没有左节点,则新节点为该当前节点的左节点
                    if (current == null) {
                        parent.left = newNode;
                        return;
                    }
                } else {//如果当前节点，没有右节点，则新节点为该当前节点的右节点
                    current = current.right;
                    if (current == null) {
                        parent.right = newNode;
                        return;
                    }
                }

            }
        }
    }

    /**
     * 中序遍历：中序遍历二叉树会使所有的节点按照关键字升序被访问到
     * 方法：
     * 1.调用自身来遍历节点的左子树
     * 2.访问这个节点
     * 3.调用自身来遍历节点的右子树
     */
    public void inOrder(TreeNode localRoot) {
        if (localRoot != null) {
            inOrder(localRoot.left);
            System.out.println(localRoot.val);
            inOrder(localRoot.right);
        }
    }

    /**
     * 前序遍历：前序遍历二叉树，
     * 方法：
     * 1.访问这个节点
     * 2.调用自身来遍历节点的左子树
     * 3.调用自身来遍历节点的右子树
     */
    public void preOrder(TreeNode localRoot) {
        if (localRoot != null) {
            System.out.println(localRoot.val);
            preOrder(localRoot.left);
            preOrder(localRoot.right);
        }
    }

    /**
     * 后续遍历：
     * 方法：
     * 1.调用自身来遍历节点的左子树
     * 2.调用自身来遍历节点的右子树
     * 3.访问这个节点
     */
    public void postOrder(TreeNode localRoot) {
        if (localRoot != null) {
            preOrder(localRoot.left);
            preOrder(localRoot.right);
            System.out.println(localRoot.val);
        }
    }

    /**
     * 根据key删除数据
     */
    public void delete(int key) {

    }

    /**
     * 获取最小值的节点
     */
    public TreeNode miniMum() {
        TreeNode current, last = null;
        current = root;
        while (current != null) {
            last = current;
            current = current.left;
        }
        return last;
    }

    /**
     * 获取最大值的节点
     */
    public TreeNode maxMum() {
        TreeNode current, last = null;
        current = root;
        while (current != null) {
            last = current;
            current = current.right;
        }
        return last;
    }

    public TreeNode getRoot() {
        return root;
    }
}
