package 第二站.初级.数组;

//数组第三题：删除排序数组中的重复项
public class Solution003 {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        int k = 0;
        for (int num: nums) {
            if (num > nums[k]){
                nums[++k] = num;
            }
        }
        return k+1;
    }

    public int removeDuplicates1(int[] nums) {
        if (nums.length == 0 || nums == null){
            return 0;
        }
        int k = 0;
        int m = 1;
        while (m< nums.length){
            if (nums[k] != nums[m]){
                //不相邻才执行，不然原地复制没意义
                if ( m-k > 1){
                    nums[k+1] = nums[m];
                }
                k++;
            }
            m++;
        }
        return k+1;
    }


    public static void main(String[] args) {
        int[] nums = {0,0,1,2,3,3,4,5,5};
    }
}
