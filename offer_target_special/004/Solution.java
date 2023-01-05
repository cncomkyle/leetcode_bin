

public class Solution {

    public int singleNumber(int[] nums) {
        int ans = 0;
        for(int i =0; i < 32; i++) {
           int cnt = 0;
           for(int num : nums) {
            cnt += num >> i &1;
           } 
           cnt %= 3;
           ans |= cnt << i;
        }
        return ans;
    }
    
    public static void main(String[] args) {
        Solution tester = new Solution();
        int rlt = tester.singleNumber(new int[]{2, 2, 3, 2});
        System.out.println(rlt);
    }
}
