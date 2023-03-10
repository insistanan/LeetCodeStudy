package 第二站.初级.数组;

/**
 * solution010
 * 反转字符串中的元音字母
 * @author insis
 * @date 2023/03/10
 */
public class Solution010 {
    public String reverseVowels(String s) {
        StringBuffer stringBuffer =new StringBuffer(s);
        int l = 0;
        int r = s.length()-1;
        while (l < r){
            //找到左边的元音
            while (l<r && !isYuanyin(s.charAt(l))){
                l++;
            }
            //找到右边的元音
            while (l<r && !isYuanyin(s.charAt(r))){
                r--;
            }
            //执行交换
            char rc = stringBuffer.charAt(r);
            char lc = stringBuffer.charAt(l);
            stringBuffer.setCharAt(l,rc);
            stringBuffer.setCharAt(r,lc);
            //接着往后遍历
            l++;
            r--;
        }
        return stringBuffer.toString();
    }

    /**
     * 是否是元音字母
     *
     * @param c c
     * @return boolean
     */
    public boolean isYuanyin(char c){
        boolean flag = false;
        if (c == 'A' || c == 'a'){
            flag = true;
        }
        if (c == 'E' || c == 'e'){
            flag = true;
        }
        if (c == 'I' || c == 'i'){
            flag = true;
        }
        if (c == 'O' || c == 'o'){
            flag = true;
        }
        if (c == 'U' || c == 'u'){
            flag = true;
        }
        return flag;
    }

    /**
     * 是否是元音字母
     *
     * @param ch ch
     * @return boolean
     */
    public boolean isVowel(char ch) {
        return "aeiouAEIOU".indexOf(ch) >= 0;
    }

}
