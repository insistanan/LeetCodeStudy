package 第一站_新手村;

/**
 * solution006
 * 新手村第六题   1672、最富有客户的资产总量 https://leetcode.cn/problems/richest-customer-wealth/
 * 给你一个 m x n 的整数网格 accounts ，其中 accounts[i][j] 是第 i位客户在第 j 家银行托管的资产数量。返回最富有客户所拥有的 资产总量 。
 * 客户的 资产总量 就是他们在各家银行托管的资产数量之和。最富有客户就是 资产总量 最大的客户。
 * @author insis
 * @date 2023/02/27
 */
public class Solution006 {
    public static void main(String[] args) {
        int[][] accounts = {
                {1,2,3},    //每一行是客户
                {3,2,1},    //每一列是银行
                {4,5,7},    //1就是第一个客户在第一个银行存了1元
                {6,5,4}};
        System.out.println(new FYKH().maximumWealth(accounts));
    }
}

class FYKH{
    //返回最富有客户的资产数量
    public int maximumWealth(int[][] accounts) {
        int result = 0;
        //列数
        int row = accounts[0].length;
        //行数
        int col = accounts.length;
        for (int i = 0; i < col; i++) {
            int temp = 0;
            for (int j = 0; j < row; j++) {
                temp+=accounts[i][j];
            }
            result = result > temp ? result : temp;
        }
        return result;
    }
}
