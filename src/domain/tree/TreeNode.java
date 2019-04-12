package domain.tree;

/**
 * Author:  andy.xwt
 * Date:    2019-03-05 16:14
 * Description:
 * 二叉树结合了两种数据结构的有点，一种是有序数组，另一种是链表，在树种查找数据项的速度
 * 和在有序数组中查找一样块，并且插入数据和删除数据的速度也和链表一样。
 * <p>
 * 二叉树的定义：如果树种每个节点最多有两个节点，这样的树称为二叉树
 * 二叉树的特点：左节点的值比父节点的小，右节点的值比父节点的大
 */

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}
