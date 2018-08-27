import java.util.ArrayList;

/**
 * @Author wangwenan
 * @data 2018/8/15 9:30
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
public class _19_PrintMatrixClockwise {

    public ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<Integer>() ;
        if(matrix==null || matrix.length==0) { return result ; }

        printMatrixClock_rowWisely(matrix, 0, 0, matrix.length - 1, matrix[0].length - 1, result);

        return result ;
    }

    // 递归打印每一圈
    public void printMatrixClock_rowWisely(int[][] matrix, int startRow, int startCol, int endRow, int endCol, ArrayList<Integer> result) {
        if(startRow<endRow && startCol<endCol) {
            for(int j_col=startCol; j_col<=endCol; j_col++) { result.add(matrix[startRow][j_col]) ; }   //Right
            for(int i=startRow+1; i<=endRow-1; i++) { result.add(matrix[i][endCol]) ; }     //Down
            for(int j_col=endCol; j_col>=startCol; j_col--) { result.add(matrix[endRow][j_col]) ; }     //Left
            for(int i=endRow-1; i>=startRow+1; i--) { result.add(matrix[i][startCol]) ; }   //Up
            printMatrixClock_rowWisely(matrix, startRow + 1, startCol + 1, endRow - 1, endCol - 1, result) ;
        }else if(startRow==endRow && startCol<endCol) {
            for(int j_col=startCol; j_col<=endCol; j_col++) { result.add(matrix[startRow][j_col]) ; }
        }else if(startRow<endRow && startCol==endCol) {
            for(int i=startRow; i<=endRow; i++) { result.add(matrix[i][endCol]) ; }
        }else if(startRow==endRow && startCol==endCol) {
            result.add(matrix[startRow][startCol]) ;
        }else {
            return ;
        }
    }

    public static ArrayList<Integer> printMatrix1(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<>();
        int row = matrix.length;
        int col = matrix[0].length;
        // 手工计算打印的圈数
        int circle = ((row < col ? row : col) - 1) / 2 + 1;

        for(int i  = 0; i < circle; i++) {
            // 从左到右
            for(int j_col = i; j_col < col-i; j_col++) {
                result.add(matrix[i][j_col]);
            }
            // 从上到下
            for(int k_row = i+1; k_row < row-i; k_row++) {
                result.add(matrix[k_row][col-i-1]);
            }
            // 从右到左 (row-i-1 != i)条件防止当前圈只有一行时重复打印
            for(int m_col = col-i-2; (m_col >= i) && (row-i-1 != i); m_col--) {
                result.add(matrix[row-i-1][m_col]);
            }
            // 从下到上 (col-i-1 != i)条件防止当前圈只有一列时重复打印
            for(int n_row = row-i-2; (n_row >= i+1) && (col-i-1 != i); n_row--) {
                result.add(matrix[n_row][i]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
//                {4, 5, 6}
        };
        ArrayList<Integer> res = printMatrix1(matrix);
        for(int x : res) {
            System.out.println(x);
        }
    }

}
