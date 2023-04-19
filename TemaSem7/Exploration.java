package org.example;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.ArrayList;
import java.util.List;

public class Exploration extends Thread {
    private final SharedMemory mem = new SharedMemory(30);
    private Cell[][] matrix;
    private int[][] matrice;
    private final ExplorationMap map = new ExplorationMap(matrice,5);
    private final List<Robot> robots = new ArrayList<>();

    private void addRobot(Robot robot) {

            robots.add(robot);
    }

    public int[][] getMatrice() {
        return ExplorationMap.getMatrice();
    }
    public ExplorationMap getMap() {
        return map;
    }

    /**
     * functia de start permite tuturor robotilor sa inceapa in accelasi timp cu ajutorul ExecutorService
     * CyclicBarrier e facut ca sa astepte fiecare robot dupa el
     */
    public void start()  {
        ExecutorService executor = Executors.newFixedThreadPool(robots.size());
        CyclicBarrier barrier = new CyclicBarrier(robots.size());

        System.out.println("incepe jocu :");
        for (Robot robot : robots) {
            robot.setBarrier(barrier);
            executor.submit(robot);

            }
        executor.shutdown();

    }
    public static void main(String args[]) {
        var explore = new Exploration();

        explore.addRobot(new Robot("Wall-E"));
        //explore.addRobot(new Robot("R2D2"));
        //explore.addRobot(new Robot("Optimus Prime"));
        explore.start();
    }


}