public class Solution {
    public int singleNumber_old(int[] nums) {
        int rlt = 0;
        for(int i=0;i<32;i++) {
            int count = 0;
            for(int tmp : nums) {
                count=count+(tmp >> i) & 1;
            }
            count %= 2;
            rlt = rlt | (count << i);
        }
        return rlt;
    }

    public int singleNumber(int[] nums) {
        int rlt = 0;
        for(int tmp : nums) {
            rlt ^= tmp;
        }

        return rlt;
    }

    Public static void main(String[] args) {
        Solution tester = new Solution();

        int rlt = tester.singleNumber(new int[]{4, 2, 2});
        System.out.println(rlt);

        rlt = tester.singleNumber(new int[]{6, 2, 2, 5, 5, 7, 9, 9, 7});
        System.out.println(rlt);
    }

    
}
