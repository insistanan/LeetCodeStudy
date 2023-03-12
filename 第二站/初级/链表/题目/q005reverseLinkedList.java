package 第二站.初级.链表.题目;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 反转链表
 *
 * @author insis
 * @date 2023/03/11
 */
public class q005reverseLinkedList {
    /**
     * 反转链表
     *
     * @param head 头
     * @return {@link ListNode}
     */
    public ListNode reverseList1(ListNode head) {
        //辅助栈
        Deque<ListNode> stack = new LinkedList<>();
        // Stack<ListNode> stack = new Stack<>();
        // Stack线程安全，但是不推荐使用，比较慢
        while (head != null){
            stack.push(head);
            head = head.next;
        }
        if (stack.isEmpty()) {return null;}
        //栈中的结点全部出栈，然后重新连成一个新的链表
        ListNode tmp = stack.pop();
        ListNode node = tmp;
        while (!stack.isEmpty()){
            tmp.next = stack.pop();
            tmp = tmp.next;
        }
        //最后一个结点就是反转前的头结点，一定要让他的next
        //等于空，否则会构成环
        tmp.next = null;
        return node;
    }

    /**
     * 头插法
     *
     * @param head 头
     * @return {@link ListNode}
     */
    public ListNode reverseList2(ListNode head) {
        ListNode node = null;
        while (head!=null){
            ListNode tmp = head.next;
            head.next = node;
            node = head;
            head = tmp;
        }
        return node;
    }
}
