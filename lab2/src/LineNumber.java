class LineNumber {
    int LongestSeries(int n, int m, Matrix matrixA) {
        int[] mas = new int[m];
        for (int i = 0; i < m; i++) {
            mas[i] = 0;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m - 1; j++) {
                if (matrixA.matrixA[i][j] == matrixA.matrixA[i][j + 1]) {
                    mas[i]++;
                }
            }
        }

        int max = mas[0];
        int index = 0;
        for (int i = 1; i < m; i++) {
            if (max < mas[i]) {
                max = mas[i];
                index = i;
            }
        }
        int sum = 0;
        for (int i = 0; i < m; i++) {
            sum += mas[i];
            if (sum == 0) {
                return 0;
            }
        }
        return (index + 1);
    }
}
