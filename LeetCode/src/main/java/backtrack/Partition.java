package backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author leenadz
 * @since 2025-04-20 11:54
 */
public class Partition {
    public static void main(String[] args) {
        Partition partition = new Partition();
        System.out.println(partition.partition("aac"));
        System.out.println(partition.partition("a"));
    }


    List<List<String>> resList;
    List<String> path;

    public List<List<String>> partition(String s) {
        resList = new ArrayList<>();
        path = new ArrayList<>();
        makePartition(s, 0, new StringBuilder());
        return resList;
    }

    // 没写出来，一开始不理解递归和循环的配合
    private void makePartition(String s, int startIndex, StringBuilder sb) {
        if (startIndex == s.length()) {
            resList.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            sb.append(s.charAt(i));
            if (isPalindrome(sb)) {
                path.add(sb.toString());
                makePartition(s, i + 1, new StringBuilder());
                path.removeLast();
            }
        }
    }

    private boolean isPalindrome(StringBuilder sb) {
        for (int i = 0; i < sb.length() / 2; i++) {
            if (sb.charAt(i) != sb.charAt(sb.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
