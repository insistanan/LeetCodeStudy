package 第二站.初级.数组;

/**
 * 盛最多水的容器
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i])
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水
 * 返回容器可以储存的最大水量。
 * @author insis
 * @date 2023/03/10
 */
public class Solution011 {
    /**
     * 双指针
     * 时间复杂度：O(N)，双指针总计最多遍历整个数组一次
     * 空间复杂度：O(1)，只需要额外的常数级别的空间。
     * @param height 高度
     * @return int
     */
    public int maxArea(int[] height) {
        int shui = 0;
        int l = 0;
        int r = height.length-1;
        int tmp = 0;
        //下标差*其中最小的值
        while (l < r){
            tmp = Math.min(height[l],height[r]) * (r-l);
            //换水
            if (tmp > shui){
                shui = tmp;
            }
            //移动较小的数的指针
            if (height[l]>height[r]){
                r--;
            }else {
                l++;
            }
        }
        return shui;
    }
}
