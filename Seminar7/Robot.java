package org.example;
import java.util.Random;
public class Robot implements Runnable {
    private String name;
    private boolean running;
    private int pozitieX;
    private int pozitieY;

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

    public String getName() {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    Exploration explore;

    public Robot(String name) {
        this.name = name;
        Random random = new Random();
        int numar=ExplorationMap.getLungimeCol()*ExplorationMap.getLungimeCol()-1;
        int pozitie = random.nextInt(numar);
        ExplorationMap.setVectViz(numar);
        int copie=numar;
        for(int i=0; i<ExplorationMap.getLungimeCol();i++)
            for(int j=0; j<ExplorationMap.getLungimeCol();j++)
            {   if(ExplorationMap.getVectViz(i,j)==0) {
                copie--;
                if (copie == 0) {
                    setPozitieX(i);
                    setPozitieY(j);
                }
                ExplorationMap.setVectViz(i+j);
            }

            }
        setRunning(true);
        System.out.println(getPozitieX()+" "+getPozitieY());
    }


    public void run() {
        while (running) {
           // System.out.println(getName());

            Random random = new Random();
            int pozitie=random.nextInt(4);
            if(pozitie==0 && ExplorationMap.getVectViz(getPozitieX()+1,getPozitieY())==0);
            { explore.getMap().visit(getPozitieX()+1, getPozitieY(), this);
            System.out.println(getPozitieX()+" "+ getPozitieY());}

            if(pozitie==1 && ExplorationMap.getVectViz(getPozitieX(),getPozitieY()+1)==0) {
                explore.getMap().visit(getPozitieX(), getPozitieY() + 1, this);
                System.out.println(getPozitieX() + " " + getPozitieY());
            }
            if(pozitie==2 && ExplorationMap.getVectViz(getPozitieX()-1,getPozitieY())==0) {
                explore.getMap().visit(getPozitieX() - 1, getPozitieY(), this);
                System.out.println(getPozitieX() + " " + getPozitieY());
            }
            if(pozitie==3 && ExplorationMap.getVectViz(getPozitieX()-1,getPozitieY())==0) {
                explore.getMap().visit(getPozitieX(), getPozitieY() - 1, this);
                System.out.println(getPozitieX() + " " + getPozitieY());
            }
                 try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }
    }
}