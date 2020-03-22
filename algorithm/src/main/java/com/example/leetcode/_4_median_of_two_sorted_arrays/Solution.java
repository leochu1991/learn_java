package com.example.leetcode._4_median_of_two_sorted_arrays;

/**
 * 4.寻找两个有序数组的中位数
 * 时间复杂度O(log(m+n))
 */
class Solution {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int size1 = nums1.length;
        int size2 = nums2.length;
        int length = size1 + size2;
        int[] both = new int[length];
        int i = 0, index1 = 0, index2 = 0;
        // 寻找公共长度数字，直到一个数组越界
        while (index1 < size1 && index2 < size2) {
            if (nums1[index1] <= nums2[index2]) {
                both[i++] = nums1[index1];
                index1++;
            } else {
                both[i++] = nums2[index2];
                index2++;
            }
        }
        // nums1没有越界，继续添加到both
        if (index1 < size1) {
            while (i < length && index1 < size1) {
                both[i++] = nums1[index1++];
            }
        }
        // nums2没有越界，继续添加到both
        if (index2 < size2) {
            while (i < length && index2 < size2) {
                both[i++] = nums2[index2++];
            }
        }

        // System.out.println("both:" + JSON.toJSONString(both));

        double result = 0.0d;
        if (length % 2 == 0) {
            // 长度偶数，取平均数
            result = (both[length / 2 - 1] + both[length / 2]) / 2.0;
        } else {
            // 长度奇数，取中间
            result = both[(length - 1) / 2];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 3, 5, 8};
        int[] b = new int[]{2, 4, 9, 10};
        double result = findMedianSortedArrays(a, b);
        System.out.println("median sorted number:" + result);
    }
}
