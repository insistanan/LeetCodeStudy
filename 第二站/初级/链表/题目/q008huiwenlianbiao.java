package 第二站.初级.链表.题目;

import java.util.Stack;

/**
 * 回文链表
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
 * 输入：head = [1,2,2,1]
 * 输出：true
 *
 * 要求：O(n) 时间复杂度和 O(1) 空间复杂度
 * @author insis
 * @date 2023/03/12
 */
public class q008huiwenlianbiao {

    /**
     * 是回文
     * 先用快慢指针找到中间节点，然后比较后面的
     *
     * @param head 头
     * @return boolean
     */
    public boolean isPalindrome1(ListNode head) {
        ListNode fast = head, slow = head;
        //通过快慢指针找到中点
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        //如果fast不为空，说明链表的长度是奇数个
        if (fast != null) {
            slow = slow.next;
        }
        //反转后半部分链表
        slow = reverse(slow);

        fast = head;
        while (slow != null) {
            //然后比较，判断节点值是否相等
            if (fast.val != slow.val) {
                return false;
            }
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }
    //反转链表
    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    /**
     * 栈
     *
     * @param head 头
     * @return boolean
     */
    public boolean isPalindrome2(ListNode head) {
        ListNode temp = head;
        Stack<Integer> stack = new Stack();
        //把链表节点的值存放到栈中
        while (temp != null) {
            stack.push(temp.val);
            temp = temp.next;
        }

        //然后再出栈
        while (head != null) {
            if (head.val != stack.pop()) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    /**
     * 栈优化版
     *
     * @param head 头
     * @return boolean
     */
    public boolean isPalindrome3(ListNode head) {
        if (head == null) {return true;}
        ListNode temp = head;
        Stack<Integer> stack = new Stack();
        //链表的长度
        int len = 0;
        //把链表节点的值存放到栈中
        while (temp != null) {
            stack.push(temp.val);
            temp = temp.next;
            len++;
        }
        // 只需要拿链表的后半部分和前半部分比较即可
        //len长度除以2
        len >>= 1;
        //然后再出栈
        while (len-- >= 0) {
            if (head.val != stack.pop()) {return false;}
            head = head.next;
        }
        return true;
    }

    /**
     * 递归
     *
     * @param head 头
     * @return boolean
     */
    ListNode temp;
    public boolean isPalindrome4(ListNode head) {
        temp = head;
        return check(head);
    }
    private boolean check(ListNode head) {
        if (head == null) {return true;}
        boolean res = check(head.next) && (temp.val == head.val);
        temp = temp.next;
        return res;
    }

}
