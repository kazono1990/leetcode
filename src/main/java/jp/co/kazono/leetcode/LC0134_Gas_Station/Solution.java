package jp.co.kazono.leetcode.LC0134_Gas_Station;

public class Solution {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int tank = 0;
        for (int i = 0; i < gas.length; i++) {
            tank += gas[i] - cost[i];
        }

        // if all gas - cost < 0, then return -1.
        if (tank < 0) return -1;

        int start = 0;  // start point
        int left = 0;  // left fuel in tank
        for (int i = 0; i < gas.length; i++) {
            // calculate how much fuel can get from current position
            int currTank = gas[i] - cost[i];
            // if left fuel + currTank < 0, there are no fuel to go next gas station
            // increment start position and initialize left fuel
            if (left + currTank < 0) {
                start = i + 1;
                left = 0;
            } else {
                // update left fuel
                left += currTank;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.canCompleteCircuit(new int[]{1,2,3,4,5}, new int[]{3,4,5,1,2}));
    }
}
