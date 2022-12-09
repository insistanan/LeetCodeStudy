package 新手村;

import java.util.ArrayList;
import java.util.List;

// 新手村第三题   412、Fizz Buzz
public class Solution003 {
    public static void main(String[] args) {
        List<String> strings = new FB().fizzBuzz2(16);
        for (String s : strings){
            System.out.println(s);
        }
    }
}


class FB {
    //解法一
    public List<String> fizzBuzz(int n) {
        List<String> fb = new ArrayList<>(n);
        StringBuffer sb = new StringBuffer();
        if (n <= 0) {
            sb.append("error");
            fb.add(sb.toString());
            return fb;
        }
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 ){
                sb.append("Fizz");
            }
            if (i % 5 == 0){
                sb.append("Buzz");
            }
            if (i % 3 != 0 && i % 5 != 0){
                sb.append(i);
            }
            fb.add(sb.toString());
            /*sb.delete(0,sb.length());*/
            sb.setLength(0);
        }
        return fb;
    }
    //解法二
    public List<String> fizzBuzz2(int n){
        List<String> fb = new ArrayList<>();
        if ( n <= 0) {
            fb.add("error");
            return fb;
        }
        for (int i = 1; i <= n; i++) {
            if (i%3==0 && i%5==0){
                fb.add("FizzBuzz");
            }else if (i%3==0){
                fb.add("Fizz");
            }else if (i%5==0){
                fb.add("Buzz");
            }else {
                fb.add(Integer.toString(i));
            }
        }
        return fb;
    }
}
