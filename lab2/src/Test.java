import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        int n = 0;
        int m = 0;
        var in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        var value = new LineNumber();
        var matrix = new Matrix();
        matrix.getRandomMatrix(n,m);
        System.out.println(value.LongestSeries(n, m,matrix));
    }
}
