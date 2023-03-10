package 算法.排序算法;

/**
 * 快速排序
 * @author insis
 * @date 2023/03/09
 */
public class QuickSort {

    /* 快速排序 */
    public void quickSort(int[] nums, int leftborder, int rightborder) {
        // 子数组长度为 1 时终止递归
        //函数出口
        if (leftborder >= rightborder){
            return;
        }


        //将左边界设为基准
        int base = nums[leftborder];
        //左指针
        int left = leftborder;
        //右指针
        int right = rightborder;
        //排序
        while(left < right){
            //从右边把比基准小的排出来
            while(left<right && nums[right] >= base){
                //当右边的数大于基准时，不需要排序，右指针缩小
                right--;
                // 当这个循环不满足时，就意味着右边的数小于基准，需要排序，于是在底下紧接着把这个值排到左边
            }

            //把小的排过来
            nums[left] = nums[right];

            //上面排完之后，左指针开始走，排大的
            //从左边把比基准大的排出来
            while(left < right && nums[left] <= base){
                left++;
            }
            //把大的排过去
            nums[right] = nums[left];
        }
        //上面排完了，基准就会到中间，现在left和right相等
        //把基准赋到中间，那么就完成了排序
        nums[left] = base;


        //分而治之，递归
        // 递归左子数组、右子数组
        //左子数组来排序
        quickSort(nums,leftborder,right-1);
        //右子数组来排序
        quickSort(nums,left+1,rightborder);
    }

    public static void main(String[] args) {
        int[] arr = {3,2,1,5,6,4};
        new QuickSort().quickSort(arr,0, arr.length-1);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

}
