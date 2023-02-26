import java.util.Arrays;
public class Validare {

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        if (args.length != 1) {
            System.err.println("Am primit mai mult decat o variabila drept input");
            System.exit(1);}
        System.out.println("variabila ce am primit-o drept argument este " + args[0]);

        int n;

        try {
            n = Integer.parseInt(args[0]);
           }
        catch (NumberFormatException e) {
            System.err.println("Variabila nu este de tipul int");
            System.exit(1);
            }
        int x;
        x = Integer.parseInt(args[0]);
        if (x < 0) {
            System.err.println("numarul nostru e negativ");
            System.exit(1);
        }
        System.out.println("numarul nostru " + x + " este de tipul int");

        int[][] matrice = new int[x][x];

        for(int i=0;i<x;i++)
        {
            for (int j = 0; j <x; j++) {
                if (i == 0) {
                    matrice[i][j] = j+1;
                } else if (matrice[i - 1][j] + 1 <= x)
                    matrice[i][j] = matrice[i - 1][j] + 1;
                    else
                        matrice[i][j]=1;
                System.out.print(matrice[i][j]);
            }
            System.out.println();

        }
        System.out.println();


        for (int i = 0; i < x; i++) {
//afiseaza linia
            System.out.println(Arrays.toString(matrice[i]));

        StringBuilder Rand = new StringBuilder();
        for (int j = 0; j < x; j++) {
            Rand.append(matrice[i][j]);
        }
        System.out.println("Pentru randul " + (i +1 ) + " am urmatoarele simboluri " + Rand.toString());




        StringBuilder Coloana = new StringBuilder();
        for (int j = 0; j < x; j++) {
            Coloana.append(matrice[j][i]);
        }
        System.out.println("Pentru coloana " + (i + 1) + " am urmatoarele simboluri " + Coloana.toString());}


        long endTime = System.nanoTime();
        long elapsedTime = endTime - startTime;
        if (x > 500) {
            // Display the elapsed time in milliseconds
            System.out.printf("Timpul estimat in milisecunde  este %d", elapsedTime / 1000000);
        } else {
            // Display the elapsed time in nanoseconds
            System.out.printf("Timpul estimat in nanosecunde este %d", elapsedTime);
        }
}}
