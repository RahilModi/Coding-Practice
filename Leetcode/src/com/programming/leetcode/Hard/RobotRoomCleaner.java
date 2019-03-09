package com.programming.leetcode.Hard;

import java.util.HashSet;
import java.util.Set;

interface Robot {
    // returns true if next cell is open and robot moves into the cell.
    // returns false if next cell is obstacle and robot stays on the current cell.
    boolean move();

    // Robot will stay on the same cell after calling turnLeft/turnRight.
    // Each turn will be 90 degrees.
    void turnLeft();
    void turnRight();

    // Clean the current cell.
    void clean();
}

public class RobotRoomCleaner {

    public void cleanRoom(Robot robot) {

        helper(robot, new HashSet<String >(), 0, 0,0 );

    }

    public void helper(Robot robot, Set<String> seen, int dir, int i, int j){
        if(seen.contains(i+"-"+j)) return;
        robot.clean();
        seen.add(i+"-"+j);
        int k = 0;
        while (k < 4) {
            if(robot.move()) {
                int x = i, y = j;
                switch (dir){
                    case 0:
                        x = i-1;
                        break;
                    case 90:
                        y= j+1;
                        break;
                    case 180: x = i+1;
                        break;
                    case 270:
                        y=j-1;
                        break;
                }
                helper(robot,seen,dir,x,y);
                robot.turnLeft();
                robot.turnLeft();
                robot.move();
                robot.turnRight();
                robot.turnRight();
            }
            robot.turnRight();
            dir += 90;
            dir %= 360;
            k++;
        }

    }
}
