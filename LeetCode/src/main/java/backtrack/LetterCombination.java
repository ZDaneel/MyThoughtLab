package backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author leenadz
 * @since 2025-04-07 21:46
 */
public class LetterCombination {
    public static void main(String[] args) {
        LetterCombination letterCombination = new LetterCombination();
        System.out.println(letterCombination.letterCombinations("23"));
        System.out.println(letterCombination.letterCombinations("234"));
        System.out.println(letterCombination.letterCombinations("2"));
        System.out.println(letterCombination.letterCombinations(""));
    }

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return new ArrayList<>();
        }
        List<String> resList = new ArrayList<>();
        List<Character> path = new ArrayList<>();
        return makeLetter(digits, 0, path, resList);
    }

    public List<String> makeLetter(String digits, int index, List<Character> path, List<String> resList) {
        if (path.size() == digits.length()) {
            StringBuilder sb = new StringBuilder();
            for (Character c : path) {
                sb.append(c);
            }
            resList.add(String.valueOf(sb));
        } else {
            String numStr = getNumString(digits.charAt(index) - 48);
            if (numStr != null) {
                for (int i = 0; i < numStr.length(); i++) {
                    path.add(numStr.charAt(i));
                    makeLetter(digits, index + 1, path, resList);
                    path.removeLast();
                }
            }
        }
        return resList;
    }

    private String getNumString(int c) {
        String[] strArr = {
                null, // 0
                null, // 1
                "abc", // 2
                "def", // 3
                "ghi", // 4
                "jkl", // 5
                "mno", // 6
                "pqrs", // 7
                "tuv", // 8
                "wxyz", // 9
        };
        return strArr[c];
    }

    private String getNumString2(int c) {
        if (2 == c) {
            return "abc";
        } else if (3 == c) {
            return "def";
        } else if (4 == c) {
            return "ghi";
        } else if (5 == c) {
            return "jkl";
        } else if (6 == c) {
            return "mno";
        } else if (7 == c) {
            return "pqrs";
        } else if (8 == c) {
            return "tuv";
        } else if (9 == c) {
            return "wxyz";
        } else {
            return null;
        }
    }

}
