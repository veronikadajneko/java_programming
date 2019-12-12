import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        try (FileWriter writer = new FileWriter("output.txt")) {
            int n = 1000, m = 1000;
            double[][] matrixA;
            double[][] matrixB;
            var value = new GenerationMatrix();
            matrixA = value.generation(n, m);
            matrixB = value.generation(m, n);
            printMatrix(matrixA,writer);
            printMatrix(matrixB,writer);
            var result = new Matrix(matrixA, matrixB);
            printMatrix(result.multiplyByMatrix(),writer);
            long time = System.currentTimeMillis();
            printMatrix(result.executorMultiply(8),writer);
            System.out.println(System.currentTimeMillis()-time);
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
    private static void printMatrix(double [][] matrix, Writer writer) throws IOException {
        for(var vector : matrix){
            for(var element : vector){
                writer.write(element+" ");
            }
            writer.write("\r\n");
        }
        writer.write("\r\n");
    }
}
