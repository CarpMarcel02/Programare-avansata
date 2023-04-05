package org.example;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Robot implements Runnable {
    private String name;

    private CyclicBarrier barrier;

    private boolean running;

    public void setBarrier(CyclicBarrier barrier) {
        this.barrier = barrier;
    }

    private int pozitieX;
    private int pozitieY;

    private int pozitiiMiscate;

    public int getPozitieX() {
        return pozitieX;
    }

    public void setPozitieX(int pozitieX) {
        this.pozitieX = pozitieX;
    }

    public int getPozitieY() {
        return pozitieY;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public void setPozitieY(int pozitieY) {
        this.pozitieY = pozitieY;
    }
    private final Object lock = new Object();


    public String getName() {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    Exploration explore;

    /**
     * constructorul default a robotului, ii atribuie random o pozitie in matrice,
     * @param name
     */
    public Robot(String name) {
        this.name = name;
        this.pozitiiMiscate=0;
        int[][] matrice=ExplorationMap.getMatrice();
        Random random = new Random();
        int numar=ExplorationMap.getLungimeCol()*ExplorationMap.getLungimeCol()-1;
        int pozitie = random.nextInt(numar);
        ExplorationMap.setVectViz(numar);
        int copie=pozitie;
        //System.out.println(copie);
        for(int i=0; i<ExplorationMap.getLungimeCol();i++) {
            for (int j = 0; j < ExplorationMap.getLungimeCol(); j++) {
                if (matrice[i][j] == 0) {
                    copie--;
                    if (copie == 0) {
                        setPozitieX(i);
                        setPozitieY(j);
                        ExplorationMap.setMatrice(i, j, 9);

                    }
                    ExplorationMap.setVectViz(i + j);
                }

            }

        }
        setRunning(true);
    }

    /**
     * ia un numar random pan la 3 (inclusiv) si in functie de acesta deplaseaza robotul in sus stanga jos sau dreapta doar daca este posibil
     */
    public void run() {
        while (running) {
           Cell[][] matrix=ExplorationMap.getMatrix();
            int[][] matrice=ExplorationMap.getMatrice();
            int ok=0;
            this.barrier = barrier;
            synchronized (lock) {
                while (ok != 1) {
                    Random random = new Random();
                    int pozitie = random.nextInt(4);


                    System.out.println(name + " " + pozitieX + " " + pozitieY + " " + pozitie);

                    if(getPozitieX()+1==5 && getPozitieY()+1==5 && matrice[getPozitieX()-1][getPozitieY()]!=0 && matrice[getPozitieX()][getPozitieY()-1]!=0)
                        System.out.println("robotul "+ name + " s-a blocat");

                    if(getPozitieX()+1==5 && getPozitieY()-1==-1 && matrice[getPozitieX()-1][getPozitieY()]!=0 && matrice[getPozitieX()][getPozitieY()+1]!=0)
                        System.out.println("robotul "+ name + " s-a blocat");

                    if(getPozitieX()-1==-1 && getPozitieY()+1==5 && matrice[getPozitieX()+1][getPozitieY()]!=0 && matrice[getPozitieX()][getPozitieY()-1]!=0)
                        System.out.println("robotul "+ name + " s-a blocat");

                    if(getPozitieX()-1==-1 && getPozitieY()-1==-1 && matrice[getPozitieX()+1][getPozitieY()]!=0 && matrice[getPozitieX()][getPozitieY()+1]!=0)
                        System.out.println("robotul "+ name + " s-a blocat");

                    if (pozitie == 0 && matrice[getPozitieX() + 1][getPozitieY()] == 0 && getPozitieX() !=4) {
                        //System.out.println(getPozitieX() + " " + getPozitieY() + " " + pozitie);
                        ExplorationMap.visit(getPozitieX() + 1, getPozitieY(), this);
                        setPozitieX(getPozitieX() + 1);
                        ok = 1;
                    }
                    else

                    if (pozitie == 1 && matrice[getPozitieX()][getPozitieY() + 1] == 0 && getPozitieY() !=4) {
                        ExplorationMap.visit(getPozitieX(), getPozitieY() + 1, this);
                        //System.out.println(getPozitieX() + " " + getPozitieY());
                        setPozitieY(getPozitieY() + 1);
                        ok = 1;
                    }
                    else
                    if (pozitie == 2 && matrice[getPozitieX() - 1][getPozitieY()] == 0 && getPozitieX() !=0) {
                        ExplorationMap.visit(getPozitieX() - 1, getPozitieY(), this);
                        //System.out.println(getPozitieX() + " " + getPozitieY());
                        setPozitieX(getPozitieX() - 1);
                        ok = 1;
                    }
                    else
                    if (pozitie == 3 && matrice[getPozitieX()][getPozitieY() - 1] == 0 && getPozitieY() !=0) {
                        ExplorationMap.visit(getPozitieX(), getPozitieY() - 1, this);
                        //System.out.println(getPozitieX() + " " + getPozitieY());
                        setPozitieY(getPozitieY() - 1);
                        ok = 1;
                    }
                    this.pozitiiMiscate++;
                    if (ok != 1) {
                        try {
                            lock.wait(5000); // wait for 1 second before retrying
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                }
            }

            synchronized (System.out) {
                for(int i=0;i<ExplorationMap.getLungimeCol();i++) {
                    for(int j=0;j<5;j++) {
                        System.out.print(matrice[i][j]+ " ");
                    }
                    System.out.println();
                }
                System.out.println();
            }
            try {
                barrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                // handle exception
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
            }
        }
    }


}}