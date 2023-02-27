package 第一站_新手村;

/**
 * solution001
 * 新手村第一题   1480、一维数组的动态和 https://leetcode.cn/problems/running-sum-of-1d-array/
 * 给你一个数组 nums 。数组「动态和」的计算公式为：runningSum[i] = sum(nums[0]…nums[i])
 * @author insis
 * @date 2023/02/27
 */
public class Solution001 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        arr = new Yiweishuzu().runningSum(arr);
        for (int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }
    }
}
class  Yiweishuzu {
    public int[] runningSum(int[] nums) {
        for (int i = 1; i < nums.length ; i++) {
            nums[i] += nums[i-1];
        }
        return nums;
    }
}
