package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 69. Sqrt(x)
 * Easy
 * Topics
 * Companies
 * Hint
 * Given a non-negative integer x, return the square root of x rounded down to the nearest integer. The returned integer should be non-negative as well.
 *
 * You must not use any built-in exponent function or operator.
 *
 * For example, do not use pow(x, 0.5) in c++ or x ** 0.5 in python.
 *
 *
 * Example 1:
 *
 * Input: x = 4
 * Output: 2
 * Explanation: The square root of 4 is 2, so we return 2.
 * Example 2:
 *
 * Input: x = 8
 * Output: 2
 * Explanation: The square root of 8 is 2.82842..., and since we round it down to the nearest integer, 2 is returned.
 *
 *
 * Constraints:
 *
 * 0 <= x <= 231 - 1
 */

public class SqrtX {
    public static void main(String[] args) {
        long x = (long) Math.pow(2, 30);
        System.out.println("Input: x = " + x);
        checkConstraints(x);
        long mySqrt = calculateSqrt(x);
        System.out.println("Output: " + mySqrt);
    }

    private static void checkConstraints(long x) {
        if (x < 0 || x > Math.pow(2, 31) - 1) {
            throw new IllegalArgumentException("0 <= x <= 2^31 - 1");
        }
    }

    private static long calculateSqrt(long x) {
        long result = 0;
        for (long i = 1; i * i <= x; i++) {
            result = i;
        }

        return result;
    }
}
