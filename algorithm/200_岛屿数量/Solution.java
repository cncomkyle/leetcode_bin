public class Solution {

    public void markEle(char[][] grid, int row, int col, char mark, int rowNum, int colNum) {
        if(row < 0 || row == rowNum || col < 0 || col == colNum) {
            return;
        }
        if(grid[row][col] == mark) {
            return;
        }

        if(grid[row][col] == '0') {
            return;
        }
        

        if(grid[row][col] == '1') {
            grid[row][col] = mark;
        }
        
        // up
        markEle(grid, row+1, col, mark, rowNum, colNum);
        // down
        markEle(grid, row-1, col, mark, rowNum, colNum);
        // left
        markEle(grid, row, col - 1, mark, rowNum, colNum);
        // right
        markEle(grid, row, col + 1, mark, rowNum, colNum);
    }

    public int numIslands(char[][] grid) {
        int rltNum = 1;
        int rowNum = grid.length;
        int colNum = grid[0].length;
        
        for(int row=0;row<rowNum;row++) {
            for(int col=0;col<colNum;col++) {
                if(grid[row][col] == '1') {
                    rltNum++;
                    markEle(grid, row, col, (char)('0' + rltNum), rowNum, colNum);
                }
            }
        }

        System.out.println("==");
        printGrid(grid);
        
        return rltNum - 1;
    }
    
    public int numIslands_old(char[][] grid) {
        int rltNum = 1;
        int rowNum = grid.length;
        int colNum = grid[0].length;
        
        for(int row=0;row<rowNum;row++) {
            for(int col=0;col<colNum;col++) {
                if(grid[row][col] !='0') {
                    if(grid[row][col] == '1') {
                        if(col + 1 < colNum) {
                            if(grid[row][col+1] != '1' && grid[row][col+1] != '0') {
                                grid[row][col] = grid[row][col + 1];
                            } else {
                                rltNum++;
                                grid[row][col] = (char)('0' + rltNum);
                            }
                        } else {
                            rltNum++;
                            grid[row][col] = (char)('0' + rltNum);
                        }
                    }

                    if(row+1 < rowNum && grid[row+1][col] == '1') {
                        grid[row+1][col] = grid[row][col];
                    }
                    if(col +1 < colNum && grid[row][col+1] == '1') {
                        grid[row][col+1] = grid[row][col];
                    }
                }
            }
        }

        System.out.println("==");
        printGrid(grid);
        
        return rltNum - 1;
    }

    public void printGrid(char[][] grid) {
        int rowNum = grid.length;
        int colNum = grid[0].length;

        for(int row =0;row<rowNum;row++) {
            for(int col=0;col<colNum;col++) {
                System.out.printf("%c,", grid[row][col]);
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        Solution tester = new Solution();
        System.out.println(">>>>>>>>>>new test<<<<<<<<<<<<<");
        char[][] grid = new char[4][5];
        grid[0] = new char[]{'1','1','0','0','0'};
        grid[1] = new char[]{'1','1','0','0','0'};
        grid[2] = new char[]{'0','0','1','0','0'};
        grid[3] = new char[]{'0','0','0','1','1'};

        tester.printGrid(grid);

        int rlt = tester.numIslands(grid);
        System.out.println(rlt);

        System.out.println(">>>>>>>>>>new test<<<<<<<<<<<<<");

        grid = new char[3][3];
        grid[0] = new char[]{'1','1','1'};
        grid[1] = new char[]{'0','1','0'};
        grid[2] = new char[]{'1','1','1'};

        tester.printGrid(grid);

        rlt = tester.numIslands(grid);
        System.out.println(rlt);


        System.out.println(">>>>>>>>>>new test<<<<<<<<<<<<<");
        grid = new char[3][5];
        grid[0] = new char[]{'1','0','1', '1', '1'};
        grid[1] = new char[]{'1','0','1', '0', '1'};
        grid[2] = new char[]{'1','1','1', '0', '1'};

        tester.printGrid(grid);

        rlt = tester.numIslands(grid);
        System.out.println(rlt);
    }
}
