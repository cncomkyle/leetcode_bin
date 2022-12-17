import java.util.Arrays;

public class Solution {
    public void printDP(int[] dps) {
        for(int dp : dps) {
            System.out.printf("%d,", dp);
        }
        System.out.println("");
    }
    
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;
        for (int num : nums) {
            int i = Arrays.binarySearch(dp, 0, len, num);
            System.out.printf("i:%d, len:%d ->",i, len);
            printDP(dp);
            if (i < 0) {
                i = -(i + 1);
            }
            dp[i] = num;
            if (i == len) {
                len++;
            }
        }
        return len;
    }

    public static void main(String[] args) {
        Solution ins = new Solution();
        System.out.println(ins.lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
    }
}
