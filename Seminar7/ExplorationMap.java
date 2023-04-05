package org.example;

import java.util.Arrays;
import java.util.List;

public class ExplorationMap {
    private static Cell[][] matrix;

    private static final Object lock = new Object();

    private static int[][] matrice;
    private static int lungimeCol;
    private int lungimeRand;

    public static Cell[][] getMatrix() {
        return matrix;
    }

    private static int[] vectViz;

    public static void setMatrice(int row,int col,int simbol) {
        matrice[row][col]=simbol;
    }

    public static int[][] getMatrice() {
        return matrice;
    }

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

    /**
     * initializeaza matricea pentru pozitii si matricea pentru tokenuri
     * @param matrice
     * @param lungime
     */
    public ExplorationMap(int[][] matrice,int lungime) {
        Cell[][] matrixModel = new Cell[lungime][lungime];
        for (int i = 0; i < lungime; i++) {
            for (int j = 0; j < lungime; j++) {
                matrixModel[i][j] = new Cell(null);
            }
        }

        int[][] matrice1 = new int[lungime][lungime];

        for (int i = 0; i < lungime; i++) {
            for (int j = 0; j < lungime; j++) {
                matrice1[i][j] = 0;
            }
        }

        this.matrice=matrice1;
        this.matrix=matrixModel;
        this.lungimeCol = lungime;
        this.lungimeRand = lungime;
        vectViz = new int[lungimeCol * lungimeRand];
        Arrays.fill(vectViz, 0);
        this.vectViz = vectViz;
    }

    /**
     * pentru fiecare noua pozitie vizitata, o marcheaza si ii pune pe acea pozitie in matricea de Cell o lista de tokenuri
     * @param row
     * @param col
     * @param robot
     * @return
     */
    public static boolean visit(int row, int col, Robot robot) {
        synchronized (lock) {
            if (matrice[row][col]==0) {
                if(robot.getName()=="Wall-E")
                    matrice[row][col]=1;
                if(robot.getName()=="R2D2")
                    matrice[row][col]=2;
                if(robot.getName()=="Optimus Prime")
                    matrice[row][col]=3;
                List<Token> extractedTokens = SharedMemory.extractTokens(3);
                Cell cell = new Cell(extractedTokens);
                matrix[row][col] = cell;

                return true;
            }
        }
        System.out.println("pozitia a fost vizitata");
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