

public class Solution {

    public int numSubarrayProductLessThank(int[] nums, int k) {
        int n = nums.length;
        int ans = 0;
        int sum = 1;
        int left = 0, right = 0;

        while(right < n) {
            sum *= nums[right++];
            while(sum >=k && left < right) {
                sum /= nums[left++];
            }

            ans += right - left;
            System.out.printf("%d:%d -> %d\n", right, left, ans);
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution tester = new Solution();

        int rlt = tester.numSubarrayProductLessThank(new int[]{10, 5, 2, 6}, 100);
        System.out.println(rlt);
    }
    
}
