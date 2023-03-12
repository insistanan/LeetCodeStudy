package 第二站.初级.链表.题目;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 删除链表的倒数第N个节点
 * 删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * @author insis
 * @date 2023/03/11
 */
public class q004deleteNode {
    /**
     * 将n从结束
     *
     * @param head 头
     * @param n    n
     * @return {@link ListNode}
     */
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        //定义两个指针
        ListNode fast = head;
        ListNode slow = head;
        //快指针先走n次
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast!=null && fast.next!=null){
            //慢指针走
            slow = slow.next;
            fast = fast.next;
        }
        //删除节点
        if (fast == null){
            //如果fast为空，表示删除的是头结点
            return head.next;
        }else{
            slow.next = slow.next.next;
        }
        return head;
    }

    /**
     * 递归解决
     *
     * @param head 头
     * @param n    n
     * @return {@link ListNode}
     */
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        int pos = length(head, n);
        // 说明删除的是头节点
        if (pos == n) {return head.next;}
        return head;
    }
    // 获取节点所在位置，逆序
    public int length(ListNode node, int n) {
        if (node == null) { return 0;}
        int pos = length(node.next, n) + 1;
        //获取要删除链表的前一个结点，就可以完成链表的删除
        if (pos == n + 1)
        {node.next = node.next.next;}
        return pos;
    }

    /**
     * 利用栈
     *
     * @param head 头
     * @param n    n
     * @return {@link ListNode}
     */
    public ListNode removeNthFromEnd3(ListNode head, int n) {
        //辅助栈
        Deque<ListNode> stack = new LinkedList<>();
        ListNode node = new ListNode(0,head);
        ListNode tmp = node;
        while (tmp!=null){
            stack.push(tmp);
            tmp = tmp.next;
        }
        for (int i = 0; i < n; i++) {
            stack.pop();
        }
        tmp = stack.peek();
        tmp.next = tmp.next.next;
        return node.next;
    }
}
