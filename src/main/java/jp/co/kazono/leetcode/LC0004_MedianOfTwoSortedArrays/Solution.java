package jp.co.kazono.leetcode.LC0004_MedianOfTwoSortedArrays;

public class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] array_A = nums1;
        int[] array_B = nums2;
        int m = nums1.length;
        int n = nums2.length;

        if (m > n) {
            m = nums2.length;
            n = nums1.length;
            array_A = nums2;
            array_B = nums1;
        }

        int iMin = 0, iMax = m;

        while (iMin <= iMax){
            int i = (iMin + iMax) / 2;
            int j = (m + n + 1) / 2 - i;

            if (i < iMax && array_B[j - 1] > array_A[i]) {
                iMin = i + 1;
            } else if (iMin < i && array_A[i - 1] > array_B[j]) {
                iMax = i - 1;
            } else {
                int left_max;

                if (i == 0) {
                    // array_Aのleftがからの場合
                    left_max = array_B[j - 1];
                } else if (j == 0) {
                    // array_Bのleftがからの場合
                    left_max = array_A[i - 1];
                } else {
                    left_max = Math.max(array_A[i - 1], array_B[j - 1]);
                }

                if ((m + n) % 2 == 1) {
                    return left_max;
                }

                int right_min;

                if (i == m) {
                    // array_Aのrightがからの場合
                    right_min = array_B[j];
                } else if (j == n) {
                    // array_Bのrightがからの場合
                    right_min = array_A[i];
                } else {
                    right_min = Math.min(array_A[i], array_B[j]);
                }

                return (left_max + right_min) / 2.0;

            }
        }
        return 0.0;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 2
        System.out.println(s.findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
    }
}
