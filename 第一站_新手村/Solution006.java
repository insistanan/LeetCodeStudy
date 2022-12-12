package 第一站_新手村;
// 新手村第六题   1672、最富有客户的资产总量
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
