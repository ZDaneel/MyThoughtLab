package string;

import java.util.Arrays;

/**
 * @author leenadz
 * @since 2025-03-23 21:48
 */
public class ReverseStr2K {

    public static void main(String[] args) {
        ReverseStr2K reverseStr2K = new ReverseStr2K();
        String s1 = "abcdefg";
        String s2 = "abcd";
        String s3 = "abcdefgh";

//        System.out.println(reverseStr2K.reverseStr(s1, 2));
//        System.out.println(reverseStr2K.reverseStr(s2, 2));
//        System.out.println(reverseStr2K.reverseStr(s3, 3));
        System.out.println(reverseStr2K.reverseStr(s2, 4));
    }

    public String reverseStr(String s, int k) {
        char[] charArray = s.toCharArray();
        int cur = 0;
        int length = charArray.length;
        int rest = length;
        while (rest > 0) {
            if (rest < k) {
                reserve(charArray, cur, length - 1);
                break;
            } else if (rest < (2 * k)) {
                reserve(charArray, cur, cur + k - 1);
                break;
            } else {
                reserve(charArray, cur, cur + k - 1);
                cur += 2 * k;
                rest = length - cur;
            }
        }
        return String.valueOf(charArray);
    }

    private void reserve(char[] charArray, int left, int right) {
        while(left < right) {
            char temp = charArray[left];
            charArray[left] = charArray[right];
            charArray[right] = temp;
            left++;
            right--;
        }
    }
}
