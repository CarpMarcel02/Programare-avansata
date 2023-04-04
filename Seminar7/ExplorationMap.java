package org.example;

import java.util.Arrays;

public class ExplorationMap {
    private final Cell[][] matrix;
    private static int lungimeCol;
    private int lungimeRand;

    private static int[] vectViz;

    public static int getVectViz(int row, int col) {
        return vectViz[row + col];
    }

    public int[] getVectViz() {
        return vectViz;
    }

    public void setVectViz(int row, int col) {
        vectViz[row + col] = 1;

    }
    public static void setVectViz(int row) {
        vectViz[ row ] = 1;

    }

    public static int getLungimeCol() {
        return lungimeCol;
    }

    public int getLungimeRand() {
        return lungimeRand;
    }

    public ExplorationMap(Cell[][] matrix,int lungime) {
        Cell[][] matrice = new Cell[lungime][lungime];

        for (int i = 0; i < lungime; i++) {
            for (int j = 0; j < lungime; j++) {
                matrice[i][j] = new Cell();
            }
        }
        this.matrix=matrice;
        this.lungimeCol = lungime;
        this.lungimeRand = lungime;
        vectViz = new int[lungimeCol * lungimeRand];
        Arrays.fill(vectViz, 0);
        this.vectViz = vectViz;
    }


    //Cell should be a wrapper or alias for List<Token>
    public boolean visit(int row, int col, Robot robot) {
        synchronized (matrix[row][col]) {
            if (getVectViz(row, col) == 0) {
                SharedMemory.extractTokens(3);
                setVectViz(row, col);
                System.out.println("Vectorul de vizitare a fost actualizat");
                return true;
            }
        }
        System.out.println("pozitia deja a fost vizitata");
        return false;
    }

    @Override
    public String toString() {
        for (int i = 0; i < getLungimeCol(); i++) {
            for (int j = 0; j < getLungimeRand(); j++)
                System.out.print(matrix[i][j] + " ");
            System.out.println();
        }
        return "a fost afisata matricea";
    }
}