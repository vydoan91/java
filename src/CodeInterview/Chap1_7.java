package CodeInterview;

public class Chap1_7 {
    static void rotate(int N, int[][] mat) {
        for(int x = 0; x < N / 2; x++) {
            for(int y = x; y < N - 1 - x; y++) {
                int temp = mat[x][y];
                mat[x][y] = mat[y][N-1-x];
                mat[y][N-1-x] = mat[N-1-x][N-1-y];
                mat[N-1-x][N-1-y] = mat[N-1-y][x];
                mat[N-1-y][x] = temp;
            }
        }
    }

    static void display(int[][] mat) {
        for(int row = 0; row < mat.length; row++) {
            for(int col = 0; col < mat[row].length; col++) {
                System.out.print(mat[row][col] + " ");
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }

    public static void main(String[] args) {
//        int[][] mat = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int[][] mat = {{1,2,3},{4,5,6},{7,8,9}};
        rotate(3, mat);
        display(mat);
    }
}
