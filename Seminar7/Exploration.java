package org.example;

import java.util.ArrayList;
import java.util.List;

public class Exploration extends Thread {
    private final SharedMemory mem = new SharedMemory(30);
    private Cell[][] matrix;
    private final ExplorationMap map = new ExplorationMap(matrix,5);
    private final List<Robot> robots = new ArrayList<>();

    private void addRobot(Robot robot) {

            robots.add(robot);
    }

    public ExplorationMap getMap() {
        return map;
    }

    public void start()  {
        for (Robot robot : robots) {
            robot.run();
           // System.out.println(robot.getName());
            }
    }
    public static void main(String args[]) {
        var explore = new Exploration();

        explore.addRobot(new Robot("Wall-E"));
        explore.addRobot(new Robot("R2D2"));
        explore.addRobot(new Robot("Optimus Prime"));
        explore.start();
    }


}