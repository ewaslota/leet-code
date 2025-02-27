package easy;

import java.util.Arrays;

/**
 * 26. Remove Duplicates from Sorted Array
 * Easy
 * Topics
 * Companies
 * Hint
 * Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same. Then return the number of unique elements in nums.
 *
 * Consider the number of unique elements of nums to be k, to get accepted, you need to do the following things:
 *
 * Change the array nums such that the first k elements of nums contain the unique elements in the order they were present in nums initially. The remaining elements of nums are not important as well as the size of nums.
 * Return k.
 * Custom Judge:
 *
 * The judge will test your solution with the following code:
 *
 * int[] nums = [...]; // Input array
 * int[] expectedNums = [...]; // The expected answer with correct length
 *
 * int k = removeDuplicates(nums); // Calls your implementation
 *
 * assert k == expectedNums.length;
 * for (int i = 0; i < k; i++) {
 *     assert nums[i] == expectedNums[i];
 * }
 * If all assertions pass, then your solution will be accepted.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,1,2]
 * Output: 2, nums = [1,2,_]
 * Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
 * It does not matter what you leave beyond the returned k (hence they are underscores).
 * Example 2:
 *
 * Input: nums = [0,0,1,1,1,2,2,3,3,4]
 * Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
 * Explanation: Your function should return k = 5, with the first five elements of nums being 0, 1, 2, 3, and 4 respectively.
 * It does not matter what you leave beyond the returned k (hence they are underscores).
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 3 * 104
 * -100 <= nums[i] <= 100
 * nums is sorted in non-decreasing order.
 */
public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int[] nums = convertArrayToIntArray(args);
        checkConstraints(nums);
        System.out.println("Input: nums = " + Arrays.toString(nums));
        int goodCounter = removeDuplicates(nums);
        System.out.println("Output: " + goodCounter + " , nums = " + Arrays.toString(nums));
    }

    private static int removeDuplicates(int[] nums) {
        int goodCounter = 0;
        int badCounter = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i > 0  && nums[i] != -1 && nums[i] == nums[i - 1]) {
                for (int j = i; j < nums.length - 1 - badCounter; j++) {
                    nums[j] = nums[j + 1];
                }
                nums[nums.length - 1 - badCounter] = -1;
                badCounter++;
                i--;
                goodCounter--;
                continue;
            }
            goodCounter++;
        }

        return goodCounter;
    }

    private static void checkConstraints(int[] nums) {
        if (nums.length < 1 || nums.length > 3 * 104) {
            throw new IllegalArgumentException("1 <= nums.length <= 3 * 104");
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < -100 || nums[i] > 100) {
                throw new IllegalArgumentException("-100 <= nums[i] <= 100");
            }

            if (i > 0 && nums[i] < nums[i - 1]) {
                throw new IllegalArgumentException("nums should be sorted in non-decreasing order");
            }
        }
    }

    private static int[] convertArrayToIntArray(String[] array) {
        int[] intArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            intArray[i] = Integer.parseInt(array[i]);
        }

        return intArray;
    }
}
