class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length==0) {
            return false;
        }
        if(nums[0]>=nums.length - 1) {
            return true;
        }
        int[] flags = new int[nums.length];
        for(int i=0;i<nums.length - 1;i++) {
            if(nums[i]==0) {
                continue;
            }
            if(i>0 && flags[i]==0) {
                return false;
            }
            if(nums[i]>=(nums.length-1-i)) {
                return true;
            }
            for(int j=1;j<=nums[i];j++) {
                flags[i+j]=1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Solution692 ins = new Solution692();

        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(ins.canJump(nums));
        nums = new int[]{3, 2, 1, 0, 4};
        System.out.println(ins.canJump(nums));
    }
}
