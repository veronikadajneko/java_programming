import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Matrix {
    private double[][] matrixA;
    private double[][] matrixB;

    Matrix(double[][] inMatrixA, double[][] inMatrixB) {
        matrixA = inMatrixA;
        matrixB = inMatrixB;
    }

    double[][] multiplyByMatrix() {
        double[][] result = new double[matrixA.length][matrixB[0].length];
        for (int i = 0; i < matrixA.length; i++) {
            for (int j = 0; j < matrixB[0].length; j++) {
                for (int k = 0; k < matrixB.length; k++) {
                    result[i][j] += matrixA[i][k] * matrixB[k][j];
                }
            }
        }
        return result;
    }

    double[][] executorMultiply(int count) {
        ExecutorService executor = Executors.newFixedThreadPool(count);
        double[][] result = new double[matrixA.length][matrixB[0].length];
        for (int i = 0; i < matrixA.length; i++) {
            for (int j = 0; j < matrixB[0].length; j++) {
                int finalJ = j;
                int finalI = i;
                executor.execute(()->{
                    result[finalI][finalJ]=multiplyVector(finalI,finalJ);
                });
            }
        }
        executor.shutdown();
        try {
            executor.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return result;
    }
    private double  multiplyVector(int p, int k){
        double answer=0.0;
        for(int i=0;i<matrixA.length;i++){
            answer+=matrixA[p][i]*matrixB[i][k];
        }
        return answer;
    }
}