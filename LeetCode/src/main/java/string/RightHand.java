package string;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author leenadz
 * @since 2025-03-24 16:30
 */
public class RightHand {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        String s = sc.next();
        // 反转整个，再分别反转
        char[] charArray = s.toCharArray();
        reverseString(charArray, 0, charArray.length - 1);
        reverseString(charArray, 0, k - 1);
        reverseString(charArray, k, s.length() - 1);

        // 开辟了新的空间
//        char[] res = new char[s.length()];
//        int resPos = 0;
//        for (int i = s.length() - k; i < s.length(); i++) {
//            res[resPos++] = s.charAt(i);
//        }
//        for (int i = 0; i < s.length() - k; i++) {
//            res[resPos++] = s.charAt(i);
//        }
//        System.out.println(new String(res));
    }

    public static void reverseString(char[] ch, int start, int end) {
        while (start < end) {
            ch[start] ^= ch[end];
            ch[end] ^= ch[start];
            ch[start] ^= ch[end];
            start++;
            end--;
        }
    }
}
