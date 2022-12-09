package 新手村;

import java.util.ArrayList;
import java.util.List;

// 新手村第三题   412、Fizz Buzz
public class Solution003 {
    public static void main(String[] args) {
        List<String> strings = new FB().fizzBuzz(3);
        for (String s : strings){
            System.out.println(s);
        }
    }
}


class FB {
    public List<String> fizzBuzz(int n) {
        List<String> fb = new ArrayList<>(n);
        StringBuffer sb = new StringBuffer();
        if (n <= 0) {
            sb.append("error");
            fb.add(sb.toString());
            return fb;
        }
        fb.add("1");
        for (int i = 1; i < n; i++) {
            if (i % 3 == 0 ){
                sb.append("Fizz");
            }
            if (i % 5 == 0){
                sb.append("Buzz");
            }
            if (i % 3 != 0 && i % 5 != 0){
                sb.append(i+1);
            }
            fb.add(sb.toString());
            /*sb.delete(0,sb.length());*/
            sb.setLength(0);
        }
        return fb;
    }
}
