
public class Solution {

    public int[] countBits(int n) {
        int[] dp = new int[n + 1];
        for(int i=1;i<=n;i++) {
            dp[i] = dp[i & (i-1)] + 1;
            System.out.printf("%s:%s\n", i, (i & (i-1)));
        }
        return dp;
    }

    public static void main(String[] args) {
       Solution tester = new Solution();
       int[] rlts = tester.countBits(10);
       for(int rlt : rlts) {
        System.out.println(rlt);
       } 
    }
    
}
