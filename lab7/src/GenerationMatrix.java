
class GenerationMatrix {
    double[][] generation(int n, int m) {
        double[][] matrix = new double[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = (int)(Math.random()*100);
            }
        }
        return matrix;
    }
}
