package medium.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import domain.tree.TreeNode;

/**
 * Author:  andy.xwt
 * Date:    2021/4/19 13:42
 * Description:652-寻找重复的子树
 * <p>
 * <p>
 * 给定一棵二叉树，返回所有重复的子树。对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。
 * <p>
 * 两棵树重复是指它们具有相同的结构以及相同的结点值。
 */

class FindDuplicateSubTree {

    /**
     * 解法：
     * 思路：将子树变换为字符串，然后判断字符串是否重复就能知道了。如果知道一个子树长什么样，需要使用后续遍历
     */
    public List<TreeNode> findDuplicateSubtreesSolution1(TreeNode root) {
        Map<String, Integer> map = new HashMap<>();
        List<TreeNode> list = new ArrayList<>();
        getList(map, list, root);
        return list;
    }

    private String getList(Map<String, Integer> map, List<TreeNode> list, TreeNode root) {
        if (root == null) {
            return "#";
        }
        //前序遍历，将二叉树序列化。
        String serTree = root.val + "." + getList(map, list, root.left) + getList(map, list, root.right);
        //获取重复的子树
        map.put(serTree, map.getOrDefault(serTree, 0) + 1);
        if (map.get(serTree) == 2) {
            list.add(root);
        }
        return serTree;
    }
}
