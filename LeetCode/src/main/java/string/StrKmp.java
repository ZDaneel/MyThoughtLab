package string;

/**
 * @author leenadz
 * @since 2025-03-24 18:25
 */
public class StrKmp {

    public static void main(String[] args) {
        StrKmp strKmp = new StrKmp();
        String haystack1 = "aaaaa";
        String needle1 = "bba";
        String haystack2 = "sadbutsad";
        String needle2 = "sad";
        String haystack3 = "hello";
        String needle3 = "ll";
        String haystack4 = "aaa";
        String needle4 = "aaaa";
        String haystack5 = "miss";
        String needle5 = "a";
        String haystack6 = "a";
        String needle6 = "a";
        String haystack7 = "mississippi";
        String needle7 = "sippia";
        String haystack8 = "aabaababcabaaba";
        String needle8 = "aabaabaa";


        System.out.println(-1 == strKmp.strStr(haystack1, needle1));
        System.out.println(0 == strKmp.strStr(haystack2, needle2));
        System.out.println(2 == strKmp.strStr(haystack3, needle3));
        System.out.println(-1 == strKmp.strStr(haystack4, needle4));
        System.out.println(-1 == strKmp.strStr(haystack5, needle5));
        System.out.println(0 == strKmp.strStr(haystack6, needle6));
        System.out.println(-1 == strKmp.strStr(haystack7, needle7));
        System.out.println(strKmp.strStr(haystack8, needle8));
    }

    public int strStr(String s, String t) {
        int i = 0;
        int j = 0;
        int lenS = s.length();
        int lenT = t.length();
        int[] next = getNext(t);
        while (i < lenS && j < lenT) {
            if (j == -1 || s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        if (j == lenT) {
            return (i - j);
        } else {
            return -1;
        }
    }

    private int[] getNext(String t) {
        int j = -1;
        int i = 0;
        int[] next = new int[t.length()];
        next[0] = -1;
        while (i < t.length() - 1) {
            if (j == -1 || t.charAt(i) == t.charAt(j)) {
                i++;
                j++;
                next[i] = j;
            } else {
                j = next[j];
            }
        }
        return next;
    }

    public int strStr1(String haystack, String needle) {
        if (needle.length() > haystack.length()) return -1;
        int i = 0;
        int j = 0;
        int[] next = getNext(needle);
        while (i < haystack.length()) { // O(M)
            if (haystack.charAt(i) == needle.charAt(j)) {
                if (j == needle.length() - 1) {
                    break;
                }
                i++;
                j++;
            } else {
                if (j == 0) {
                    i++;
                } else {
                    j = next[j - 1];
                }
            }
        }
        if (i == haystack.length() || j < needle.length() - 1) {
            return -1;
        } else {
            return i - needle.length() + 1;
        }
    }

    private int[] getNext2(String needle) {
        int[] res = new int[needle.length()];
        for (int i = 0; i < needle.length(); i++) {
            int maxCount = 0;
            int len = 0;
            String substring = needle.substring(0, i + 1);
            while (len < substring.length()) {
                if (hasSame(substring, len)) {
                    maxCount = len++;
                } else {
                    len++;
                }
            }
            res[i] = maxCount;
        }
        return res;
    }

    private boolean hasSame(String substring, int len) {
        if (len == 0) return false;
        if (substring.length() == 1) return false;
        if (substring.length() == 2 && substring.charAt(0) != substring.charAt(1)) return false;
        int left = 0;
        int right = substring.length() - len;
        for (int i = 0; i < len; i++) {
            if (substring.charAt(left) == substring.charAt(right)) {
                left++;
                right++;
            } else {
                return false;
            }
        }
        return true;
    }
}
