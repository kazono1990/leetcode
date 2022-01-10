package jp.co.kazono.leetcode.LC1041_Robot_Bounded_In_Circle;

public class Solution {
    private enum Direction {
        NORTH,
        SOUTH,
        WEST,
        EAST
    }

    public boolean isRobotBounded(String instructions) {
        if (instructions == null || instructions.length() == 0) return false;
        // initial points of the robot
        // (x, y) = (0, 0)
        int x = 0;
        int y = 0;

        // initial direction of robot
        /*
                    North
            West                East
                    South
        */
        Direction direction = Direction.NORTH;

        for (char ch : instructions.toCharArray()) {
            if (ch == 'G') {
                switch (direction) {
                    case NORTH:
                        y += 1;
                        break;
                    case SOUTH:
                        y -= 1;
                        break;
                    case EAST:
                        x += 1;
                        break;
                    case WEST:
                        x -= 1;
                        break;
                }
            } else if (ch == 'L') {
                switch (direction) {
                    case NORTH:
                        direction = Direction.WEST;
                        break;
                    case WEST:
                        direction = Direction.SOUTH;
                        break;
                    case SOUTH:
                        direction = Direction.EAST;
                        break;
                    case EAST:
                        direction = Direction.NORTH;
                        break;
                }
            } else if (ch == 'R') {
                switch (direction) {
                    case NORTH:
                        direction = Direction.EAST;
                        break;
                    case EAST:
                        direction = Direction.SOUTH;
                        break;
                    case SOUTH:
                        direction = Direction.WEST;
                        break;
                    case WEST:
                        direction = Direction.NORTH;
                        break;
                }
            }
        }

        // Finally we check whetehr the robot get back to the position, if yes, return true as the robot donot go out of the circle.
        // We check whether the direction is still North, then it will sure go out of the circle, so return false.
        // If none of the above condition satisfies, then also the robot will be some where inside the circle, so return true.
        if (x == 0 && y == 0) return true;
        if (direction == Direction.NORTH) return false;

        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // true
        System.out.println(s.isRobotBounded("GGLLGG"));
        // false
        System.out.println(s.isRobotBounded("GG"));
        // true
        System.out.println(s.isRobotBounded("GL"));
    }
}
