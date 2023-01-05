public class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length <= 1) {
            return 0;
        }

        int cools_now = 0;
        int buys_now = 0 - prices[0];
        int sells_now = Integer.MIN_VALUE;

        int cools_pre = cools_now;
        int buys_pre = buys_now;
        int sells_pre = sells_now;

        for(int i=1;i<prices.length;i++) {
            cools_now = Math.max(cools_pre, sells_pre);
            buys_now = Math.max(cools_pre - prices[i], buys_pre);
            sells_now = buys_pre + prices[i];

            cools_pre = cools_now;
            buys_pre = buys_now;
            sells_pre = sells_now;
        }


        return Math.max(cools_now, sells_now);
    }

    public static void main(String[] args) {
        Solution692 ins = new Solution692();

        System.out.println(ins.maxProfit(new int[]{1,2,3,0,2}));
        System.out.println(ins.maxProfit(new int[]{1,2}));
        System.out.println(ins.maxProfit(new int[]{1}));
    }
}
