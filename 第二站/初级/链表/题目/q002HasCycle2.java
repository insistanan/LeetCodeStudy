package 第二站.初级.链表.题目;


import java.util.HashSet;
import java.util.Set;

/**
 * 判断链表是否有环2
 * 返回链表开始入环的第一个节点
 * @author insis
 * @date 2023/03/11
 */
public class q002HasCycle2 {

    /**
     * 检测周期
     * [参考](https://pic.leetcode-cn.com/1623750708-inrvVm-1623750459597.jpg)
     * @param head 头
     * @return {@link ListNode}
     */
    public ListNode detectCycle1(ListNode head) {
        //定义快慢指针
        ListNode fast = head,slow = head;
        //快慢指针相遇
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            //第一次相遇 退出循环
            if (fast == slow){
                break;
            }
        }
        //判断是否有环
        if (fast == null || fast.next == null){
            //无环
            return null;
        }
        //有环 将快指针移至head并重新以一格的速度走
        fast = head;
        while (fast!=slow){
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }

    /**
     * 检测cycle2
     * 存放到集合中 -- 比较慢
     * 如果有环，就会出现重复的，然后返回第一个重复的节点
     * @param head 头
     * @return {@link ListNode}
     */
    public ListNode detectCycle2(ListNode head){
        //创建一个集合
        Set<ListNode> set = new HashSet<>();
        //集合，无序不可重复
        ListNode tmp = head;
        while (tmp != null){
            if (!set.add(tmp)){
                return tmp;
            }
            tmp = tmp.next;
        }
        return null;
    }
}
