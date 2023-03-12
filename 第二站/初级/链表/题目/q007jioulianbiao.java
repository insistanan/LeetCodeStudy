package 第二站.初级.链表.题目;

/**
 * 奇偶链表
 * 给定单链表的头节点 head ，将所有索引为奇数的节点和索引为偶数的节点分别组合在一起，然后返回重新排序的列表。
 * 第一个节点的索引被认为是 奇数 ， 第二个节点的索引为 偶数 ，以此类推
 * 偶数组和奇数组内部的相对顺序应该与输入时保持一致。
 * 输入: head = [2,1,3,5,6,4,7]
 * 输出: [2,3,6,7,1,5,4]
 * @author insis
 * @date 2023/03/12
 */
public class q007jioulianbiao {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return head;
        }
        //定义偶数起始节点
        ListNode evenHead = head.next;
        //定义两个节点分别作为奇数偶数的指针
        ListNode odd = head, even = evenHead;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        //奇数节点尾部节点指向偶数起始节点
        odd.next = evenHead;

        return head;
    }
}
