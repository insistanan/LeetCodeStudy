package 第二站.初级.链表.题目;

import java.util.Stack;

/**
 * 移除链表元素
 * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 *
 * @author insis
 * @date 2023/03/12
 */
public class q006removeNodeByval {
    /**
     * 删除元素
     * 虚拟头节点
     * @param head 头
     * @param val  瓦尔
     * @return {@link ListNode}
     */
    public ListNode removeElements1(ListNode head, int val) {
        ListNode node = new ListNode(0,head);
        ListNode tmp = node;
        while (tmp.next != null){
            if (tmp.next.val == val){
                tmp.next = tmp.next.next;
                continue;
            }
            tmp = tmp.next;
        }
        return node.next;
    }

    /**
     * 递归
     *
     * @param head 头
     * @param val  瓦尔
     * @return {@link ListNode}
     */
    public ListNode removeElements2(ListNode head, int val) {
        //程序出口
        if (head == null){
            return  null;
        }
        //递归
        head.next = removeElements2(head.next,val);
        //返回值
        // 简洁写法 return head.val == val ? head.next : head;
        if (head.val == val){
            //如果节点值等于目标值，不返回该节点，返回该节点下一个节点，也就把这个节点删除了
            return head.next;
        }else {
            return head;
        }

    }

    /**
     * 迭代单指针
     *
     * @param head 头
     * @param val  瓦尔
     * @return {@link ListNode}
     */
    public ListNode removeElements3(ListNode head, int val) {
        while( head !=null && head.val == val){
            head = head.next;
        }
        if (head == null){
            return null;
        }
        ListNode cur = head;
        while (cur.next != null){
            if (cur.next.val == val){
                cur.next = cur.next.next;
            }else {
                cur = cur.next;
            }
        }
        return head;
    }

    /**
     * 迭代双指针
     *
     * @param head 头
     * @param val  瓦尔
     * @return {@link ListNode}
     */
    public ListNode removeElements4(ListNode head, int val) {
        while( head !=null && head.val == val){
            head = head.next;
        }
        //前一个节点的指针
        ListNode pre = head;
        //用于迭代的指针
        ListNode tmp = head;
        while (tmp != null){
            if (tmp.val == val){
                pre.next = tmp.next;
            }else {
                pre = tmp;
            }
            tmp = tmp.next;
        }
        return head;
    }

    /**
     * 栈
     *
     * @param head 头
     * @param val  瓦尔
     * @return {@link ListNode}
     */
    public ListNode removeElements5(ListNode head, int val) {
        Stack<ListNode> stack = new Stack<ListNode>();
        while (head != null) {
            if (head.val != val) {
                stack.push(head);
            }
            head = head.next;
        }

        while (!stack.isEmpty()) {
            stack.peek().next = head;
            head = stack.pop();
        }
        return head;
    }

}
