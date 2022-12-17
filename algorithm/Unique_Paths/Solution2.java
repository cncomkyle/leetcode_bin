class Solution2 {
    public int getSmallPath(int m, int n) {
        if(m== 1 || n == 1) {
            return 1;
        }

        return getSmallPath(m -1, n) + getSmallPath(m, n -1);
    }
    
    public int uniquePaths(int m, int n) {
        return getSmallPath(m, n);
    }

     public static void main(String[] args) {
        Solution2 ins = new Solution2();

        System.out.println(ins.uniquePaths(2, 2));

        System.out.println(ins.uniquePaths(3, 3));
        System.out.println(ins.uniquePaths(4, 4));
        System.out.println(ins.uniquePaths(5, 5));
        
    }
}
