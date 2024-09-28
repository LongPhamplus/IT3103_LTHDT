import java.util.*;

public class addMatrices {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Get matrix size: ");
        int n = input.nextInt(), m = input.nextInt();

        int[][] matrix1 = new int[n][m], matrix2 = new int[n][m];

        System.out.printf("Get the elements of matrix1 height = %d, width = %d: \n", n, m);
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                matrix1[i][j] = input.nextInt();
            }
        }
        System.out.printf("Get the elements of matrix2 height = %d, width = %d: \n", n, m);
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                matrix2[i][j] = input.nextInt();
            }
        }
        System.out.println("Matrix after add: \n");
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                int sum = matrix1[i][j] + matrix2[i][j];
                System.out.print(sum + " ");
            }
            System.out.print("\n");
        }
    }
}
