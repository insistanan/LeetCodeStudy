package 第二站.初级.数组;

//数组第一题：移动零
public class Solution001 {
    //记录0的个数
    public void moveZeroes1(int[] nums) {
        int zeronums = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                zeronums++;   //0的个数加1
            }
            else if(zeronums != 0) {
                nums[i - zeronums] = nums[i];  //前面有几个零就往前面移动几格
                nums[i] = 0;
            }
        }
    }
    //双指针，分两次遍历
    public void moveZeroes2(int[] nums) {
        int slow = 0;
        int fast = 0;
        //第一次循环将非零数往左排
        for (; fast < nums.length; fast++) {
            if (nums[fast]!=0){
                //左移
                nums[slow] = nums[fast];
                ++slow;
            }
        }
        //第二次循环从慢指针开始，把后面的值全部赋值为0
        for (; slow < nums.length;slow++){
            nums[slow] = 0;
        }
    }

    //参考快速排序，两个指针
    public void moveZeroes3(int[] nums) {
        int fast = 0;
        int slow = 0;
        for (;fast< nums.length;fast++){
            if (nums[fast] != 0){
                nums[slow] ^= nums[fast];
                nums[fast] ^= nums[slow];
                nums[slow] ^= nums[fast];
                ++slow;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        new Solution001().moveZeroes3(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
    
}
