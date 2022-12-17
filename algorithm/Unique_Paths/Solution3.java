import java.util.Arrays;

class Solution3 {
   
    
    public int uniquePaths(int m, int n) {
        if(m < n) {
            int tmp = m;
            m = n;
            n = tmp;
        }

        int[] pathCounts = new int[n];
        Arrays.fill(pathCounts, 1);

        for(int i=1;i<m;i++) {
            for(int j=1;j<n;j++) {
                pathCounts[j]+=pathCounts[j-1];
            }
        }
        return pathCounts[n-1];
    }

     public static void main(String[] args) {
        Solution3 ins = new Solution3();

        System.out.println(ins.uniquePaths(3, 2));
        System.out.println(ins.uniquePaths(7, 3));
        System.out.println(ins.uniquePaths(3, 3));
        System.out.println(ins.uniquePaths(51, 9));
        
    }
}
