package CodeInterview;

public class Chap1_8 {
    static void setZeros(int[][] mat) {
        boolean row[] = new boolean[mat.length];
        boolean col[] = new boolean[mat[0].length];
        for(int i = 0; i < mat.length; i++) {
            for(int j = 0; j < mat[i].length; j++) {
                if(mat[i][j] == 0) {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }

        for(int i = 0; i < row.length; i++) {
            if(row[i]) zeroRow(i, mat);
        }

        for(int i = 0; i < col.length; i++) {
            if(col[i]) zeroCol(i, mat);
        }
    }

    static void zeroRow(int rowNum, int[][] mat) {
        for(int i = 0; i < mat[rowNum].length; i++) {
            mat[rowNum][i] = 0;
        }
    }

    static void zeroCol(int colNum, int[][] mat) {
        for(int i = 0; i < mat.length; i++) {
            mat[i][colNum] = 0;
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
        int[][] mat = {{1,2,3,4},{5,0,7,8},{9,10,11,0}};
        display(mat);
        setZeros(mat);
        display(mat);

    }
}
