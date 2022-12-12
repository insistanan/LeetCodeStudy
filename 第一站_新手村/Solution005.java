package 第一站_新手村;

// 新手村第五题   1342、将数字变成0的操作次数
public class Solution005 {
    public static void main(String[] args) {
        System.out.println(new bian0().numberOfSteps(5));
    }
}
class bian0{
    public int numberOfSteps(int num) {
        int cishu = 0;
        while (num!=0){
            //如果是偶数，除以二
            if ( (num & 0x01) == 0){    //  num & 0x01   num和十六进制的1进行与运算，判断是偶数还是奇数，偶数为0，奇数为1
                num >>= 1;   //右移一位，除以二
            }
            //如果是奇数，减一
            else {
                num-=1;
            }
            cishu+=1;
        }
        return cishu;
    }
}
