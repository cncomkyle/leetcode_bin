class Solution {
    public int minPathSum(int[][] grid) {
        int row=grid.length;
        if(row==0) {
            return 0;
        }
        int col=grid[0].length;
        if(col==0) {
            return 0;
        }

        int[] pathSum=new int[col];
        int preVal =0;
        for(int i=0;i<col;i++) {
            pathSum[i]=grid[0][i]+preVal;
            preVal = pathSum[i];
        }
        for(int i=1;i<row;i++) {
            pathSum[0]+=grid[i][0];
            for(int j=1;j<col;j++) {
                if(pathSum[j]<=pathSum[j-1]) {
                    pathSum[j]+=grid[i][j];
                } else {
                    pathSum[j]=pathSum[j-1]+grid[i][j];
                }
            }
        }

        return pathSum[col-1];
    }

    public static void main(String[] args) {
        Solution692 ins = new Solution692();
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(ins.minPathSum(grid));
    }
}
