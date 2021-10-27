package jp.co.kazono.leetcode.LC0031_Next_Permutation;

public class Solution {
    public void nextPermutation(int[] nums) {
        int lastAscdIndex = -1;
        for(int i = 0; i < nums.length - 1; i++){
            if(nums[i] < nums[i+1]) {
                lastAscdIndex = i;
            }
        }

        if(lastAscdIndex == -1){
            reverse(nums, 0, nums.length);
            printArray(nums);
            return;
        }

        int minIndex = lastAscdIndex + 1;
        for(int i = lastAscdIndex+1; i < nums.length; i++){
            if(nums[i] > nums[lastAscdIndex])
                minIndex = i;
        }

        int temp = nums[lastAscdIndex];
        nums[lastAscdIndex] = nums[minIndex];
        nums[minIndex] = temp;

        reverse(nums, lastAscdIndex+1, nums.length);
        printArray(nums);
        return;
    }

    public void reverse(int[] nums, int start, int end){
        for(int i = start; i < (start + end + 1)/2; i++){
            int temp = nums[i];
            nums[i] = nums[start + end -i -1];
            nums[start + end -i -1] = temp;
        }
    }

    public void printArray(int[] nums) {
        for (int num : nums) {
            System.out.print(num + ", ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 1, 3, 2
        s.nextPermutation(new int[]{1, 2, 3});
        // 2, 1, 3
        s.nextPermutation(new int[]{1, 3, 2});
        // 3, 2, 1
        s.nextPermutation(new int[]{3, 2, 1});
        // 1, 1, 5
        s.nextPermutation(new int[]{1, 1, 5});
        // 1, 3, 2, 4
        s.nextPermutation(new int[]{1, 2, 4, 3});
    }
}
