public class Solution {
    public int numIslands_old(char[][] grid) {
        if(grid.length==0) {
            return 0;
        }
        int result = 0;

        char[] preRow = new char[grid[0].length];

        for(int i=0;i<preRow.length;i++) {
            preRow[i]='0';
        }

        for(int k=0;k<grid.length;k++) {
            char[] row = grid[k];
            for(int i=0;i<row.length;i++) {
                if(row[i] == '1') {
                    if(preRow[i] == '0'
                       &&(i == 0
                          || row[i - 1] == '0')) {
                        preRow[i]='*';
                        result++;
                    } else if(i>0 && (preRow[i -1] == '*' || preRow[i -1] == '#')) {
                        if((preRow[i -1] == '*' || preRow[i -1] == '#')
                           && (k>0 && grid[k-1][i-1] == '0')) {
                            preRow[i] = '1';
                            result --;
                        } else {
                            preRow[i] = '#';
                        }
                        
                    } else if((preRow[i] == '*' || preRow[i] == '#')&& (i==0 || row[i-1] == '0')) {
                        preRow[i] = '#';
                    } else if((preRow[i] == '*' || preRow[i] == '#') && i > 0 && row[i - 1] == '1') {
                        preRow[i] = '1';
                        result--;
                    } else {
                        preRow[i] = '1';
                    }
                } else {
                    preRow[i]='0';
                }

                
            }
            for(char tmpChar : preRow) {
                System.out.printf("%c,", tmpChar);
            }
            System.out.println("");
        }

        return result;
    }

    public int numIslands_2(char[][] grid) {
        if(grid.length==0) {
            return 0;
        }
        int result = 0;

        char[] preRow = new char[grid[0].length];

        for(int i=0;i<preRow.length;i++) {
            preRow[i]='0';
        }

        for(int k=0;k<grid.length;k++) {
            char[] row = grid[k];

            for(int i=0;i<row.length;i++) {
                if(row[i] == '1') {
                    if(preRow[i] == '0'
                       &&(i == 0
                          || row[i - 1] == '0')) {
                        preRow[i]='*';
                        result++;
                    } else if(i>0 && (preRow[i -1] == '*' || preRow[i-1] =='#')) {
                        if((preRow[i] == '*'
                            || preRow[i] == '#')
                           && (k>0 && grid[k-1][i-1]=='0')) {
                            if(result > 1) {
                                result--;
                            }
                            
                        }
                        preRow[i] = '#';
                        
                    } else if((preRow[i] == '*' || preRow[i] == '#') && (i==0 || row[i-1] == '0')) {
                        preRow[i] = '#';
                    } else {
                        preRow[i] = '1';
                    }
                } else {
                    preRow[i]='0';
                }

                
            }
            // for(char tmpChar : preRow) {
            //     System.out.printf("%c,", tmpChar);
            // }
            // System.out.println("");
        }

        return result;
    }

    public int numIslands(char[][] grid) {
        if(grid.length==0) {
            return 0;
        }
        int result = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        int[] preRow = new int[cols];


        for(int i=0;i<rows;i++) {
            for(int j=0;j<cols;j++) {
                if(grid[i][j] == '1') {
                    if(preRow[j]==0
                       &&(j==0 || grid[i][j -1] == '0')) {
                        preRow[j] = i * cols + j + 1;
                        result++;
                    } else if( j > 0 && grid[i][j-1] == '1') {
                        if(i>0 && grid[i-1][j] == '1' && preRow[j] != preRow[j -1]) {
                            result--;
                            
                            int min = Math.min(preRow[j], preRow[j - 1]);
                            int max = Math.max(preRow[j], preRow[j - 1]);
                            preRow[j] = min;
                            
                            for(int k=0;k<cols;k++) {
                                if(preRow[k] == max) {
                                    preRow[k] = min;
                                }
                            }
                        } else {
                            preRow[j] = preRow[j - 1];
                        }
                    } 
                } else {
                    preRow[j]=0;
                }
            }

            for(int tmp : preRow) {
                System.out.printf("%d,",tmp);
            }
            System.out.println("");
        }
        return result;
    }

    public static void main(String[] args) {
        Solution692 ins = new Solution692();
        // 1
        char[][] grid_1 = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        System.out.println(ins.numIslands(grid_1));
        // 3
        char[][] grid_2 = {{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
        System.out.println(ins.numIslands(grid_2));
        // 0
        char[][] grid_3 = {};
        System.out.println(ins.numIslands(grid_3));
        // 1
        char[][] grid_4 = {{'1','1','1'}, {'0', '1', '0'}, {'1', '1', '1'}};
        System.out.println(ins.numIslands(grid_4));
        // 1
        char[][] grid_5 = {{'1','1','1'}, {'1', '0', '1'}, {'1', '1', '1'}};
        System.out.println(ins.numIslands(grid_5));
        // 1
        char[][] grid_6 = {{'1','0','1','1','1'},{'1','0','1','0','1'},{'1','1','1','0','1'}};
        System.out.println(ins.numIslands(grid_6));
    }
}
