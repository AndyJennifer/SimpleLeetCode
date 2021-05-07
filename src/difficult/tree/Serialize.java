package difficult.tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

import domain.tree.TreeNode;

/**
 * Author:  andy.xwt
 * Date:    2021/4/30 17:26
 * Description: 297-二叉树的序列化与反序列化
 * <p>
 * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
 * <p>
 * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 * <p>
 * 提示: 输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Serialize {

    /**
     * 树的遍历方式总体分为两类：深度优先搜索（DFS）、广度优先搜索（BFS）；
     * 常见的 DFS ： 先序遍历、中序遍历、后序遍历；
     * 常见的 BFS ： 层序遍历（即按层遍历）。
     */

    private static final String NULL = "#";

    public static final String SEP = ",";


    ///////////////////////////////////////////////////////////////////////////
    // 解法1：使用前序遍历
    ///////////////////////////////////////////////////////////////////////////
    public String serialize1(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        return serializeHelp1(root, sb);
    }

    public String serializeHelp1(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(NULL).append(SEP);
        } else {
            sb.append(root.val).append(SEP);
            serializeHelp1(root.left, sb);
            serializeHelp1(root.right, sb);
        }
        return sb.toString();
    }

    public TreeNode deserialize1(String data) {
        LinkedList<String> nodes = new LinkedList<>();
        for (String s : data.split(SEP)) {
            nodes.addLast(s);
        }
        return deserializeHelp1(nodes);
    }

    public TreeNode deserializeHelp1(LinkedList<String> nodes) {
        if (nodes.isEmpty()) {
            return null;
        }
        String s = nodes.removeFirst();
        if (s.equals(NULL)) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(s));
        root.left = deserializeHelp1(nodes);
        root.right = deserializeHelp1(nodes);
        return root;
    }


    ///////////////////////////////////////////////////////////////////////////
    // 解法2：使用后序遍历
    ///////////////////////////////////////////////////////////////////////////

    public String serialize2(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        return serializeHelp2(root, sb);
    }

    public String serializeHelp2(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(NULL).append(SEP);
        } else {
            serializeHelp2(root.left, sb);
            serializeHelp2(root.right, sb);
            sb.append(root.val).append(SEP);
        }
        return sb.toString();
    }

    public TreeNode deserialize2(String data) {
        LinkedList<String> list = new LinkedList<>();
        for (String s : data.split(SEP)) {
            list.addLast(s);
        }
        return deserializeHelp2(list);
    }

    public TreeNode deserializeHelp2(LinkedList<String> nodes) {
        if (nodes.isEmpty()) {
            return null;
        }
        String s = nodes.removeLast();
        if (s.equals(NULL)) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(s));
        //因为是后序遍历，所以需要先构造右节点
        root.right = deserializeHelp2(nodes);
        root.left = deserializeHelp2(nodes);
        return root;
    }


    ///////////////////////////////////////////////////////////////////////////
    // 解法3：使用层序遍历
    ///////////////////////////////////////////////////////////////////////////


    public String serialize3(TreeNode root) {
        if (root == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);

        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.poll();
                if (node == null) {
                    sb.append(NULL).append(SEP);
                } else {
                    sb.append(root.val).append(SEP);
                    deque.offer(node.left);
                    deque.offer(node.right);
                }
            }
        }
        return sb.toString();
    }

    public TreeNode deserialize3(String data) {
        if (data == null) {
            return null;
        }

        String[] split = data.split(SEP);
        TreeNode root = new TreeNode(Integer.parseInt(split[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        for (int i = 1; i < split.length; i++) {

            //队列中存储的都是父节点
            TreeNode node = queue.poll();
            String left = split[i++];

            //父节点，左节点的值
            if (!left.equals(NULL)) {
                node.left = new TreeNode(Integer.parseInt(left));
                queue.offer(node.left);
            } else {
                node.left = null;
            }

            //父节点，右节点的值
            String right = split[i++];
            if (!right.equals(NULL)) {
                node.right = new TreeNode(Integer.parseInt(right));
                queue.offer(node.right);
            } else {
                node.right = null;
            }

        }
        return root;
    }
}
