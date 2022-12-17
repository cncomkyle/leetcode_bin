class Solution {
    public int findUnsortedSubarray(int[] nums) {
        if(nums.length == 0) return 0;
        
        int low2high = 0;
        int high2low = nums.length - 1;
        boolean low2highFlag = false;
        boolean high2lowFlag = false;
        int minVal = 0;
        int maxVal = 0;


        for(int i=0, j=nums.length -1;i<nums.length  && j>=0;i++, j--){

            if(i < nums.length - 1 && nums[i] > nums[i+1] && !low2highFlag) {
                low2high = i;
                low2highFlag = true;
                minVal = nums[i + 1];
            }
            
            if(j > 0 && nums[j] < nums[j - 1] && !high2lowFlag) {
                high2low = j;
                high2lowFlag = true;
                maxVal = nums[j -1];
            }

            if(low2highFlag && j >= low2high) {
                minVal = Math.min(minVal, nums[j]);
                maxVal = Math.max(maxVal, nums[j]);
            }

            if(high2lowFlag && i <= high2low) {
                maxVal = Math.max(maxVal, nums[i]);
                minVal = Math.min(minVal, nums[i]);
            }
        }

        System.out.printf("1st :low2high: %d, high2low: %d, minVal : %d, maxVal : %d\n", low2high, high2low, minVal, maxVal);
        if(!low2highFlag && !high2lowFlag) {
            return 0;
        }

        for(int i=0;i<low2high;i++) {
            if(nums[i] > minVal) {
                low2high = i;
                break;
            }
        }

        if(high2low < nums.length -1
           && nums[nums.length - 1] < maxVal) {
            high2low = nums.length - 1;
        } else {
            for(int i=high2low + 1;i<nums.length;i++) {
                if(nums[i] >= maxVal) {
                    high2low = i - 1;
                    break;
                }
            }
        }


        System.out.printf("final :low2high: %d, high2low: %d\n", low2high, high2low);
        return high2low - low2high + 1;
    }

    public static void main(String[] args) {
        Solution ins = new Solution();

        // System.out.println(ins.findUnsortedSubarray(new int[]{2, 6, 4, 8, 10, 9, 15}));
        // System.out.println(ins.findUnsortedSubarray(new int[]{1, 2, 3, 4}));
        // System.out.println(ins.findUnsortedSubarray(new int[]{2,1,1,1,1}));
        // System.out.println(ins.findUnsortedSubarray(new int[]{2, 3, 3, 2, 4}));
        // System.out.println(ins.findUnsortedSubarray(new int[]{1, 2, 4, 5, 3}));
        // System.out.println(ins.findUnsortedSubarray(new int[]{1, 3, 5, 4, 2}));
        // System.out.println(ins.findUnsortedSubarray(new int[]{1, 4, 5, 3, 2}));
        // System.out.println(ins.findUnsortedSubarray(new int[]{2,6,4,8,10,9,15}));
        // System.out.println(ins.findUnsortedSubarray(new int[]{4, 2, 1, 3, 5}));
        // System.out.println(ins.findUnsortedSubarray(new int[]{1,2,3,4,5,65,45,23,23,23,44,100,101,102,103,342,512,312,423,454,623,231,111,235,1001,1002,1003,1004}));
        // System.out.println(ins.findUnsortedSubarray(new int[]{1, 3, 2, 3, 3}));
        System.out.println(ins.findUnsortedSubarray(new int[]{1,2,3,4,5,5,4,3,2,1,1,2,3,4,5}));
    }
}
