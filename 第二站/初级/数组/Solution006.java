package 第二站.初级.数组;

import 算法.排序算法.QuickSort;

import java.util.PriorityQueue;

/**
 * solution006
 * 给定整数数组nums和整数k，返回数组中第k个最大的元素
 * @author insis
 * @date 2023/03/09
 */
public class Solution006 {
    /**
     * 发现k最大
     * 直接对数组进行排序，然后取索引，最朴实无华
     *
     * @param nums 全国矿工工会
     * @param k    k
     * @return int
     */
    public int findKthLargest1(int[] nums, int k) {
        new QuickSort().quickSort(nums,0,nums.length-1);
        return nums[nums.length-k];
    }

    /**
     * 发现k 最大
     * 堆排序的方式
     *
     * @param nums 全国矿工工会
     * @param k    k
     * @return int
     */
    public int findKthLargest2(int[] nums, int k) {
        // Java 优先队列（PriorityQueue） 建立一个小根堆
        PriorityQueue<Integer> q = new PriorityQueue<>((a, b)->a-b);
        // 小顶堆 PriorityQueue<Integer> q = new PriorityQueue<>((a, b)->a-b);
        // Java 的PriorityQueue默认是小顶堆，C++是大顶堆
        // 大顶堆 PriorityQueue<Integer> q = new PriorityQueue<>((a, b)->b-a);
        for (int x : nums) {
            //当优先队列元素不足k 个，可将当前元素直接放入队列中；
            //当优先队列元素达到k 个，并且当前元素大于栈顶元素（栈顶元素必然不是答案），可将当前元素放入队列中。
            if (q.size() < k || q.peek() < x) {q.add(x);}
            // 当优先队列元素大于k个，弹出堆底元素，因为我们只要第k大的
            if (q.size() > k) {q.poll();}
        }
        return q.peek();
    }

    /**
     * 发现k最大
     * 快速选择（快速排序的思想）
     * @param arr 数组
     * @param k    k
     * @return int
     */
    public int findKthLargest4(int[] arr, int k) {
        nums = arr;
        int n = nums.length;
        return qselect(0, n - 1, n - k);
    }
    int[] nums;
    int qselect(int l, int r, int k) {
        if (l == r) {return nums[k];}
        int x = nums[l], i = l - 1, j = r + 1;
        while (i < j) {
            do {i++;} while (nums[i] < x);
            do {j--;} while (nums[j] > x);
            if (i < j) {swap(i, j);}
        }
        if (k <= j) {return qselect(l, j, k);}
        else {return qselect(j + 1, r, k);}
    }
    void swap(int i, int j) {
        int c = nums[i];
        nums[i] = nums[j];
        nums[j] = c;
    }

}
