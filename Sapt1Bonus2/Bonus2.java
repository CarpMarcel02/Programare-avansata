public class Bonus2 {

    public static void main(String[] args) {
        int NrNoduri, Grad;
        NrNoduri = Integer.parseInt(args[0]);
        Grad = Integer.parseInt(args[1]);
        if( NrNoduri % 2 ==1 && Grad % 2==1 ) {
            System.out.println("nu se poate realiza un graf regulat");
            return ;
        }

        int[][] matrice = new int[NrNoduri][NrNoduri];
        for (int i = 0; i < NrNoduri; i++)
            for (int j = 0; j < NrNoduri; j++)
                matrice[i][j] = 0;
        int[] Grade = new int[NrNoduri];//vector de grade pt fiecare
        for (int i = 0; i < NrNoduri; i++)
            Grade[i] = 0;


        if(Grad==2) {
            matrice [0][NrNoduri-1]=1;
            matrice[NrNoduri-1][0]=1;
            for (int i = 0; i < NrNoduri-1; i++)
            {
                matrice[i][i+1]=1;
                matrice[i+1][i]=1;

               }

            return ;
        }


        for (int i = 0; i < NrNoduri; i++) {
            for (int j = 0; j < NrNoduri ; j++)
                if (i != j && Grade[i] != Grad && Grade[j] != Grad) {
                    matrice[i][j]=1;
                    matrice[j][i]=1;
                    Grade[i]++;
                    Grade[j]++;

                }
        }
        System.out.println();
        //Afisez matricea finala
        for(int i=0; i<NrNoduri; i++)
        {
            for (int j = 0; j <NrNoduri; j++)
                System.out.print(matrice[i][j]);

            System.out.println();}

    }
}
