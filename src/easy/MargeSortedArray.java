package easy;

import java.util.Arrays;

/**
 * 88. Merge Sorted Array
 * Easy
 * Topics
 * Companies
 * Hint
 * You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.
 *
 * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
 *
 * The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
 *
 *
 *
 * Example 1:
 *
 * Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * Output: [1,2,2,3,5,6]
 * Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
 * The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
 * Example 2:
 *
 * Input: nums1 = [1], m = 1, nums2 = [], n = 0
 * Output: [1]
 * Explanation: The arrays we are merging are [1] and [].
 * The result of the merge is [1].
 * Example 3:
 *
 * Input: nums1 = [0], m = 0, nums2 = [1], n = 1
 * Output: [1]
 * Explanation: The arrays we are merging are [] and [1].
 * The result of the merge is [1].
 * Note that because m = 0, there are no elements in nums1. The 0 is only there to ensure the merge result can fit in nums1.
 *
 *
 *
 *  * nums1.length == m + n
 *  * nums2.length == n
 *  * 0 <= m, n <= 200
 *  * 1 <= m + n <= 200
 *  * -109 <= nums1[i], nums2[j] <= 109
 *
 *
 * Follow up: Can you come up with an algorithm that runs in O(m + n) time?
 */

public class MargeSortedArray {
    public static void main(String[] args) {
        int[] nums1;
        int m;
        int[] nums2;
        int n;
        int[] expectedNums1;

        // Input 1
        nums1 = new int[] {1, 2, 3, 0, 0, 0};
        m = 3;
        nums2 = new int[] {2, 5, 6};
        n = 3;

        // expected output 1
        expectedNums1 = new int[] {1, 2, 2, 3, 5, 6};

        testCase(nums1, m, nums2, n, expectedNums1);
        System.out.println(Arrays.toString(expectedNums1));

        // Input 2
        nums1 = new int[] {1};
        m = 1;
        nums2 = new int[] {};
        n = 0;

        // expected output 2
        expectedNums1 = new int[] {1};

        testCase(nums1, m, nums2, n, expectedNums1);
        System.out.println(Arrays.toString(expectedNums1));

        // Input 3
        nums1 = new int[] {0};
        m = 0;
        nums2 = new int[] {1};
        n = 1;

        // expected output 3
        expectedNums1 = new int[] {1};

        testCase(nums1, m, nums2, n, expectedNums1);

        System.out.println(Arrays.toString(expectedNums1));
    }

    private static void testCase(int[] nums1, int m, int[] nums2, int n, int[] expectedNums1) throws AssertionError {
        checkConstraints(nums1, m, nums2, n);

        mergeAndSortNonDescendent(nums1, nums2);
        assert Arrays.equals(nums1, expectedNums1);
    }

    private static void checkConstraints(int[] nums1, int m, int[] nums2, int n) {
    //         *  * nums1.length == m + n
    //                *  * nums2.length == n
    //                *  * 0 <= m, n <= 200
    //                *  * 1 <= m + n <= 200
    //                *  * -109 <= nums1[i], nums2[j] <= 109

        if (nums1.length != m + n) {
            throw new IllegalArgumentException("nums1.length != m + n");
        }

        if (nums2.length != n) {
            throw new IllegalArgumentException("nums2.length != n");
        }
        if ((m < 0 || m > 200) || (n < 0 || n > 200)) {
            throw new IllegalArgumentException("0 <= m, n <= 200");
        }

        if ((m + n) < 1 || (m + n) > 200) {
            throw new IllegalArgumentException("1 <= m + n <= 200");
        }

        for (int i = 0; i < nums1.length; i++) {
            if (nums1[i] < -1000000000) {
                throw new IllegalArgumentException("-109 > nums1[i]");
            }
            if (nums1[i] > 1000000000) {
                throw new IllegalArgumentException("nums1[i] > 109");
            }
        }

        for (int j = 0; j < nums2.length; j++) {
            if (nums2[j] < -1000000000) {
                throw new IllegalArgumentException("-109 > nums2[j]");
            }
            if (nums2[j] > 1000000000) {
                throw new IllegalArgumentException("nums2[j] > 109");
            }
        }
    }

    private static void mergeAndSortNonDescendent(int[] nums1, int[] nums2) {
        int n = nums2.length;
        int m = nums1.length - n;

        for (int i = 0; i < n; i++) {;
            nums1[m + i] = nums2[i];
        }

        Arrays.sort(nums1);
    }
}
