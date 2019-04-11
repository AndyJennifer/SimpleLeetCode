package simple.link;

/**
 * Author:  andy.xwt
 * Date:    2019-04-11 22:25
 * Description: 删除链表中的节点
 * 请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点，你将只被给定要求被删除的节点。
 * <p>
 * 现有一个链表 -- head = [4,5,1,9]，它可以表示为:
 *
 * <p>
 * 示例 1:
 * <p>
 * 输入: head = [4,5,1,9], node = 5
 * 输出: [4,1,9]
 * 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
 * 示例 2:
 * <p>
 * 输入: head = [4,5,1,9], node = 1
 * 输出: [4,5,9]
 * 解释: 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
 * <p>
 * <p>
 * 说明:
 * <p>
 * 链表至少包含两个节点。
 * 链表中所有节点的值都是唯一的。
 * 给定的节点为非末尾节点并且一定是链表中的一个有效节点。
 * 不要从你的函数中返回任何结果。
 */

public class DeleteNode {

    public static void main(String[] args) {
        ListNode listNode = ListNode.createList(new int[]{4, 5, 1, 9});
        deleteNode(new ListNode(5));
    }

    /**
     * 常见的解题思路：
     * 从链表里删除一个节点 node 的最常见方法是修改之前节点的 next 指针，使其指向之后的节点。
     * 因为我们无法访问我们想要删除的节点之前的节点，我们始终不能修改该节点的 next 指针。
     * 相反，我们必须将想要删除的节点的值替换为它后面节点中的值，然后删除它之后的节点。
     * 因为我们知道要删除的节点不是列表的末尾，所以我们可以保证这种方法是可行的。
     */
    public static void deleteNode(ListNode node) {
        //将当前要删除的节点的值，修改为当前节点的下一节点的值
        node.val = node.next.val;
        //将当前要删除的next节点，执行当前节点的下下节点。
        node.next = node.next.next;
    }


}
