package 算法.排序算法;

/**
 * 选择排序
 *
 * @author insis
 * @date 2023/03/09
 */
public class SelectionSort {
    /**
     * 选择排序
     *
     * @param nums 全国矿工工会
     */
    void selectionSort(int[] nums){
        int i,j,smallINdex;
        for (i = 0; i < nums.length; i++) {
            smallINdex = i;
            for (j = i+1; j < nums.length; j++) {
                if (nums[j] < nums[smallINdex]){
                    smallINdex = j;
                }
            }
            //交换
            nums[smallINdex] ^= nums[j];
            nums[j] ^= nums[smallINdex];
            nums[smallINdex] ^= nums[j];
        }
    }
}
