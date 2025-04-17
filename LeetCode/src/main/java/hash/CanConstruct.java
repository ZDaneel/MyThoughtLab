package hash;

import java.util.Arrays;

/**
 * @author leenadz
 * @since 2025-03-23 14:05
 */
public class CanConstruct {

    public static void main(String[] args) {
        CanConstruct canConstruct = new CanConstruct();
        String ransomNote1 = "aa";
        String magazine1 = "ab";
        System.out.println(canConstruct.canConstruct(ransomNote1, magazine1));

        String ransomNote2 = "ab";
        String magazine2 = "aab";
        System.out.println(canConstruct.canConstruct(ransomNote2, magazine2));
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        int[] magArr = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            char c = magazine.charAt(i);
            magArr[(int) c - 'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);
            magArr[(int) c - 'a']--;
            if (magArr[(int) c - 'a'] < 0) return false;
        }
        return true;
    }
}
