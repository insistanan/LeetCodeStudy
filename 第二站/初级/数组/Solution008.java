package 第二站.初级.数组;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * solution008
 * 给你一个下标从 1 开始的整数数组 numbers ，该数组已按 非递减顺序排列  ，请你从数组中找出满足相加之和等于目标数 target 的两个数。
 * @author insis
 * @date 2023/03/10
 */
public class Solution008 {
    /**
     * 两数之和
     * 哈希法，通过map求解
     * map的key无序不可重复
     * O(n)的时间复杂度和空间复杂度，针对无序数组，没有用到这里有序数组的性质，稍差，不过很好理解
     * @param numbers 数字
     * @param target  目标
     * @return {@link int[]}
     */
    public int[] twoSum1(int[] numbers, int target) {
        int[] arr = {-1,-1};
        if (numbers.length < 2){
            return arr;
        }
        Map<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            int tmp = numbers[i];
            int cha = target-tmp;
            if (map.containsKey(cha)){
                //因为numbers的下标从1开始，所以加上1
                arr[0] = map.get(cha) + 1;
                arr[1] = i + 1;
                return arr;
            }
            map.put(tmp,i);
        }
        return arr;
    }

    /**
     * 两数相加
     * 二分查找
     * 固定第一个数，然后寻找第二个数，第二个数等于目标值减去第一个数的差
     * 利用数组的有序性质，可以通过二分查找的方法寻找第二个数。为了避免重复寻找，在寻找第二个数时，只在第一个数的右侧寻找
     * 时间复杂度为O(nlogn)
     * @param numbers 数字
     * @param target  目标
     * @return {@link int[]}
     */
    public int[] twoSum2(int[] numbers, int target) {
        int[] arr = {-1,-1};
        if (numbers.length < 2){
            return arr;
        }
        for (int i = 0; i < numbers.length; ++i) {
            int low = i + 1, high = numbers.length - 1;
            while (low <= high) {
                int mid = (high - low) / 2 + low;
                if (numbers[mid] == target - numbers[i]) {
                    return new int[]{i + 1, mid + 1};
                } else if (numbers[mid] > target - numbers[i]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return arr;
    }

    /**
     * 两数相加
     * 双指针--对撞指针法
     * 用到了 缩减搜索空间 的思想 https://leetcode.cn/problems/two-sum-ii-input-array-is-sorted/solution/yi-zhang-tu-gao-su-ni-on-de-shuang-zhi-zhen-jie-fa/
     * @param numbers 数字
     * @param target  目标
     * @return {@link int[]}
     */
    public int[] twoSum3(int[] numbers, int target) {
        int[] arr = {-1,-1};
        if (numbers.length < 2){
            return arr;
        }
        int i = 0;
        int j = numbers.length - 1;
        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum < target) {
                i++;
            } else if (sum > target) {
                j--;
            } else {
                return new int[]{i+1, j+1};
            }
        }

        return arr;
    }
}
