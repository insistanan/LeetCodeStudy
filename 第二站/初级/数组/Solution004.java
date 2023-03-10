package 第二站.初级.数组;

public class Solution004 {
    //原地删除有序数组中重复出现的元素，使得出现次数超过2次的元素只出现2次，返回删除后数组的新长度
    public int removeDuplicates1(int[] nums) {
        if (nums.length == 0 || nums == null){
            return 0;
        }
        int len = 0;
        for (int i = 0; i < nums.length; i++) {
            if (len < 2 || nums[i] != nums[len-2]){
                nums[len++] = nums[i];
            }
        }
        //改变len < n || nums[i] != nums[len - n] 中n值可适用于保留n重复项题目
        return len;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,1,1,2,2,3,3,3,4,4,4,4,4,5};
        new Solution004().removeDuplicates1(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
}
