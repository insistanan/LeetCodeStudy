package 算法.查找算法;

import 算法.ListNode;
import java.util.Map;

public class HashSearch {
    //线性查找太慢，二分查找要求有序，哈希查找则能同时避免以上缺点（缺点是耗费更多空间）

    /* 哈希查找（数组） */
    int hashingSearchArray(Map<Integer, Integer> map, int target) {
        // 哈希表的 key: 目标元素，value: 索引
        // 若哈希表中无此 key ，返回 -1
        return map.getOrDefault(target, -1);
    }

    /* 哈希查找（链表） */
    ListNode hashingSearchLinkedList(Map<Integer, ListNode> map, int target) {
        // 哈希表的 key: 目标结点值，value: 结点对象
        // 若哈希表中无此 key ，返回 null
        return map.getOrDefault(target, null);
    }



}
