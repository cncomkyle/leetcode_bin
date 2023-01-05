public class Solution {
    public int maxProduct_old(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }

        int maxNum = nums[0];
        int zeroFlag = 0;

        for(int i=1;i<nums.length;i++) {

            if(nums[i] > maxNum) {
                maxNum = nums[i];
            }
            
            if(nums[i] == 0) {
                zeroFlag = i;
            }
            
            
            for(int j= zeroFlag;j<i;j++) {

                nums[j]*=nums[i];

                if(nums[j] > maxNum) {
                    maxNum = nums[j];
                }
            }
        }

        return maxNum;
    }

    public int maxProduct(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }
        int iMax,iMin, maxNum;

        iMax = iMin = maxNum = nums[0];
        int tmp;
        for(int i=1;i<nums.length;i++) {
            if(nums[i] < 0) {
                tmp = iMax;
                iMax = iMin;
                iMin = tmp;
            } 

            iMax = Math.max(nums[i], iMax * nums[i]);
            iMin = Math.min(nums[i], iMin * nums[i]);

            maxNum = Math.max(iMax, maxNum);
        }

        return maxNum;
    }

    public static void main(String[] args) {
        Solution692 ins = new Solution692();
        System.out.println(ins.maxProduct(new int[]{2,3,-2,4}));

        System.out.println(ins.maxProduct(new int[]{-2, 0, -1}));

        System.out.println(ins.maxProduct(new int[]{1,0,-1,2,3,-5,-2}));

    }
}
