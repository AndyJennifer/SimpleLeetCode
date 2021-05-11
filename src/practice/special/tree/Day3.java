package practice.special.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import domain.Node;
import domain.tree.TreeNode;

/**
 * Author:  andy.xwt
 * Date:    2021/5/6 19:26
 * Description:
 * <p>
 * 226-翻转二叉树{@link simple.tree.InvertTree}
 * 114-二叉树展开为链表{@link medium.tree.Flatten}
 * 116-填充每个节点的下一个右侧节点指针{@link simple.tree.ConnectionNode}
 * 110-平衡二叉树{@link simple.tree.IsBalanced}
 * 101-对称二叉树{@link simple.tree.IsSymmetric}
 * 100-相同的树{@link simple.tree.IsSameTree}
 * 112-路径总和{@link simple.tree.HasPathSum}
 */

class Day3 {

    ///////////////////////////////////////////////////////////////////////////
    // 翻转二叉树
    ///////////////////////////////////////////////////////////////////////////

    public TreeNode invertTreeSolution1(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = temp;

        invertTreeSolution1(root.left);
        invertTreeSolution1(root.right);
        return root;
    }

    public TreeNode invertTreeSolution2(TreeNode root) {
        if (root == null) {
            return null;
        }
        invertTreeSolution2(root.left);
        invertTreeSolution2(root.right);

        TreeNode temp = root.right;
        root.right = root.left;
        root.left = temp;
        return root;
    }

    ///////////////////////////////////////////////////////////////////////////
    // 二叉树展开为链表
    ///////////////////////////////////////////////////////////////////////////

    public void flattenSolution1(TreeNode root) {
        //使用前序递归的方式
        List<TreeNode> list = new ArrayList<>();
        flattenHelp1(root, list);
        for (int i = 1; i < list.size(); i++) {
            TreeNode pre = list.get(i - 1);
            TreeNode now = list.get(i);
            pre.left = null;
            pre.right = now;
        }
    }

    public void flattenHelp1(TreeNode root, List<TreeNode> list) {
        if (root != null) {
            list.add(root);
            flattenHelp1(root.left, list);
            flattenHelp1(root.right, list);
        }
    }

    public void flattenSolution2(TreeNode root) {
        //使用模拟栈的方式
        if (root == null) {
            return;
        }
        List<TreeNode> list = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        while (root != null || !deque.isEmpty()) {
            while (root != null) {
                list.add(root);
                deque.push(root);
                root = root.left;
            }
            root = deque.pop();
            root = root.right;
        }

        for (int i = 1; i < list.size(); i++) {
            TreeNode pre = list.get(i - 1);
            TreeNode now = list.get(i);
            pre.left = null;
            pre.right = now;
        }

    }


    public void flattenSolution3(TreeNode root) {
        //使用后续遍历递归的方式
        if (root == null) {
            return;
        }

        flattenSolution3(root.left);
        flattenSolution3(root.right);

        TreeNode left = root.left;
        TreeNode right = root.right;

        root.left = null;
        root.right = left;

        TreeNode p = findRight(root.right);
        p.right = right;
    }

    public TreeNode findRight(TreeNode node) {
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }

    ///////////////////////////////////////////////////////////////////////////
    // 填充每个节点的下一个右侧节点指针
    ///////////////////////////////////////////////////////////////////////////

    public Node connectionNodeSolution1(Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if (i < size - 1) {
                    node.next = queue.peek();
                }

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

        }
        return root;
    }

    public Node connectionNodeSolution2(Node root) {
        if (root == null) {
            return null;
        }

        root.left.next = root.right;
        root.right.next = root.next == null ? null : root.next.left;
        connectionNodeSolution2(root.left);
        connectionNodeSolution2(root.right);
        return root;
    }

    ///////////////////////////////////////////////////////////////////////////
    // 平衡二叉树
    ///////////////////////////////////////////////////////////////////////////

    public boolean isBalancedSolution1(TreeNode root) {
        return (height(root.left) - height(root.right) <= 1 &&
                isBalancedSolution1(root.left) && isBalancedSolution1(root.right));
    }

    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(height(root.left), height(root.right)) + 1;
    }

    public boolean isBalancedSolution2(TreeNode root) {
        return maxDeep(root) == -1;
    }

    public int maxDeep(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDeep = maxDeep(root.left);
        int rightDeep = maxDeep(root.right);

        if ((leftDeep == -1 || rightDeep == -1) || Math.abs(leftDeep - rightDeep) > 1) {
            return -1;
        }
        return Math.max(leftDeep, rightDeep) + 1;
    }

    ///////////////////////////////////////////////////////////////////////////
    // 对称二叉树
    ///////////////////////////////////////////////////////////////////////////
    public boolean isSymmetricSolution1(TreeNode root) {
        return check(root, root);
    }

    public boolean check(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        return check(left.left, right.right) && check(left.right, right.left);
    }

    public boolean isSymmetricSolution2(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue1.offer(root);
        queue2.offer(root);

        while (!queue1.isEmpty()) {
            int size = queue1.size();
            for (int i = 0; i < size; i++) {
                TreeNode node1 = queue1.poll();
                TreeNode node2 = queue2.poll();

                if (node1 == null && node2 == null) {
                    continue;
                }

                if (node1 == null || node2 == null) {
                    return false;
                }

                if (node1.val == node2.val) {
                    continue;
                }

                queue1.add(node1.left);
                queue1.add(node1.right);

                queue2.add(node2.right);
                queue2.add(node1.left);

            }
        }

        return true;
    }


    ///////////////////////////////////////////////////////////////////////////
    // 相同的树
    ///////////////////////////////////////////////////////////////////////////

    public boolean isSameTreeSolution1(TreeNode node1, TreeNode node2) {
        return checkIsSameTree(node1, node2);
    }

    public boolean checkIsSameTree(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null || node2 == null) {
            return false;
        }
        if (node1.val != node2.val) {
            return false;
        }
        return checkIsSameTree(node1.left, node2.left) && checkIsSameTree(node2.right, node2.right);
    }

    public boolean isSameTreeSolution2(TreeNode p, TreeNode q) {

        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }

        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue1.offer(p);
        queue2.offer(q);

        while (!queue1.isEmpty() && !queue2.isEmpty()) {

            TreeNode root1 = queue1.poll();
            TreeNode root2 = queue2.poll();

            if (root1.val != root2.val) {
                return false;
            }
            if (root1.left == null ^ root2.left == null) {
                return false;
            }

            if (root1.right == null ^ root2.right == null) {
                return false;
            }

            if (root1.left != null) {
                queue1.offer(root1.left);
            }
            if (root1.right != null) {
                queue1.offer(root1.right);
            }

            if (root2.left != null) {
                queue2.offer(root2.left);
            }
            if (root2.right != null) {
                queue2.offer(root2.right);
            }

        }

        return queue1.isEmpty() && queue2.isEmpty();
    }

    ///////////////////////////////////////////////////////////////////////////
    // 路径总和
    ///////////////////////////////////////////////////////////////////////////
    public boolean hasPathSumSolution1(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null && root.val != sum) {
            return false;
        }
        return hasPathSumSolution1(root.right, sum - root.val) || hasPathSumSolution1(root, sum - root.val);
    }

    public boolean hasPathSumSolution2(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> valueQueue = new LinkedList<>();

        queue.offer(root);
        valueQueue.offer(root.val);

        while (!queue.isEmpty() && !valueQueue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                Integer value = valueQueue.poll();

                if (node.left == null && node.right == null && sum == value) {
                    return true;
                }

                if (node.left != null) {
                    queue.offer(node.left);
                    valueQueue.offer(value + root.left.val);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                    valueQueue.offer(value + root.right.val);
                }

            }

        }
        return false;
    }
}
