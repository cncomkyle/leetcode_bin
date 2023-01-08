public class Solution {
    public int maxSubArray_old(int[] nums) {
        int[] tmpArray = new int[nums.length];
        int max = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++) {
            tmpArray[i] = nums[i];
            max = Math.max(max, tmpArray[i]);
            for(int j=i+1;j<nums.length;j++) {
                tmpArray[j] = tmpArray[j-1] + nums[j];
                max = Math.max(max, tmpArray[j]);
            }
        }
        return max;
    }


    public int maxSubArray(int[] nums) {
        int maxRlt = nums[0], preMax = 0;
        for(int i=0;i<nums.length;i++) {
            preMax = Math.max(preMax + nums[i], nums[i]);
            maxRlt = Math.max(preMax, maxRlt);
        }

        return maxRlt;
    }

    public static void main(String[] args) {
        Solution tester = new Solution();
        int rlt = tester.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4});
        System.out.println(rlt);
    }
}
