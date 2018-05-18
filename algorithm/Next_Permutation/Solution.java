class Solution {
    public void nextPermutation(int[] nums) {
        int breakIdx = -1;
        int tmp;
        for(int i = nums.length - 1;i>0;i--) {
            if(nums[i]>nums[i-1]) {
                breakIdx = i - 1;
                break;
            }
        }

        if(breakIdx >= 0) {
            int start = breakIdx + 1;
            int end = nums.length  - 1;
            int mid = start + (end - start) / 2;
            
            while(true) {

                if((nums[mid]>nums[breakIdx])
                   && (mid+1 == nums.length || nums[mid+1]<=nums[breakIdx])) {
                    tmp = nums[breakIdx];
                    nums[breakIdx] = nums[mid];
                    nums[mid] = tmp;
                    break;
                }
                if(nums[mid] > nums[breakIdx]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
                mid = start + (end - start) / 2;
            }
        }

        
        for(int i=breakIdx+1, j=nums.length -1;i<j;i++, j--) {
            tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }

    public static void main(String[] args) {
        Solution ins = new Solution();
        int[] nums = {1, 3, 2};

        nums = new int[]{1, 3, 5, 4, 2};
        nums = new int[]{1, 5, 1};
        ins.nextPermutation(nums);
        for(int tmp : nums) {
            System.out.printf("%d->", tmp);
        }
    }
    
}
