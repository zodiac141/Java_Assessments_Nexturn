public class MatrixAddition {
    public static void main(String[] args) {
        int[][] mat1 = {{1, 2}, {4, 5}};
        int[][] mat2 = {{3, 8}, {6, 7}};

        int[][] result = addMatrices(mat1, mat2);
        printMatrix(result);
    }
    public static int[][] addMatrices(int[][] mat1, int[][] mat2) {
        int r = mat1.length;
        int c = mat2.length;
        int[][] result = new int[r][c];

           for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                result[i][j] = mat1[i][j] + mat2[i][j];
            }
        }
        return result;
    }
      public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}