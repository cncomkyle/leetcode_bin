public class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix.length==0) return 0;
        
        int[] dp = new int[matrix[0].length];

        int maxLength = 0;
        int prev = 0;
        for(int i=0;i<matrix.length;i++) {
            prev = 0;
            for(int j=0;j<matrix[i].length;j++) {
                int temp = dp[j];
                if(matrix[i][j] == '0') {
                    dp[j] = 0;
                    prev = temp;
                    continue;  
                } 
                if(j==0) {
                    dp[j] = 1;
                } else {
                    dp[j] = Math.min(Math.min(dp[j-1], prev), dp[j]) + 1;
                }
                maxLength = Math.max(dp[j], maxLength);
                prev = temp;
            }
        }

        return maxLength * maxLength;
    }

    public static void main(String[] args) {
        Solution692 ins = new Solution692();

        char[][] matrix = {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
        System.out.println(ins.maximalSquare(matrix));

        char[][] matrix_2 = {{'1','0','1','0'},{'1','0','1','1'},{'1','0','1','1'},{'1','1','1','1'}};
        System.out.println(ins.maximalSquare(matrix_2));
    }
}
