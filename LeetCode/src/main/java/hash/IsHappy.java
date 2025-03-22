package hash;

import java.util.HashSet;
import java.util.Set;

/**
 * @author leenadz
 * @since 2025-03-22 19:58
 */
public class IsHappy {

    public static void main(String[] args) {
        IsHappy isHappy = new IsHappy();
        int n = 191;
        System.out.println(isHappy.isHappy(n));
    }

    public boolean isHappy(int n) {
        Set<Integer> sums = new HashSet<>();
        while (true) {
            Integer sum = getSum(n);
            if (sum == 1) {
                return true;
            }
            if (sums.contains(sum)) {
                return false;
            } else {
                sums.add(sum);
                n = sum;
            }
        }
    }

    private Integer getSum(int n) {
        int sum = 0;
        while (n >= 10) {
            sum += (n % 10) * (n % 10);
            n = n / 10;
        }
        sum += n * n;
        return sum;
    }
}
