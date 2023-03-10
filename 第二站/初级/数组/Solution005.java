package 第二站.初级.数组;

/**
 * solution005
 *
 * 给定一个包含红色、白色和蓝色、共 n 个元素的数组nums，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 我们使用整数 0、1 和 2 分别表示红色、白色和蓝色。
 * 必须在不使用库内置的 sort 函数的情况下解决这个问题。

 * @author insis
 * @date 2023/03/09
 */
public class Solution005 {
    public void sortColors1(int[] nums) {
        if (nums.length == 0 || nums ==null){
            return;
        }
        int left = 0;
        int right = nums.length-1;
        for (int i = 0; i <= right; i++) {
            if (nums[i] == 0){
                nums[i] = nums[left];
                nums[left] = 0;
                ++left;
            }
            if (nums[i] == 2) {
                nums[i] = nums[right];
                nums[right] =2;
                --right;
                if (nums[i] != 1){
                    --i;
                }
            }
        }

    }

    public void sortColors2(int[] nums) {
        int p0 = 0,p1 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1){
                nums[i] ^= nums[p1];
                nums[p1] ^= nums[i];
                nums[i] ^= nums[p1];
                p1++;
            } else if (nums[i] == 0) {
                nums[i] ^= nums[p0];
                nums[p0] ^= nums[i];
                nums[i] ^= nums[p0];
                if (p1> p0){
                    nums[i] ^= nums[p1];
                    nums[p1] ^= nums[i];
                    nums[i] ^= nums[p1];
                }
                p1++;
                p0++;
            }
        }
    }
}
