import java.util.*;

public class Solution {

    public int subarraySum_old(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        int ans = 0, sum = 0;
        map.put(0, 1);

        for(int num : nums) {
            sum += num;
            ans += map.getOrDefault(sum - k, 0);
            map.merge(sum, 1, Integer::sum);
        }
        return ans;
    }

    public int subarraySum(int[] nums, int k) {
        int count = 0;
        for (int start = 0; start < nums.length; ++start) {
            int sum = 0;
            for (int end = start; end >= 0; --end) {
                sum += nums[end];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

    public int subarraySum(int[] nums, int k) {
        int count = 0, pre = 0;
        HashMap<Integer, Integer> mp = new HashMap<>();
        mp.put(0, 1);
        for(int i=0;i<nums.length;i++) {
            pre+=nums[i];
            if(mp.containsKey(pre-k)) {
                count += mp.get(pre-k);
            }
            mp.put(pre, mp.getOrDefault(pre, 0) + 1);
        }
        return count;
    }


    public static void main(String[] args) {
        Solution tester = new Solution();
        int rlt = tester.subarraySum(new int[]{1, 2, 3}, 3);
        System.out.println(rlt);
    }
}
