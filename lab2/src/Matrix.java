import java.util.Scanner;

class Matrix {
    public int [][] matrixA;
    void getRandomMatrix(int n,int m) {
        Scanner input = new Scanner(System.in);
        matrixA = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrixA[i][j] = (int) (Math.random() * n * m);

                System.out.print(matrixA[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
