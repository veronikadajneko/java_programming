import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        var value = new Cos();
        Scanner input = new Scanner(System.in);
        double x = input.nextDouble();
        int k = input.nextInt();
        double eps;
        eps = Math.pow(10, -k);
        System.out.printf("%1$.3f%n", value.cos(eps, x));
        System.out.printf("%.3f", Math.cos(x));
    }
}
