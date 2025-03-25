package string;

/**
 * @author leenadz
 * @since 2025-03-25 12:05
 */
public class RepeatedSubstringPattern {

    public static void main(String[] args) {
        RepeatedSubstringPattern repeatedSubstringPattern = new RepeatedSubstringPattern();
        String s1 = "abab";
        String s2 = "aba";
        String s3 = "abcabcabcabc";
        String s4 = "abcabcabc";
        System.out.println(repeatedSubstringPattern.repeatedSubstringPattern(s1));
        System.out.println(repeatedSubstringPattern.repeatedSubstringPattern(s2));
        System.out.println(repeatedSubstringPattern.repeatedSubstringPattern(s3));
        System.out.println(repeatedSubstringPattern.repeatedSubstringPattern(s4));
    }

    public boolean repeatedSubstringPattern(String s) {
        String s2 = s + s;
        int len = s2.indexOf(s, 1);
        return len != s.length();
    }
}
