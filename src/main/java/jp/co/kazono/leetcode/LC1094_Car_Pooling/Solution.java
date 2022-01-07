package jp.co.kazono.leetcode.LC1094_Car_Pooling;

public class Solution {

    public boolean carPooling(int[][] trips, int capacity) {
        // Compute the total number of people at every given destinations.
        // At start add the number of passengers and at end subtract the number of passengers.
        int[] count = new int[1001];
        for (int i = 0; i < trips.length; i++) {
            count[trips[i][1]] += trips[i][0];
            count[trips[i][2]] -= trips[i][0];
        }

        // Add the net number of people at very position. If at any point the people is over capacity return false.
        int passengers = 0;
        for (int i : count) {
            passengers += i;
            if (passengers > capacity) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // false
        System.out.println(s.carPooling(new int[][]{{2, 1, 5}, {3, 3, 7}}, 4));
        // true
        System.out.println(s.carPooling(new int[][]{{2, 1, 5}, {3, 3, 7}}, 5));
    }
}
