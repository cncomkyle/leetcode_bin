public class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        int tmp = 0;
        for(int i=1;i<=n;++i) {
            int min = Integer.MAX_VALUE;
            int j = 1;
            while(true) {
                tmp = i - j * j;
                if(tmp < 0) break;
                min = Math.min(min, dp[tmp] + 1);
                ++j;
            }
            dp[i] = min;
        }

        return dp[n];
    }

    public static void main(String[] args) {
        Solution ins = new Solution();
        System.out.println((int)Math.floor(Math.sqrt(12)));

        System.out.println(ins.numSquares(12));
        System.out.println(ins.numSquares(13));
    }
}
