package 第二站.初级.数组;

//数组第二题：移除元素
public class Solution002 {
    //原地删除并且保证元素相对顺序
    public int removeElement1(int[] nums, int val) {
        int fast = 0;
        int slow = 0;
        for (;fast< nums.length;fast++){
            if (nums[fast]!=val){
                nums[slow++] = nums[fast];
            }
        }
        return  slow;
    }
    //删除，不保证顺序
    public int removeElement2(int[] nums, int val) {
        int right = nums.length;
        int left = 0;
        while (left<right){
            if (nums[left] == val){
                nums[left] = nums[right-1];
                right--;
            }
            else {left++;}
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums = {2,0,1,2,2,3,2};
        System.out.println(new Solution002().removeElement2(nums, 2)+",");
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
}
