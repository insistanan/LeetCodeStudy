package 第二站.初级.数组;

import java.util.Arrays;

/**
 * solution012
 * 长度最小的子数组
 * 给定一个含有 n 个正整数的数组和一个正整数 target
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组，并返回子数组的长度，如果不存在，返回0
 * 如果你已经实现 O(n) 时间复杂度的解法, 请尝试设计一个 O(n log(n)) 时间复杂度的解法。
 * @author insis
 * @date 2023/03/10
 */
public class Solution012 {
    /**
     * 长度最小的子数组
     * 丑陋代码，超出时间限制
     * @param target 目标
     * @param nums   全国矿工工会
     * @return int
     */
    public int minSubArrayLen1(int target, int[] nums) {
        int num = 0;
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            int cur = i;
            int tmp = 0;
            while (tmp < target && cur < nums.length){
                tmp +=nums[cur];
                cur++;
                count++;
            }
            //第一次找到子数组的情况
            if (num == 0){
                if (tmp >=target){
                    num = count;
                }
            }
            //如果有更短子数组的情况
            if (tmp >= target && count < num){
                num = count;
            }
        }

        return num;
    }
    /**
     * 长度最小的子数组
     * 滑动窗口法，上面暴力破解的改进与升级
     *
     * @param target 目标
     * @param nums   全国矿工工会
     * @return int
     */
    public int minSubArrayLen2(int target, int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        int start = 0, end = 0;
        int sum = 0;
        while (end < n) {
            sum += nums[end];
            while (sum >= target) {
                ans = Math.min(ans, end - start + 1);
                sum -= nums[start];
                start++;
            }
            end++;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    /**
     * 长度最小的子数组
     * 前缀和 + 二分查找
     *
     * @param target 目标
     * @param nums   全国矿工工会
     * @return int
     */
    public int minSubArrayLen3(int target, int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        int[] sums = new int[n + 1];
        // 为了方便计算，令 size = n + 1
        // sums[0] = 0 意味着前 0 个元素的前缀和为 0
        // sums[1] = A[0] 前 1 个元素的前缀和为 A[0]
        // 以此类推
        for (int i = 1; i <= n; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }
        for (int i = 1; i <= n; i++) {
            int s = target + sums[i - 1];
            int bound = Arrays.binarySearch(sums, s);
            if (bound < 0) {
                bound = -bound - 1;
            }
            if (bound <= n) {
                ans = Math.min(ans, bound - (i - 1));
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }



    public static void main(String[] args) {
        int[] arr = {2,3,1,2,4,3};
        Solution012 ooo = new Solution012();
        System.out.println(ooo.minSubArrayLen1(7,arr));
    }
}
