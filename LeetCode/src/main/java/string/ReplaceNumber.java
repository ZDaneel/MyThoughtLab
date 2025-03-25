package string;

import java.util.Scanner;

/**
 * @author leenadz
 * @since 2025-03-24 13:58
 */
public class ReplaceNumber {
    public static void main(String[] args) {
//        String s1 = "a1b2c3";
//        System.out.println(new ReplaceNumber().replace(s1));

        // acl格式？
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int len = s.length();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                len += 5;
            }
        }
        char[] ret = new char[len];
        for (int i = 0; i < s.length(); i++) {
            ret[i] = s.charAt(i);
        }
        for (int i = s.length() - 1, j = len - 1; i >= 0; i--) {
            if ('0' <= ret[i] && ret[i] <= '9') {
                ret[j--] = 'r';
                ret[j--] = 'e';
                ret[j--] = 'b';
                ret[j--] = 'm';
                ret[j--] = 'u';
                ret[j--] = 'n';
            } else {
                ret[j--] = ret[i];
            }
        }
        System.out.println(ret);
    }

    public String replace(String str) {
        char[] charArray = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c : charArray) {
            if (Character.isDigit(c)) {
                sb.append("number");
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }


}
