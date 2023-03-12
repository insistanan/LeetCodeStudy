package 第二站.初级.链表.题目;

public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int x) {
        val = x;
        next = null;
    }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

//    public ListNode addAtTailN(ListNode node) {
//        if (this == null){
//            return node;
//        }
//        if (this.next == null){
//            this.next = node;
//            return this;
//        }
//        ListNode tmp = this;
//        while (tmp.next != null){
//            tmp = tmp.next;
//        }
//        tmp.next = node;
//        return this;
//    }
//    public ListNode addAtHeadN(ListNode node) {
//        node.next = this;
//        return node;
//    }
}
