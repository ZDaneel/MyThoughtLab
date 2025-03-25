package string;

/**
 * @author leenadz
 * @since 2025-03-23 21:29
 */
public class ReverseString {

    public static void main(String[] args) {
        ReverseString reverseString = new ReverseString();
        char[] s1 = {'h','e','l','l','o'};
        char[] s2 = {'H', 'a', 'n', 'n', 'a', 'h'};
        // s[i] 都是 ASCII 码表中的可打印字符
        System.out.println(s1);
        reverseString.reverseString(s1);
        System.out.println(s1);
        System.out.println(s2);
        reverseString.reverseString(s2);
        System.out.println(s2);
    }

    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
}
