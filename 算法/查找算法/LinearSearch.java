package 算法.查找算法;


import 算法.ListNode;

public class LinearSearch {

    /* 线性查找（数组） */
    int linearSearchArray(int[] nums, int target) {
        // 遍历数组
        for (int i = 0; i < nums.length; i++) {
            // 找到目标元素，返回其索引
            if (nums[i] == target) {
                return i;
            }
        }
        // 未找到目标元素，返回 -1
        return -1;
    }

    /* 线性查找（链表） */
    ListNode linearSearchLinkedList(ListNode head, int target) {
        // 遍历链表
        while (head != null) {
            // 找到目标结点，返回之
            if (head.getVal() == target) {
                return head;
            }
            head = head.getNext();
        }
        // 未找到目标结点，返回 null
        return null;
    }


}

