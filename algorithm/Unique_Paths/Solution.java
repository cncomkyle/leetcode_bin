import java.util.List;
import java.util.ArrayList;

class Solution {
    public void gotoPath(int m, int n, int row, int col, List<String> rltList) {
        //System.out.printf("row:%d, col:%d\n", row, col);
        if((row == m -1) 
           ||(col == n -1)) {
            rltList.add("1");
            return;
        }
        
        // move Down
        gotoPath(m, n, row+1, col, rltList);
        // move right
        gotoPath(m, n, row, col+1, rltList);
        
    }
    public int uniquePaths(int m, int n) {
        if(m==0 || n==0) {
            return 0;
        }
        if(m==1 || n==1) {
            return 1;
        }
        List<String> rltList = new ArrayList<String>();
        gotoPath(m, n, 0, 0, rltList);
        return rltList.size();
    }

    public static void main(String[] args) {
        Solution692 ins = new Solution692();

        System.out.println(ins.uniquePaths(3, 2));
        System.out.println(ins.uniquePaths(7, 3));
        System.out.println(ins.uniquePaths(5, 5));
        System.out.println(ins.uniquePaths(6, 6));
    }
    
}
