public class Solution {
    public int singleNumber(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length % 2 ==0) return 0;

        int result = 0;
        for(int tmp : nums) {
            result = result ^ tmp;
        }

        return result;
    }

    public static void main(String[] args) {
        Solution ins = new Solution();
        System.out.println(ins.singleNumber(new int[]{2,2,1}));
        System.out.println(ins.singleNumber(new int[]{4,1,2,1,2}));
    }
}
