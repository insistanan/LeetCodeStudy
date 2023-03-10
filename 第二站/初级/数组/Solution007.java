package 第二站.初级.数组;

/**
 * solution007
 * 合并两个有序数组
 * 使合并后的数组同样按 非递减顺序 排列
 * @author insis
 * @date 2023/03/10
 */
public class Solution007 {
    /**
     * 合并
     *  双指针法--需要辅助空间
     *
     * @param nums1 nums1
     * @param m     米
     * @param nums2 nums2
     * @param n     n
     */
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        int[] tmp = new int[m+n];
        for (int i = 0,k = 0,j = 0,val; i < m+n; i++) {
            if (j == m){
                //j是num1的下标，这里已经把num1遍历完了，剩下全是nums2的
                val = nums2[k++];
            } else if (k == n) {
                //k是num2的下标，这里已经把num2遍历完了，剩下全是nums1的
                val = nums1[j++];
            }else if (nums1[j] < nums2[k]){
                val = nums1[j++];
            }else {
                val = nums2[k++];
            }
            tmp[j+k-1] = val;
        }
        for (int i = 0; i < m+n; i++) {
            nums1[i] = tmp[i];
        }
    }

    /**
     * 合并
     * 逆向双指针法--不需要辅助空间
     * @param nums1 nums1
     * @param m     米
     * @param nums2 nums2
     * @param n     n
     */
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int j = m-1;
        int k = n-1;
        int tail = m+n-1;
        while(j>=0 || k >=0){
            if (j == -1){
                //j是num1的下标，这里已经把num1遍历完了，剩下全是nums2的
                nums1[tail--] = nums2[k--];
            } else if (k == -1) {
                //k是num2的下标，这里已经把num2遍历完了，剩下全是nums1的
                nums1[tail--] = nums1[j--];
            }else if (nums1[j] < nums2[k]){
                nums1[tail--] = nums2[k--];
            }else {
                nums1[tail--] = nums1[j--];
            }
        }
    }
}
