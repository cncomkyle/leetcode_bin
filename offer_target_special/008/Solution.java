

public class Solution {

    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int ans = Integer.MAX_VALUE;
        int sum = 0;
        int left = 0, right = 0;

        while(right < n) {
            sum += nums[right++];
            while(sum >= target) {
                ans = Math.min(ans, right - left);
                sum -= nums[left++];
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
            
    }

    public static void main(String[] args) {
        Solution tester = new Solution();
        int rlt = tester.minSubArrayLen(7, new int[]{2,3,1,2,4,3});
        System.out.println(rlt);
    }
    
}
