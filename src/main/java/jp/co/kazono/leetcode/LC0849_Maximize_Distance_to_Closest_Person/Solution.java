package jp.co.kazono.leetcode.LC0849_Maximize_Distance_to_Closest_Person;

public class Solution {
    public int maxDistToClosest(int[] seats) {
        int N = seats.length;
        int prev = -1;
        int future = 0;
        int distance = 0;

        for (int i = 0; i < N; i++) {
            if (seats[i] == 1) {
                prev = i;
            } else {
                while (future < N && seats[future] == 0 || future < i) future++;
                int left = prev == -1 ? N : i - prev;
                int right = future == N ? N : future -i;
                distance = Math.max(distance, Math.min(left, right));
            }
        }
        return distance;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.maxDistToClosest(new int[]{1,0,0,0,1,0,1}));
    }
}
