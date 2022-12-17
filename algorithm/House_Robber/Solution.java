public class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        if(nums.length == 1) {
            return nums[0];
        }

        int[] dp = new int[nums.length];
        dp[0]=nums[0];
        dp[1]=Math.max(dp[0], nums[1]);

        int max = Math.max(dp[0], dp[1]);

        for(int i=2;i<nums.length;i++) {
            dp[i] = dp[i -2] + nums[i];
            max = Math.max(max, dp[i]);
            dp[i] = max;
        }

        return max;
    }

    public static void main(String[] args) {
        Solution ins = new Solution();
        System.out.println(ins.rob(new int[]{1, 2, 3, 1}));
        System.out.println(ins.rob(new int[]{2,7,9,3,1}));
        System.out.println(ins.rob(new int[]{2,1,1,2}));

        System.out.println(ins.rob(new int[]{1,3,1,3,100}));
    }
}
