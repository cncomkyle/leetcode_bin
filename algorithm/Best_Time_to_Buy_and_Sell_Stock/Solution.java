public class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length == 0) return 0;
        int[] dp = new int[prices.length];
        int max = 0;
        dp[0] = prices[0];
        for(int i=1;i<prices.length;i++) {
            dp[i]=Math.min(dp[i-1], prices[i]);
            max = Math.max(max, prices[i] - dp[i]);
        }

        return max;
    }


    public static void main(String[] args) {
        Solution692 ins = new Solution692();
        System.out.println(ins.maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println(ins.maxProfit(new int[]{7,6,4,3,1}));
    }
    
}
