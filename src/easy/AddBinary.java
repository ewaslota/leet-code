package easy;

/**
 * 67. Add Binary
 * Easy
 * Topics
 * Companies
 * Given two binary strings a and b, return their sum as a binary string.
 *
 *
 *
 * Example 1:
 *
 * Input: a = "11", b = "1"
 * Output: "100"
 * Example 2:
 *
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 *
 *
 * Constraints:
 *
 * 1 <= a.length, b.length <= 104
 * a and b consist only of '0' or '1' characters.
 * Each string does not contain leading zeros except for the zero itself.
 */

public class AddBinary {
    public static void main(String[] args) {
        String a = args[0];
        String b = args[1];
        checkConstraints(a, b);
        System.out.println("Input: a = \"" + a + "\", \"b = \"" + b + "\"");
        String sumOfTwoBinaryNumbers = addTwoBinaryNumbers(a, b);
        System.out.println("Output: \"" + sumOfTwoBinaryNumbers + "\"");
    }

    private static void checkConstraints(String a, String b) {
        if (a.isEmpty() || a.length() > 10000 || b.isEmpty() || b.length() > 10000 ) {
            throw new IllegalArgumentException("1 <= a.length, b.length <= 10^4");
        }

        if (!a.matches("[01]*") || !b.matches("[01]*")) {
            throw new IllegalArgumentException("a consist only of '0' or '1' characters.");
        }

        if ((a.length() > 1 && a.charAt(0) == '0') || (b.length() > 1 && b.charAt(0) == '0')) {
            throw new IllegalArgumentException("Each string does not contain leading zeros except for the zero itself");
        }
    }

    private static String addTwoBinaryNumbers(String a, String b) {
        StringBuilder sum = new StringBuilder();
        int carry = 0;

        if (b.length() > a.length()) {
            String tmp = a;
            a = b;
            b = tmp;

        }

        a = new StringBuilder(a).reverse().toString();
        b = new StringBuilder(b).reverse().toString();

        for (int i = 0; i < a.length(); i++) {
            if (carry == 0 && a.charAt(i) == '0' && b.length() < i + 1) {
                sum.append('0');
                carry = 0;
                continue;
            }
            if (carry == 1 && a.charAt(i) == '0' && b.length() < i + 1) {
                sum.append('1');
                carry = 0;
                continue;
            }
            if (carry == 0 && a.charAt(i) == '1' && b.length() < i + 1) {
                sum.append('1');
                carry = 0;
                continue;
            }
            if (carry == 1 && a.charAt(i) == '1' && b.length() < i + 1) {
                sum.append('0');
                carry = 1;
                continue;
            }
            if (carry == 0 && a.charAt(i) == '0' && b.charAt(i) == '0') {
                sum.append('0');
                carry = 0;
                continue;
            }
            if (carry == 1 && a.charAt(i) == '0' && b.charAt(i) == '0') {
                sum.append('1');
                carry = 1;
                continue;
            }
            if (carry == 0 &&
                    ((a.charAt(i) == '1' && b.charAt(i) == '0') || (a.charAt(i) == '0' && b.charAt(i) == '1'))
            ) {
                sum.append('1');
                carry = 0;
                continue;
            }
            if (carry == 1 &&
                    ((a.charAt(i) == '1' && b.charAt(i) == '0') || (a.charAt(i) == '0' && b.charAt(i) == '1'))
            ) {
                sum.append('0');
                carry = 1;
                continue;
            }
            if (carry == 0 && a.charAt(i) == '1' && b.charAt(i) == '1') {
                sum.append('0');
                carry = 1;
                continue;
            }
            if (carry == 1 && a.charAt(i) == '1' && b.charAt(i) == '1') {
                sum.append('1');
                carry = 1;
            }
        }

        if (carry == 1) {
            sum.append('1');
        }

        return sum.reverse().toString();
    }
}
