package 第一站_新手村;

/**
 * solution004
 * 新手村第四题   876、链表的中间节点 https://leetcode.cn/problems/middle-of-the-linked-list/
 * 给你单链表的头结点 head ，请你找出并返回链表的中间结点。
 * 如果有两个中间结点，则返回第二个中间结点。
 * @author insis
 * @date 2023/02/27
 */
public class Solution004 {
    public static void main(String[] args) {
        int[] nums = new int[]{0,1,2,3,4,5,6,7};
        ListNode head = new ListNode(nums);
        System.out.println(new LBZJD().middleNode(head));
        System.out.println(head);
    }
}

class ListNode{
    int val;
    ListNode next;
    //无参构造
    ListNode(){}
    ListNode(int val){
        //有参构造
        this.val = val;
    }

    ListNode(int val,ListNode next){
        //有参构造
        this.val = val;this.next = next;
    }
    public ListNode(int[] nums) {
        //通过数组构造
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("arr can not be empty");
        }
        this.val = nums[0];
        ListNode curr = this;
        for (int i = 1; i < nums.length; i++) {
            curr.next = new ListNode(nums[i]);
            curr = curr.next;
        }
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        ListNode cur = this;
        while (cur != null) {
            s.append(cur.val);
            s.append(" -> ");
            cur = cur.next;
        }
        s.append("NULL");
        return s.toString();
    }
}
class LBZJD{
    public ListNode middleNode(ListNode head){
        if (head == null) {return null;}
        //慢指针
        ListNode slow = head;
        //快指针
        ListNode fast = head;
        while (fast != null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
