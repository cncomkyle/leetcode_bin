class Solution2 {
     public boolean canJump(int[] nums) {
        if(nums.length==0) {
            return false;
        }
        if(nums[0]>=nums.length - 1) {
            return true;
        }
        int lastIndex=nums.length-1;
        for(int i=nums.length-2;i>=0;i--) {
           
            if(nums[i]>=(lastIndex-i)) {
                lastIndex=i;
            }
        }

        return lastIndex==0;
    }

    public static void main(String[] args) {
        Solution2 ins = new Solution2();

        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(ins.canJump(nums));
        nums = new int[]{3, 2, 1, 0, 4};
        System.out.println(ins.canJump(nums));
    }
}
