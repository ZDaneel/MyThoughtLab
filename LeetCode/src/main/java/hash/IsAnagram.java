package hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author leenadz
 * @since 2025-03-22 17:32
 */
public class IsAnagram {

    public static void main(String[] args) {
        System.out.println(new IsAnagram().isAnagram("rat", "var"));
    }

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] countArr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            countArr[(int) (sChar - 'a')]++;
            countArr[(int) (tChar - 'a')]--;
        }
        for (int i = 0; i < 26; i++) {
            if (countArr[i] != 0) return false;
        }
        return true;
    }

    public boolean isAnagram1(String s, String t) {
        if (s.length() != t.length()) return false;
        Map<Character, Integer> map = new HashMap<>(s.length());
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.merge(c, 1, Integer::sum);
        }
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (map.get(c) == null) {
                return false;
            }
            map.put(c, map.get(c) - 1);
            if (map.get(c) == 0) {
                map.remove(c);
            }
        }
        return map.isEmpty();
    }
}
