package 算法.排序算法;

/**
 * 冒泡排序，最基础的排序算法
 *
 * @author insis
 * @date 2023/03/09
 */
public class BubbleSort {
    /**
     * 冒泡排序
     *
     * @param nums 全国矿工工会
     */
    void bubbleSort(int[] nums){
        for (int i = nums.length-1; i > 0 ; i--) {
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[j+1]){
                    //交换nums[j]和nums[j+1]
                    nums[j] ^= nums[j+1];
                    nums[j+1] ^= nums[j];
                    nums[j] ^= nums[j+1];
                }
            }
        }
    }
    /* 冒泡排序（标志优化）*/
    void bubbleSortWithFlag(int[] nums) {
        // 外循环：待排序元素数量为 n-1, n-2, ..., 1
        for (int i = nums.length - 1; i > 0; i--) {
            boolean flag = true; // 初始化标志位，有序
            // 内循环：冒泡操作
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[j + 1]) {
                    flag = false;  // 非有序
                    //交换nums[j]和nums[j+1]
                    nums[j] ^= nums[j+1];
                    nums[j+1] ^= nums[j];
                    nums[j] ^= nums[j+1];

                }
            }
            if (flag) {
                // 有序，直接跳出
                break;
            }
        }
    }
    /* 冒泡排序（标志优化基础上优化，记录最后一次交换的下标）*/
    void bubbleSortWithFlagAndLastChangeIndex(int[] nums) {
        int lastChangeIndex = 0;
        int border = nums.length-1;
        // 外循环：待排序元素数量为 n-1, n-2, ..., 1
        for (int i = nums.length - 1; i > 0; i--) {
            boolean flag = true; // 初始化标志位，有序
            // 内循环：冒泡操作
            for (int j = 0; j < border; j++) {
                if (nums[j] > nums[j + 1]) {
                    flag = false;  // 非有序
                    //交换nums[j]和nums[j+1]
                    nums[j] ^= nums[j+1];
                    nums[j+1] ^= nums[j];
                    nums[j] ^= nums[j+1];
                    //记录最后一次交换的下标
                    lastChangeIndex = j;
                }
            }
            //将边界变为最后一次交换的下标
            border = lastChangeIndex;
            if (flag) {
                // 有序，直接跳出
                break;
            }
        }
    }

    /* 冒泡排序（双向冒泡，鸡尾酒算法）*/
    void bubbleSortJiweijiu(int[] nums){
        //定义左边界
        int leftborder = 0;
        //定义右边界
        int rightborder = nums.length-1;
        //定义左/右最后一次交换的下标
        int lastLeftIndex = 0,lastRightIndex = 0;
        for (int i = 0; i < nums.length-1; i++) {
            //有序标志
            boolean flag = true;
            //排过去最大的
            for (int j = leftborder;j < rightborder;j++){
                if (nums[j] > nums[j+1]){
                    //非有序，需要交换，先把标记变为false
                    flag = false;
                    //进行交换
                    nums[j] ^= nums[j+1];
                    nums[j+1] ^= nums[j];
                    nums[j] ^= nums[j+1];
                    //记录最后一次交换的右侧下标
                    lastRightIndex = j;
                }
            }
            //将右边界变为最后一次交换的右侧下标
            rightborder = lastRightIndex;
            //中场休息，先判断是否有序，有序直接跳，不然将有序标志重新变为ture，进行接下来的排序
            if (flag) {
                break;
            }
            flag = true;

            //排过来最小的
            for (int j = rightborder;j > leftborder;j--){
                if (nums[j] < nums[j-1]){
                    //非有序，需要交换，先把标记变为false
                    flag = false;
                    //进行交换
                    nums[j] ^= nums[j-1];
                    nums[j-1] ^= nums[j];
                    nums[j] ^= nums[j-1];
                    //记录最后一次交换的左侧下标
                    lastLeftIndex = j;
                }
            }
            //将左边界变为最后一次交换的左侧下标
            leftborder = lastLeftIndex;
            if (flag) {
                //如果是有序列表，不用再遍历排序了，跳出循环
                break;
            }
        }
    }
}
