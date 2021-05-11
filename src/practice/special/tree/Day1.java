package practice.special.tree;


import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import domain.tree.TreeNode;

/**
 * Author:  andy.xwt
 * Date:    2021/5/6 7:27 下午
 * Description:
 * 144-二叉树的前序遍历{@link medium.tree.PreorderTraversal}
 * 94 -二叉树的中序遍历{@link medium.tree.InorderTraversal}
 * 145-二叉树的后序遍历{@link medium.tree.PostorderTraversal}
 * 102-二叉树的层序遍历{@link medium.tree.LevelOrder}
 * 107-二叉树的层序遍历2{@link medium.tree.LevelOrderBottom}
 * 104-二叉树的最大深度{@link simple.tree.MaxDepth}
 * 111-二叉树的最小深度{@link simple.tree.MinDepth}
 */

class Day1 {


    ///////////////////////////////////////////////////////////////////////////
    // 二叉树的前序序遍历
    ///////////////////////////////////////////////////////////////////////////

    public List<Integer> preorderTraversalSolution1(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<Integer> list = new ArrayList<>();
        preHelp1(list, root);
        return list;
    }

    public void preHelp1(List<Integer> list, TreeNode root) {
        if (root != null) {
            list.add(root.val);
            preHelp1(list, root.left);
            preHelp1(list, root.right);
        }
    }

    public List<Integer> preorderTraversalSolution2(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();

        while (root != null || !deque.isEmpty()) {
            while (root != null) {
                deque.push(root);
                list.add(root.val);
                root = root.left;
            }

            root = deque.pop();
            root = root.right;
        }
        return list;
    }


    ///////////////////////////////////////////////////////////////////////////
    // 二叉树的中序遍历
    ///////////////////////////////////////////////////////////////////////////

    public List<Integer> inorderTraversalSolution1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        help1(list, root);
        return list;
    }

    public void help1(List<Integer> list, TreeNode root) {
        if (root != null) {
            help1(list, root.left);
            list.add(root.val);
            help1(list, root.right);
        }
    }


    public List<Integer> inorderTraversalSolution2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        while (root != null || !deque.isEmpty()) {

            while (root != null) {
                deque.push(root);
                root = root.left;
            }

            root = deque.pop();
            list.add(root.val);
            root = root.right;
        }
        return list;
    }


    ///////////////////////////////////////////////////////////////////////////
    // 二叉树的后序遍历
    ///////////////////////////////////////////////////////////////////////////

    public List<Integer> postorderTraversalSolution1(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<Integer> list = new ArrayList<>();
        postHelp1(list, root);
        return list;
    }

    public void postHelp1(List<Integer> list, TreeNode root) {
        if (root != null) {
            postHelp1(list, root.left);
            postHelp1(list, root.right);
            list.add(root.val);
        }
    }


    public List<Integer> postorderTraversalSolution2(TreeNode root) {
        if (root == null) {
            return null;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        TreeNode pre = null;

        while (root != null || !deque.isEmpty()) {
            while (root != null) {
                deque.push(root);
                root = root.left;
            }
            root = deque.pop();
            if (root.right == null || root.right == pre) {
                list.add(root.val);
                pre = root;
                root = null;
            } else {
                deque.push(root);
                root = root.right;
            }
        }
        return list;
    }

    ///////////////////////////////////////////////////////////////////////////
    // 二叉树的层序遍历
    ///////////////////////////////////////////////////////////////////////////

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();

        if (root != null) {
            deque.offer(root);
        }
        while (!deque.isEmpty()) {
            int size = deque.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.poll();
                level.add(node.val);

                if (node.left != null) {
                    deque.offer(node.left);
                }

                if (node.right != null) {
                    deque.offer(node.right);
                }
            }
            list.add(level);

        }

        return list;
    }


    ///////////////////////////////////////////////////////////////////////////
    // 二叉树的层序遍历2
    ///////////////////////////////////////////////////////////////////////////
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();

        if (root != null) {
            deque.offer(root);
        }

        while (!deque.isEmpty()) {
            int size = deque.size();

            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.poll();
                level.add(node.val);

                if (node.left != null) {
                    deque.offer(node.left);
                }

                if (node.right != null) {
                    deque.offer(node.right);
                }
            }
            list.add(0, level);
        }

        return list;
    }

    ///////////////////////////////////////////////////////////////////////////
    // 二叉树的最大深度
    ///////////////////////////////////////////////////////////////////////////
    public int maxDepthSolution1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftLength = maxDepthSolution1(root.left);
        int rightLength = maxDepthSolution1(root.right);
        return Math.max(leftLength, rightLength) + 1;
    }


    public int maxDepthSolution2(TreeNode root) {
        int res = 0;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        while (root != null) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.poll();

                if (node.left != null) {
                    deque.offer(node.left);
                }
                if (node.right != null) {
                    deque.offer(node.right);
                }
            }
            res++;
        }

        return res;
    }

    ///////////////////////////////////////////////////////////////////////////
    // 二叉树的最小深度
    ///////////////////////////////////////////////////////////////////////////
    public int minDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftLength = minDepth1(root.left);
        int rightLength = minDepth1(root.right);

        return (leftLength == 0 || rightLength == 0) ? leftLength + rightLength + 1 : Math.min(leftLength, rightLength) + 1;
    }

    public int minDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int res = 0;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);

        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.poll();
                if (node.left == null && node.right == null) {
                    return res;
                }

                if (node.left != null) {
                    deque.offer(node.left);
                }
                if (node.right != null) {
                    deque.offer(node.right);
                }
                res++;
            }
        }
        return res;
    }
}



