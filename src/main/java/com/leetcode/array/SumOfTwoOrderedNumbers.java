package com.leetcode.array;

import java.util.Arrays;

/**
 * @author xukai
 * @since 2021/7/6 20:36
 */
public class SumOfTwoOrderedNumbers {

    public static void main(String[] args) {
        int[] array = {1, 12, 33, 54, 65, 67};
        SumOfTwoOrderedNumbers sumOfTwoOrderedNumbers = new SumOfTwoOrderedNumbers();
        int[] result = sumOfTwoOrderedNumbers.twoSum(array, 79);
        if (result.length > 0) {
            for (int value : result) {
                System.out.println(value);
            }
        }
        result = sumOfTwoOrderedNumbers.twoSum2(array, 79);
        System.out.println(Arrays.toString(result));
    }

    public int[] twoSum(int[] numbers, int target) {
        int start = 0, end = numbers.length - 1;
        while (start < end) {
            if (numbers[start] + numbers[end] == target) {
                return new int[]{start, end};
            } else if (numbers[start] + numbers[end] > target) {
                end--;
            } else {
                start++;
            }
        }
        return new int[]{};
    }

    public int[] twoSum2(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            int remain = target - numbers[i];
            int low = i + 1, high = numbers.length - 1;
            while (low <= high) {
                int mid = (low + high) >>> 1;
                if (remain == numbers[mid]) {
                    return new int[]{i, mid};
                } else if (remain < numbers[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return new int[]{};
    }

}
