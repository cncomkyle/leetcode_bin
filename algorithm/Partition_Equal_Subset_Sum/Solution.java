import java.util.Arrays;

public class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
    
        for (int num : nums) {
            sum += num;
        }
    
        if ((sum & 1) == 1) {
            return false;
        }
        sum /= 2;
    
        int n = nums.length;
        boolean[] dp = new boolean[sum+1];
        Arrays.fill(dp, false);
        dp[0] = true;
    
        for (int num : nums) {
            for (int i = sum; i > 0; i--) {
                if (i >= num) {
                    dp[i] = dp[i] || dp[i-num];
                }
            }
        }
    
        return dp[sum];
    }

    public static void main(String[] args) {
        Solution692 ins = new Solution692();

        System.out.println(ins.canPartition(new int[]{1, 5, 11, 5}));
        System.out.println(ins.canPartition(new int[]{1, 2, 3, 5}));
    }
}
