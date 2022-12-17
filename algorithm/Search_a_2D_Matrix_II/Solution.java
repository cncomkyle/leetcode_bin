public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        if(rows == 0) {
            return false;
        }
        int cols = matrix[0].length;
        if(cols == 0) {
            return false;
        }

        int row = 0;
        int col = cols - 1;
        while(row < rows && col >=0 ) {
            int tmp = matrix[row][col];
            if(tmp == target) {
                return true;
            } else if(tmp < target) {
                row++;
            } else {
                col--;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Solution ins = new Solution();

        int[][] matrix_1 = {{1,   4,  7, 11, 15}, {2,   5,  8, 12, 19}, {3,   6,  9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};

        System.out.println(ins.searchMatrix(matrix_1, 5));
        System.out.println(ins.searchMatrix(matrix_1, 20));

        int[][] matrix_2 = {{-5}};
        System.out.println(ins.searchMatrix(matrix_2, -10));
    }
}
