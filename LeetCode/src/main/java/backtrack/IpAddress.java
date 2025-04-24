package backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author leenadz
 * @since 2025-04-20 13:20
 */
public class IpAddress {
    public static void main(String[] args) {
        IpAddress ipAddress = new IpAddress();
        System.out.println(ipAddress.restoreIpAddresses("25525511135"));
        System.out.println(ipAddress.restoreIpAddresses("0123"));
        System.out.println(ipAddress.restoreIpAddresses("101023"));
    }

    List<String> resList;
    StringBuilder path;
    int dotCount;

    public List<String> restoreIpAddresses(String s) {
        path = new StringBuilder();
        resList = new ArrayList<>();
        dotCount = 0;
        findIp(s, 0, new StringBuilder());
        return resList;
    }

    private void findIp(String s, int startIndex, StringBuilder sb) {
        if (startIndex == s.length() && 4 == dotCount) {
            resList.add(new String(path).substring(0, path.length() - 1));
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            sb.append(s.charAt(i));
            if (isIp(sb)) {
                path.append(sb);
                path.append(".");
                dotCount++;
                if (dotCount <= 4) {
                    findIp(s, i + 1, new StringBuilder());
                }
                path.delete(path.length() - sb.length() - 1, path.length());
                dotCount--;
            }
        }
    }

    private boolean isIp(StringBuilder sb) {
        if (sb.length() > 1 && (sb.charAt(0) - '0') == 0) {
            return false;
        }
        if (sb.length() > 3) {
            return false;
        }
        int num =Integer.parseInt(sb.toString());
        return num >= 0 && num <= 255;
    }

    // 优化，最后判断一次，而不是在中间判断？
}
