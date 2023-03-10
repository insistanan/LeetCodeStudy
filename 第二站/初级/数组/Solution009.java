package 第二站.初级.数组;

/**
 * solution009
 * 回文字符串
 * @author insis
 * @date 2023/03/10
 */
public class Solution009 {
    /**
     * 是回文
     * 筛选 + 判断  -- 利用StringBuffer的reverse方法翻转字符串
     * @param s 年代
     * @return boolean
     */
    public boolean isPalindrome1(String s) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)){
                //java.lang.Character.isLetterOrDigit(char ch) 这个方法确定指定的字符是否为字母或数字。字符被认为是字母或数字，如果字符是字母或数字则此方法返回true，否则为false
                stringBuffer.append(Character.toLowerCase(ch));
                //变成小写
            }
        }
        //利用StringBuffer的reverse方法翻转字符串
        StringBuffer stringBuffer_reverse = new StringBuffer(stringBuffer).reverse();
        return stringBuffer_reverse.toString().equals(stringBuffer.toString());
    }

    /**
     * 是回文
     * 双指针
     * @param s 年代
     * @return boolean
     */
    public boolean isPalindrome2(String s) {
        StringBuffer sgood = new StringBuffer();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                sgood.append(Character.toLowerCase(ch));
            }
        }
        int n = sgood.length();
        int left = 0, right = n - 1;
        while (left < right) {
            if ( sgood.charAt(left) != sgood.charAt(right) ) {
                return false;
            }
            ++left;
            --right;
        }
        return true;
    }
}
