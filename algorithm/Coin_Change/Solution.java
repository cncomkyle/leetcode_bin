import java.util.Arrays;

public class Solution {
    public int coinChange_old(int[] coins, int amount) {
        if(coins.length == 0) {
            return -1;
        }

        int[] dps = new int[amount + 1];
        Arrays.fill(dps, amount + 1);
        dps[0] = 0;

        for(int i=1;i<=amount;i++) {
            int min = 0;
            for(int j=0;j<coins.length;j++) {
                if(i >= coins[j]) {
                    dps[i] = Math.min(dps[i], dps[i-coins[j]] + 1);
                }
            }
        }

        return dps[amount] > amount ? -1 : dps[amount];
    }


    public int coinChange(int[] coins, int amount) {
        if(coins.length == 0) {
            return -1;
        }

        int[] dps = new int[amount + 1];
        Arrays.fill(dps, -1);
        dps[0] = 0;

        for(int i=1;i<=amount;i++) {
            int min = amount;
            for(int j=0;j<coins.length;j++) {
                int tmp = i - coins[j];
                if(tmp >=0 && dps[tmp] >= 0) {
                    min = Math.min(min, dps[i - coins[j]]);
                }
            }

            dps[i] = min >= amount ? -1 : min + 1;
        }

        return dps[amount];
    }


    public static void main(String[] args) {
        Solution692 ins = new Solution692();

        System.out.println(ins.coinChange(new int[]{1, 2, 5}, 11));
        System.out.println(ins.coinChange(new int[]{2}, 3));
        System.out.println(ins.coinChange(new int[]{2}, 4));
    }
}
