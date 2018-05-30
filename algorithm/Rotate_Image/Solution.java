class Solution {
    public void rotate(int[][] matrix) {
        if(matrix.length <= 1) {
            return;
        }

        int size = matrix.length;
        int nextRow, nextCol;

        int beginIdx = 0;
        int beginRow, beginCol;
        int preEleVal;
        int tmp;
        while(size>1) {
            nextRow = nextCol = beginIdx;
            beginRow = beginIdx;
            beginCol = beginIdx;
            
            for(int i=0;i<size-1;i++) {
                beginCol=beginIdx+i;

                nextRow = beginRow;
                nextCol = beginCol;
                preEleVal = matrix[beginRow][beginCol];
                while(true) {
                    // get the next row and column
                    if(nextRow == beginRow) {
                        nextCol+=(size -1);

                        if(nextCol>(beginIdx + size - 1)) {
                            
                            nextRow+=(nextCol - beginIdx -  size + 1);
                            nextCol = beginIdx + size - 1;
                        }
                    } else if(nextCol == (beginIdx + size - 1)) {
                        nextRow+=(size - 1);

                        if(nextRow > (beginIdx + size - 1)) {
                            nextCol-=(nextRow - beginIdx - size + 1);
                            nextRow = beginIdx + size - 1;
                        }
                    } else if(nextRow == (beginIdx + size -1)) {
                        nextCol-=(size - 1);

                        if(nextCol < beginIdx) {

                            nextRow -=(beginIdx - nextCol);
                            nextCol = beginIdx;
                        }
                    } else if(nextCol == beginIdx) {
                        nextRow -=(size -1);

                        if(nextRow < beginIdx) {

                            nextCol+=(beginIdx - nextRow);
                            nextRow = beginIdx;
                        }
                    }

                    System.out.printf("size:%d#beginRow:%d#beingCol:%d#nextRow:%d#nextCol:%d\n",size, beginRow, beginCol, nextRow, nextCol);
                    tmp=matrix[nextRow][nextCol];
                    matrix[nextRow][nextCol] = preEleVal;
                    preEleVal = tmp;

                    
                    if(nextRow == beginRow
                       && nextCol == beginCol) {
                        break;
                    }
                }
            }
            size-=2;
            beginIdx++;
        }
    }

    public static void main(String[] args) {
        Solution ins = new Solution();
        int[][] matrix = new int[3][3];

        matrix[0] = new int[]{1, 2, 3};
        matrix[1] = new int[]{4, 5, 6};
        matrix[2] = new int[]{7, 8, 9};

        ins.rotate(matrix);

        for(int[] row : matrix) {
            for(int col : row) {
                System.out.printf("%d ", col);
            }
            System.out.printf("\n");
        }
    }
}
