package 第二站.初级.链表.题目;

/**
 * 相交链表
 * 不断的去对方的轨迹中寻找对方的身影，只要二人有交集，就终会相遇！
 * @author insis
 * @date 2023/03/11
 */
public class q003IntersectionLinkedList {
    /**
     * 得到交叉节点
     * 双指针
     * 你也走过我来的路
     * @param roadA
     * @param roadB
     * @return {@link ListNode}
     */
    public ListNode getIntersectionNode1(ListNode roadA, ListNode roadB) {
        //定义指向两个链表的指针
        ListNode i = roadA;
        ListNode u = roadB;
        while (i != u){
            i =  ( i == null ? roadB :i.next );
            u =  ( u == null ? roadA :u.next );
        }
        return u;
    }

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode p1 = headA, p2 = headB;
        //变轨次数
        int cnt=0;
        while (p1 != null && p2 != null) {
            if (p1 == p2) {return p1;}
            p1 = p1.next;
            p2 = p2.next;
            //p1变轨
            if(cnt<2&&p1==null){
                p1=headB;
                cnt++;
            }
            //p2变轨
            if(cnt<2&&p2==null){
                p2=headA;
                cnt++;
            }
        }
        return null;
    }

}

