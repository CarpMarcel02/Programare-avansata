public class Bonus1 {

    public static void main(String[] args) {
        int n;
        n = Integer.parseInt(args[0]);
        System.out.println(n);
        int[][] matrice = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                matrice[i][j] = 0;


        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
            {
                matrice[0][n-1]=1;
                matrice[n-1][0]=1;
                if(j==i+1)
                    matrice[i][j]=1;
                if(j+1==i)
                    matrice[i][j]=1;
            }

        for(int i=0; i<n; i++)
        {
            for (int j = 0; j <n; j++)
            System.out.print(matrice[i][j]);

        System.out.println();}

        int[][] matricerezultat = matrice;
        for (int i = 1; i < n; i++) {
            int[][] temp = new int[n][n];
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    for (int l = 0; l < n; l++) {
                        temp[j][k] += matricerezultat[j][l] * matrice[l][k];
                    }
                }
            }
            matricerezultat = temp;
        }
        System.out.println();

        for(int  i=0; i<n; i++)
        {
            for (int j = 0; j <n; j++)
                System.out.print(matricerezultat[i][j]);
            System.out.println();

        }



}}

