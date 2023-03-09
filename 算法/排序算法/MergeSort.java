package 算法.排序算法;

import java.util.Arrays;

/**
 * 归并排序
 *
 * 划分阶段：通过递归不断 将数组从中点位置划分开，将长数组的排序问题转化为短数组的排序问题；
 * 合并阶段：划分到子数组长度为 1 时，开始向上合并，不断将 左、右两个短排序数组 合并为 一个长排序数组，直至合并至原数组时完成排序；
 * 归并排序的递归顺序就是二叉树的「后序遍历」
 * 后序遍历：先递归左子树、再递归右子树、最后处理根结点。
 * 归并排序：先递归左子树、再递归右子树、最后处理合并。
 * @author insis
 * @date 2023/03/09
 */
public class MergeSort {

    /* 归并排序 */
    void mergeSort(int[] nums, int left, int right) {
        // 终止条件
        if (left >= right) {return;}
        // 划分阶段
        int mid = left + (right - left) / 2;    // 计算中点
        mergeSort(nums, left, mid);      // 递归左子数组
        mergeSort(nums, mid + 1, right); // 递归右子数组
        // 合并阶段
        merge(nums, left, mid, right);
    }

    /* 合并左子数组和右子数组 */
    // 左子数组区间 [left, mid]
    // 右子数组区间 [mid + 1, right]
    void merge(int[] nums, int left, int mid, int right) {
        // 初始化辅助数组
        int[] tmp = Arrays.copyOfRange(nums, left, right + 1);
        // 左子数组的起始索引和结束索引
        int leftStart = left - left, leftEnd = mid - left;
        // 右子数组的起始索引和结束索引
        int rightStart = mid + 1 - left, rightEnd = right - left;
        // i, j 分别指向左子数组、右子数组的首元素
        int i = leftStart, j = rightStart;
        // 通过覆盖原数组 nums 来合并左子数组和右子数组
        for (int k = left; k <= right; k++) {
            // 若“左子数组已全部合并完”，则选取右子数组元素，并且 j++
            if (i > leftEnd)
                nums[k] = tmp[j++];
                // 否则，若“右子数组已全部合并完”或“左子数组元素 <= 右子数组元素”，则选取左子数组元素，并且 i++
            else if (j > rightEnd || tmp[i] <= tmp[j])
                nums[k] = tmp[i++];
                // 否则，若“左右子数组都未全部合并完”且“左子数组元素 > 右子数组元素”，则选取右子数组元素，并且 j++
            else
                nums[k] = tmp[j++];
        }
    }
}
