package 第一站_新手村;

/**
 * solution002
 * 新手村第二题   383、赎金信 https://leetcode.cn/problems/ransom-note/
 * 给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
 * 如果可以，返回 true ；否则返回 false 。
 * magazine 中的每个字符只能在 ransomNote 中使用一次。
 * @author insis
 * @date 2023/02/27
 */
public class Solution002 {
    public static void main(String[] args) {

        String ransomNote = "abccc";
        String magazine = "aabc";
        System.out.println(new Shujinxin().canConstruct(ransomNote,magazine));
    }
}
class Shujinxin {
    public boolean canConstruct(String ransomNote, String magazine) {
        if ( ransomNote.length() > magazine.length() || ransomNote.length() == 0) {
            return false;
        }else{
            //定义一个26位的数组，用来存储字母的个数，索引0是a的个数
            int[] temp = new int[26];
            //读取匹配字符串的字母，并记录个数
            for( char c : magazine.toCharArray()){
                temp[c-'a']++;
                //char c 是 magazine的各个字符，比如magazine是abc，那么c分别就是'a' 'b' 'c' ， 'a' - 'a' = 0,'b'-'a'=1,就能够对应上各自的下标，然后  temp[i]++
            }
            //根据个数匹配目标字符串的字母个数，验证目标字符串是否能被匹配字符串组成
            for ( char c : ransomNote.toCharArray()){
                temp[c - 'a']--;
                //判断各个字母个数，如果小于0，则不匹配了
                if (temp[c - 'a'] < 0){
                    return false;
                }
            }
        }
        return true;
    }
}
