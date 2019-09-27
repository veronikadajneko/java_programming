class Cos {
    double cos(double eps, double x) {
        double i = 1;
        int j = 1;
        double result = 1;
        while (Math.abs(i) > eps) {
            i = i * (x * x) * (-1) / (j * (j + 1));
            j += 2;
            result += i;
        }
        return result;
    }
}
