package 第二站.初级.链表.题目;

import 第二站.初级.链表.定义单链表.MyLinkedList;
import 第二站.初级.链表.定义单链表.Node;

/**
 * 判断链表是否有环
 *
 * @author insis
 * @date 2023/03/11
 */
public class q001HasCycle1 {
    /**
     * 是否有环
     * 使用快慢指针来判断
     * 如果有环，那么不管快慢，指针最终都会到环里转，只要是绕圈，那么快指针一定会追上满指针，这样就能判断是否有环了
     * @param linkedList 头
     * @return boolean
     */
    public boolean hasCycle(MyLinkedList linkedList) {
        if (linkedList.getHead() == null){
            return false;
        }
        //快慢指针
        Node fast = linkedList.getHead();
        Node slow = linkedList.getHead();
        while (fast != null && slow != null){
            //慢指针每次走一步
            slow = slow.getNext();
            //快指针每次走两步
            fast = fast.getNext().getNext();
            //如果相遇，说明有环，直接返回ture
            if (fast == slow){
                return true;
            }
        }
        return false;
    }
}
