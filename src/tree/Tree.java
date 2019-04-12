package tree;

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
        while (current.intData != key) {
            if (key < current.intData) {//如果比当前节点小，则遍历当前节点的左节点
                current = current.leftChild;
            } else {
                current = current.rightChild;//反之遍历当前节点的右节点
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
    public void insert(int key, double data) {
        TreeNode newNode = new TreeNode();
        newNode.intData = key;
        newNode.doubleData = data;
        if (root == null) {//如果当前根节点为null,则新添加的节点为根节点
            root = newNode;
        } else {
            TreeNode current = root;
            TreeNode parent;//记录遍历时的父节点，
            while (true) {
                parent = current;
                if (key < current.intData) {
                    current = current.leftChild;
                    //如果当前节点，没有左节点,则新节点为该当前节点的左节点
                    if (current == null) {
                        parent.leftChild = newNode;
                        return;
                    }
                } else {//如果当前节点，没有右节点，则新节点为该当前节点的右节点
                    current = current.rightChild;
                    if (current == null) {
                        parent.rightChild = newNode;
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
            inOrder(localRoot.leftChild);
            System.out.println(localRoot.intData);
            inOrder(localRoot.rightChild);
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
            System.out.println(localRoot.intData);
            preOrder(localRoot.leftChild);
            preOrder(localRoot.rightChild);
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
            preOrder(localRoot.leftChild);
            preOrder(localRoot.rightChild);
            System.out.println(localRoot.intData);
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
            current = current.leftChild;
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
            current = current.rightChild;
        }
        return last;
    }

    public TreeNode getRoot() {
        return root;
    }
}
