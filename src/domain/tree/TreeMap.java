package domain.tree;

/**
 * Author:  andy.xwt
 * Date:    2019-03-05 16:23
 * Description: 操作树的类
 */

public class TreeMap {

    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.insert(20, 20);
        tree.insert(10, 10);
        tree.insert(5, 5);
        tree.insert(11, 11);
        tree.insert(19, 19);
        tree.insert(30, 30);


        //前序遍历
        tree.preOrder(tree.getRoot());
        System.out.println("-------");
        //中序遍历
        tree.inOrder(tree.getRoot());
        //后续遍历
        System.out.println("-------");
        tree.postOrder(tree.getRoot());

        //最小节点
        System.out.println("-------");
        System.out.println(tree.miniMum().intData);

        //最大节点
        System.out.println("-------");
        System.out.println(tree.maxMum().intData);
    }
}