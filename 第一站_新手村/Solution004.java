package 第一站_新手村;

// 新手村第四题   876、链表的中间节点
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
    ListNode(){}     //无参构造
    ListNode(int val){this.val = val;}   //有参构造
    ListNode(int val,ListNode next){this.val = val;this.next = next;}    //有参构造
    public ListNode(int[] nums) {    //通过数组构造
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
        ListNode slow = head;    //慢指针
        ListNode fast = head;    //快指针
        while (fast != null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
